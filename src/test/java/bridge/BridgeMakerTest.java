package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {

    @DisplayName("다리의 길이로 입력받은 값이 정수형인지 확인한다.")
    @Test
    void validate_is_Number_fail() {
        assertThatThrownBy(()-> new BridgeMaker("문자"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}