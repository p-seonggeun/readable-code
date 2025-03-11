package cleancode.studycafe.practice.io;

import cleancode.studycafe.practice.model.StudyCafeLockerPassType;
import cleancode.studycafe.practice.model.StudyCafePass;
import cleancode.studycafe.practice.model.StudyCafePassType;
import cleancode.studycafe.practice.model.StudyCafePasses;

public interface InputHandler {

    StudyCafePassType getPassTypeSelectingUserAction();

    StudyCafePass getSelectPass(StudyCafePasses passes);

    StudyCafeLockerPassType getLockerSelection();
}
