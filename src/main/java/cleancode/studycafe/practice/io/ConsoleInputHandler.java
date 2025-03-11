package cleancode.studycafe.practice.io;

import cleancode.studycafe.practice.exception.AppException;
import cleancode.studycafe.practice.model.StudyCafeLockerPassType;
import cleancode.studycafe.practice.model.StudyCafePass;
import cleancode.studycafe.practice.model.StudyCafePassType;
import cleancode.studycafe.practice.model.StudyCafePasses;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public StudyCafePassType getPassTypeSelectingUserAction() {
        String userInput = SCANNER.nextLine();

        if ("1".equals(userInput)) {
            return StudyCafePassType.HOURLY;
        }
        if ("2".equals(userInput)) {
            return StudyCafePassType.WEEKLY;
        }
        if ("3".equals(userInput)) {
            return StudyCafePassType.FIXED;
        }
        throw new AppException("잘못된 이용권 타입을 선택하셨습니다.");
    }

    @Override
    public StudyCafePass getSelectPass(StudyCafePasses passes) {
        String userInput = SCANNER.nextLine();
        int selectedIndex = getSelectedIndex(userInput);
        if (passes.areSizeLessThan(selectedIndex)) {
            throw new AppException("입력은 이용권 목록 개수보다 클 수 없습니다.");
        }
        return passes.get(selectedIndex);
    }

    @Override
    public StudyCafeLockerPassType getLockerSelection() {
        String userInput = SCANNER.nextLine();
        if ("1".equals(userInput)) {
            return StudyCafeLockerPassType.USE;
        }
        if ("2".equals(userInput)) {
            return StudyCafeLockerPassType.NON_USE;
        }
        throw new AppException("잘못된 번호를 선택하셨습니다.");
    }

    private int getSelectedIndex(String userInput) {
        int selectedIndex = Integer.parseInt(userInput) - 1;
        if (selectedIndex < 0) {
            throw new AppException("입력은 0보다 커야합니다.");
        }
        return selectedIndex;
    }

}
