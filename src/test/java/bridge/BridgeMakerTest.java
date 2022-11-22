package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    public void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("입력받은 다리의 길이만큼 랜덤한 숫자가 생성되어야 한다.")
    @Test
    void 랜덤한_숫자로_다리_생성() {
        assertEquals(bridgeMaker.makeBridge(16).size(), 16);
    }

}