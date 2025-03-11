package cleancode.studycafe.practice.model;

import java.util.ArrayList;
import java.util.List;

public class StudyCafePasses {

    private final List<StudyCafePass> studyCafePasses;

    private StudyCafePasses(List<StudyCafePass> studyCafePasses) {
        this.studyCafePasses = studyCafePasses;
    }

    public static StudyCafePasses of(List<StudyCafePass> studyCafePasses) {
        return new StudyCafePasses(studyCafePasses);
    }

    public StudyCafePasses getCandidateStudyCafePassesFrom(StudyCafePassType passType) {
        List<StudyCafePass> studyCafePassList = studyCafePasses.stream()
                .filter(studyCafePass -> studyCafePass.getPassType() == passType)
                .toList();
        return of(studyCafePassList);
    }

    public List<StudyCafePass> getStudyCafePasses() {
        return new ArrayList<>(studyCafePasses);
    }

    public int size() {
        return studyCafePasses.size();
    }

    public StudyCafePass get(int index) {
        return studyCafePasses.get(index);
    }

    public boolean areSizeLessThan(int index) {
        return size() <= index;
    }
}
