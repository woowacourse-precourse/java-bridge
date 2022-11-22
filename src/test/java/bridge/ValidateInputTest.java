package bridge;

import bridge.validate.ValidateInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateInputTest {
    private ValidateInput validateInput;

    @BeforeEach
    void setUp() {
        validateInput = new ValidateInput();
    }

    @DisplayName("다리 길이 유효성 검사 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2", "1", "30", "K"})
    void validateInputBridgeSizeFailTest(String bridgeSize) {
        assertThatThrownBy(() -> validateInput.validateInputBridgeSize(bridgeSize)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 이동 방향 유효성 검사 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2", "1", "30", "K", "T"})
    void validateInputBridgeSideTest(String bridgeSide) {
        assertThatThrownBy(() -> validateInput.validateInputBridgeSide(bridgeSide)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 이동 방향 유효성 검사 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2", "1", "30", "K", "T"})
    void validateInputGameCommandTest(String gameCommand) {
        assertThatThrownBy(() -> validateInput.validateInputGameCommand(gameCommand)).isInstanceOf(IllegalArgumentException.class);
    }


}
