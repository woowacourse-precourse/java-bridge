package bridge.util.validator;

import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerValidatorTest {

    private static String error = "[ERROR]";

    @Test
    @DisplayName("다리 생성의 예외 테스트_1")
    void createBridgeTest1() {
        assertThatThrownBy(() -> new BridgeMakerValidator("21"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }

    @Test
    @DisplayName("다리 생성의 예외 테스트_2")
    void createBridgeTest2() {
        assertThatThrownBy(() -> new BridgeMakerValidator("2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }

    @Test
    @DisplayName("다리 생성의 예외 테스트_3")
    void createBridgeTest3() {
        assertThatThrownBy(() -> new BridgeMakerValidator(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }

    @Test
    @DisplayName("다리 생성의 예외 테스트_4")
    void createBridgeTest4() {
        assertThatThrownBy(() -> new BridgeMakerValidator("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }
}