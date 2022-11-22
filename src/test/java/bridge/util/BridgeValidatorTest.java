package bridge.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeValidatorTest {
    @DisplayName("다리의 길이가 될 수 있는 수인지")
    @ParameterizedTest
    @ValueSource(strings = {"21"})
    void inputImpossibleSize(String input) {
        Assertions.assertThatThrownBy(() -> BridgeValidator.possibleBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("선택할 수 있는 방향인지")
    @ParameterizedTest
    @ValueSource(strings = {"UE"})
    void inputImpossibleMoving(String input) {
        Assertions.assertThatThrownBy(() -> BridgeValidator.possibleMovingSelect(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("선택할 수 있는 결정인지")
    @ParameterizedTest
    @ValueSource(strings = {"T"})
    void inputImpossibleDecision(String input) {
        Assertions.assertThatThrownBy(() -> BridgeValidator.possibleRetryDecision(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
