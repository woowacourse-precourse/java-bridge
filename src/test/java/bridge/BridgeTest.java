package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;



class BridgeTest {
    @DisplayName("다리 길이는 입력이 3이상 20이하의 수가 아니면 에러가 발생한다.")
    @Test
    void createBridgeLengthVgalidateNumberRange() {
        assertThatThrownBy(() -> new Bridge(21))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BRIDGE_LENGTH_IS_THREE_TO_TWENTY.getErrorMessage());
    }

    @DisplayName("다리 길이는 입력이 3이상 20이하의 수일때 정상적으로 작동한다.")
    @ParameterizedTest
    @CsvSource({"3,3", "10,10", "20,20"})
    void createRightBridgeLength(int bridgeLength, int expected) {
        Bridge bridge = new Bridge(bridgeLength);
        assertThat(bridge.getBridgeLength()).isEqualTo(expected);
    }
}