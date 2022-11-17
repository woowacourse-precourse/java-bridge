package exception;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExceptionTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    void 객체_생성() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    void 다리_길이_검증_테스트() {
        List<String> bridge = bridgeMaker.makeBridge(21);
        assertThat(Exception.bridgeLengthValidation(bridge)).isFalse();
    }


}