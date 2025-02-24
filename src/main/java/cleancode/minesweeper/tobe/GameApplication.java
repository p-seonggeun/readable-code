package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.minesweeper.Minesweeper;
import cleancode.minesweeper.tobe.minesweeper.config.GameConfig;
import cleancode.minesweeper.tobe.minesweeper.gamelevel.Beginner;
import cleancode.minesweeper.tobe.minesweeper.io.ConsoleInputHandler;
import cleancode.minesweeper.tobe.minesweeper.io.ConsoleOutputHandler;

public class GameApplication {

    public static void main(String[] args) {
        GameConfig gameConfig = new GameConfig(
                new Beginner(),
                new ConsoleInputHandler(),
                new ConsoleOutputHandler());

        Minesweeper minesweeper = new Minesweeper(gameConfig);
        minesweeper.initialize();
        minesweeper.run();
    }

    /**
     * DIP (Dependency Inversion Principle): 고수준 모듈과 저수준 모듈이 직접적으로 의존하는 것이 아니라 추상화에 서로 의존해야한다.
     *
     * DI (Dependency Injection): 필요한 의존성을 내가 직접 생성하는 것이 아닌 외부에서 주입받겠다. 제 "3" 자가 두 객체간의 의존성을 맺어준다. 런타임 시점에 일어난다.
     *
     * IoC (Inversion of Control): 프로그램의 흐름을 개발자가 아닌 프레임워크가 담당
     * 순방향: 개발자가 프로그램 흐름을 제어
     */
}