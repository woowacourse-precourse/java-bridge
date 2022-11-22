package bridge.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BasicBridgeInputNumericParserTest extends NsTest {

    @DisplayName("입력된 값이 숫자가 맞는지 확인하기 - 숫자가 아닌 경우 (공백)")
    @Test
    void checkBridgeLengthException1() {
        assertThatThrownBy(() -> BasicBridgeInputNumericParser.parseBridgeLengthAmount("  "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 값이 숫자가 맞는지 확인하기 - 숫자가 아닌 경우 (널)")
    @Test
    void checkBridgeLengthException2() {
        assertThatThrownBy(() -> BasicBridgeInputNumericParser.parseBridgeLengthAmount(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 값이 숫자가 맞는지 확인하기 - 숫자가 아닌 경우 (알파벳)")
    @Test
    void checkBridgeLengthException3() {
        assertThatThrownBy(() -> BasicBridgeInputNumericParser.parseBridgeLengthAmount("ab"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}