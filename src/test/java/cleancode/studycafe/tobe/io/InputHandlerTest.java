package cleancode.studycafe.tobe.io;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputHandlerTest {

    @DisplayName("사용자는 이용권 타입을 선택할 수 있다.")
    @Test
    void getPassTypeSelectingUserAction() {
        // Given
        String userInput = "1\n";  // 사용자가 "1"을 입력하는 상황
        InputHandler inputHandler = new InputHandler(new Scanner(new ByteArrayInputStream(userInput.getBytes())));

        // When
        StudyCafePassType passType = inputHandler.getPassTypeSelectingUserAction();

        // Then
        assertThat(passType).isEqualByComparingTo(StudyCafePassType.HOURLY);
    }

    @DisplayName("사용자가 잘못된 이용권 타입을 선택 시 예외가 발생한다.")
    @Test
    void getPassTypeSelectingUserActionWithInvalidInput() {
        // Given
        String userInput = "4\n";
        InputHandler inputHandler = new InputHandler(new Scanner(new ByteArrayInputStream(userInput.getBytes())));

        // When & Then
        assertThatThrownBy(() -> inputHandler.getPassTypeSelectingUserAction())
                .isInstanceOf(AppException.class)
                .hasMessage("잘못된 입력입니다.");
    }
}
