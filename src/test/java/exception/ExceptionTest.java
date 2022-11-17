package exception;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExceptionTest {

    private static final String ERROR = "[ERROR]";

    private BridgeMaker bridgeMaker;
    private List<String> bridge;

    @BeforeEach
    void 객체_생성() {

        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(21);
    }

    @Test
    void 다리_길이_검증_테스트() {
        assertThatThrownBy(() -> Exception.bridgeLengthValidation(bridge.size()))
                .hasMessageContaining(ERROR + " 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }
}