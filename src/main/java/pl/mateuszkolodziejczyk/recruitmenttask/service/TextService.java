package pl.mateuszkolodziejczyk.recruitmenttask.service;

import org.springframework.stereotype.Service;
import pl.mateuszkolodziejczyk.recruitmenttask.domain.Word;
import pl.mateuszkolodziejczyk.recruitmenttask.domain.WordDetails;

import java.util.*;

@Service
public class TextService {

    public Map<String, WordDetails> analyzeToMap(String str) {
        String[] splitStr = splitString(str);
        Map<String, WordDetails> wordMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        for (int i = 0; i < splitStr.length; i++) {
            String word = splitStr[i];
            if (!wordMap.containsKey(word)) {
                WordDetails details = new WordDetails();
                details.incrementOccurrenceByOne();
                details.addPlace(i + 1);
                wordMap.put(word, details);
            } else {
                WordDetails details = wordMap.get(word);
                details.incrementOccurrenceByOne();
                details.addPlace(i + 1);
            }
        }
        return wordMap;
    }

    public List<Word> analyzeToList(String str) {
        String[] splitStr = splitString(str);
        List<Word> wordsList = new ArrayList<>();

        for (int i = 0; i < splitStr.length; i++) {
            String singleString = splitStr[i];
            Word word = new Word(singleString);
            if(!wordsList.contains(word)) {
                word.incrementOccurrenceByOne();
                word.addPlace(i + 1);
                wordsList.add(word);
            } else {
                Word wordToChange = wordsList.stream().filter(w -> w.equals(word)).findFirst().get();
                wordToChange.incrementOccurrenceByOne();
                wordToChange.addPlace(i + 1);
            }
        }
        Collections.sort(wordsList, Comparator.comparing(Word::getName, String.CASE_INSENSITIVE_ORDER));
        return wordsList;
    }

    private String[] splitString(String str) {
        return str.replaceAll("\\p{Punct}", "").trim().split("\\s+");
    }
}
