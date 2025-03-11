package cleancode.studycafe.practice;

import cleancode.studycafe.practice.exception.AppException;
import cleancode.studycafe.practice.io.*;
import cleancode.studycafe.practice.model.*;

public class StudyCafePassMachine {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final StudyCafePassListHandler studyCafePassListHandler;
    private final StudyCafeLockerPassListHandler studyCafeLockerPassListHandler;

    public StudyCafePassMachine(StudyCafeConfig config) {
        this.inputHandler = config.getInputHandler();
        this.outputHandler = config.getOutputHandler();
        this.studyCafePassListHandler = config.getStudyCafePassListHandler();
        this.studyCafeLockerPassListHandler = config.getStudyCafeLockerPassListHandler();
    }

    public void run() {
        try {
            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();

            outputHandler.askPassTypeSelection();
            StudyCafePassType selectedPassType = inputHandler.getPassTypeSelectingUserAction();

            StudyCafePasses allStudyCafePasses = studyCafePassListHandler.readStudyCafePasses();
            StudyCafePasses candidatePasses = allStudyCafePasses.getCandidateStudyCafePassesFrom(selectedPassType);

            outputHandler.showPassListForSelection(candidatePasses);
            StudyCafePass selectedPass = inputHandler.getSelectPass(candidatePasses);

            StudyCafeLockerPasses allLockerPasses = studyCafeLockerPassListHandler.readLockerPasses();
            StudyCafeLockerPass candidateLockerPass = allLockerPasses.getCandidateStudyCafeLockerPass(selectedPass);

            StudyCafeLockerPassType selectedLockerPassType = null;
            if (candidateLockerPass != null) {
                outputHandler.askLockerPass(candidateLockerPass);
                selectedLockerPassType = inputHandler.getLockerSelection();
            }

            if (selectedLockerPassType == StudyCafeLockerPassType.USE) {
                outputHandler.showPassOrderSummary(selectedPass, candidateLockerPass);
            } else {
                outputHandler.showPassOrderSummary(selectedPass, null);
            }
        } catch (AppException e) {
            outputHandler.showExceptionMessage(e);
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

}
