package bridge.validation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리의 길이 입력값이 숫자 이외의 값이 들어오면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1a34, ㄱ1ㄴㄷ, !1aㄴ, .12@3"})
    void createBridgeLengthNumOtherThanNum(String bridgeLength) {
        assertThatThrownBy(() -> Validation.checkBridgeLengthConsistOfNum(bridgeLength))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

}