package cleancode.studycafe.practice.model;

public enum StudyCafeLockerPassType {

    USE("사용"),
    NON_USE("미사용")
    ;

    private final String description;

    StudyCafeLockerPassType(String description) {
        this.description = description;
    }
}
