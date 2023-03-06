package pl.mateuszkolodziejczyk.recruitmenttask.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
public class Word {

    private String name;
    private int occurrence;
    private List<Integer> places = new ArrayList<>();

    public Word(String name) {
        this.name = name;
    }

    public void incrementOccurrenceByOne() {
        occurrence++;
    }

    public void addPlace(Integer integer) {
        places.add(integer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word = (Word) o;
        return Objects.equals(getName(), word.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}