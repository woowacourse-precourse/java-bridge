package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setBridgeMaker() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("makeBridge()가 파라미터로 넣어준 숫자만큼의 크기 리스트 반환하는지 테스트")
    @Test
    void makeBridgeTest() {
        Assertions.assertThat(bridgeMaker.makeBridge(4).size()).isEqualTo(4);
    }
}