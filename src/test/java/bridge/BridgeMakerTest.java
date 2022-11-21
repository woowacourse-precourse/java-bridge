package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    BridgeMaker bridgeMaker;
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private final int size = 10;

    @BeforeEach
    public void 인스턴스_생성() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    @DisplayName("인터페이스 오바라이드가 잘되는지 테스트")
    @Test
    void 오버라이드() {
        List<Integer> numberBridge = bridgeMaker.makeNumberBridge(size);
        assertThat(numberBridge).contains(1,0);
    }

    @Test
    void 숫자_알파벳으로_변환_테스트() {
        List<Integer> numberBridge = bridgeMaker.makeNumberBridge(size);
        List<String> alphabetBridge = bridgeMaker.transferNumberToAlphabet(numberBridge);
        assertThat(alphabetBridge).contains("U", "D");
    }

    @Test
    void 다리_길이_테스트() {
        List<Integer> numberBridge = bridgeMaker.makeNumberBridge(size);
        List<String> alphabetBridge = bridgeMaker.transferNumberToAlphabet(numberBridge);
        assertThat(alphabetBridge.size()).isEqualTo(10);
    }
}