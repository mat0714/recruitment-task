package pl.mateuszkolodziejczyk.recruitmenttask.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class WordDetails {

    private int occurrence;
    private List<Integer> places = new ArrayList<>();

    public void incrementOccurrenceByOne() {
        occurrence++;
    }

    public void addPlace(Integer integer) {
        places.add(integer);
    }
}