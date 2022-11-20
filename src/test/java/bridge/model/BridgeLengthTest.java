package bridge.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.Application;
import bridge.utils.BasicBridgeInputAlphabetParser;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeLengthTest extends NsTest {

    @DisplayName("사용자의 입력이 숫자 범위가 맞는가 - 더 작은 경우 ")
    @Test
    void checkBridgeLengthException1() {
        assertThatThrownBy(() -> BridgeLength.from(2))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 입력이 숫자 범위가 맞는가 - 더 큰 경우 ")
    @Test
    void checkBridgeLengthException2() {
        assertThatThrownBy(() -> BridgeLength.from(25))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}