package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafePassTypeTest {

    @DisplayName("1인 고정석은 사물함을 사용할 수 있다.")
    @Test
    void isLockerType() throws Exception {
        // Given
        StudyCafePassType passType = StudyCafePassType.FIXED;

        // When
        boolean result = passType.isLockerType();

        // Then
        assertThat(result).isTrue();
    }

    @DisplayName("1인 고정석이 아니면 사물함을 사용할 수 없다.")
    @Test
    void isNotLockerType() throws Exception {
        // Given
        StudyCafePassType passType1 = StudyCafePassType.HOURLY;
        StudyCafePassType passType2 = StudyCafePassType.WEEKLY;
        List<StudyCafePassType> passTypes = List.of(passType1, passType2);

        // When
        List<StudyCafePassType> result = passTypes.stream()
                .filter(passType -> passType.isNotLockerType())
                .toList();

        // Then
        assertThat(result).hasSize(2)
                .extracting("description")
                .containsExactlyInAnyOrder("시간 단위 이용권", "주 단위 이용권");
    }

}