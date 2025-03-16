package cleancode.studycafe.tobe.model.pass.locker;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafeLockerPassTest {
    
    @DisplayName("1인 고정석 4주권의 사물함 가격은 10,000원이다.")
    @Test
    void getPrice() throws Exception {
        // Given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 10000);

        // When
        int price = lockerPass.getPrice();

        // Then
        assertThat(price).isEqualTo(10000);
    }

}