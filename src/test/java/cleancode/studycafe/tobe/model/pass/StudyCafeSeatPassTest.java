package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafeSeatPassTest {

    @DisplayName("1인 고정석, 12주권 좌석권의 할인 금액은 105,000원이다.")
    @Test
    void getDiscountPrice() throws Exception {
        // Given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12, 700000, 0.15);

        // When
        int discountPrice = seatPass.getDiscountPrice();

        // Then
        assertThat(discountPrice).isEqualTo(105000);
    }

}