package cleancode.studycafe.practice.io;

import cleancode.studycafe.practice.exception.AppException;
import cleancode.studycafe.practice.model.StudyCafeLockerPass;
import cleancode.studycafe.practice.model.StudyCafePass;
import cleancode.studycafe.practice.model.StudyCafePasses;

public interface OutputHandler {

    void showWelcomeMessage();

    void showAnnouncement();

    void askPassTypeSelection();

    void showPassListForSelection(StudyCafePasses passes);

    void askLockerPass(StudyCafeLockerPass lockerPass);

    void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass);

    void showSimpleMessage(String message);

    void showExceptionMessage(AppException e);
}
