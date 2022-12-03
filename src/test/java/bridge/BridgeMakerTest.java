package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {

    BridgeMaker bridgeMaker;

    @BeforeEach
    void beforeEach() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    @DisplayName("0,1로 구성된 리스트를 U,D 리스트로 변환")
    void checkConvertNum() {
        List<String> result = new ArrayList<>();
        result = bridgeMaker.convertNumToMove(new ArrayList<>(List.of(1, 0, 0)));

        assertThat(result).isEqualTo(new ArrayList<>(List.of("U", "D", "D")));
    }

    @Test
    @DisplayName("입력 받은 크기만큼의 다리 생성")
    void checkMakeBridge() {
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge.size()).isEqualTo(3);
    }
}