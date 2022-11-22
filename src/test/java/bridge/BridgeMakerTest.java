package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BridgeMakerTest {
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private final String ERROR = "[ERROR]";

    @DisplayName("다리 길이 입력이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 다리길이로_문자입력() {
        assertThrows(IllegalArgumentException.class, () -> {
            bridgeMaker.validateIsNumeric("hello");
        }).getMessage().contains(ERROR);
    }

    @DisplayName("다리 길이 입력이 3부터 20 사이의 수가 아니면 예외가 발생한다.")
    @Test
    void 다리길이로_범위밖_숫자입력() {
        assertThrows(IllegalArgumentException.class, () -> {
            bridgeMaker.validateIsRightRange("2");
        }).getMessage().contains(ERROR);
    }

    @DisplayName("다리 길이 입력으로 3이상 20이하의 숫자를 입력한다.")
    @Test
    void 다리_길이_정상_입력() {
        assertThat(bridgeMaker.validateBridgeSize("15"));
    }
}
