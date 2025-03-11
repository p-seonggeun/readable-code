package cleancode.studycafe.practice;

import cleancode.studycafe.practice.io.*;

public class StudyCafeConfig {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final StudyCafePassListHandler studyCafePassListHandler;
    private final StudyCafeLockerPassListHandler studyCafeLockerPassListHandler;

    public StudyCafeConfig(InputHandler inputHandler, OutputHandler outputHandler, StudyCafePassListHandler studyCafePassListHandler, StudyCafeLockerPassListHandler studyCafeLockerPassListHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.studyCafePassListHandler = studyCafePassListHandler;
        this.studyCafeLockerPassListHandler = studyCafeLockerPassListHandler;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public OutputHandler getOutputHandler() {
        return outputHandler;
    }

    public StudyCafePassListHandler getStudyCafePassListHandler() {
        return studyCafePassListHandler;
    }

    public StudyCafeLockerPassListHandler getStudyCafeLockerPassListHandler() {
        return studyCafeLockerPassListHandler;
    }
}
