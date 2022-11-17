package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {

    @DisplayName("다리의 길이로 입력받은 값이 정수형인지 확인한다.")
    @ValueSource(strings = {"문자","🍖"," ",""})
    @Test
    void validate_is_Number_fail(BridgeNumberGenerator input) {
        assertThatThrownBy(()-> new BridgeMaker(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}