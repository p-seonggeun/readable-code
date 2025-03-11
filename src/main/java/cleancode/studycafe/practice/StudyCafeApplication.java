package cleancode.studycafe.practice;

import cleancode.studycafe.practice.io.ConsoleInputHandler;
import cleancode.studycafe.practice.io.ConsoleOutputHandler;
import cleancode.studycafe.practice.io.StudyCafeFileHandler;

public class StudyCafeApplication {

    public static void main(String[] args) {
        StudyCafeConfig config = new StudyCafeConfig(
                new ConsoleInputHandler(),
                new ConsoleOutputHandler(),
                new StudyCafeFileHandler(),
                new StudyCafeFileHandler()
        );

        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(config);
        studyCafePassMachine.run();
    }

}
