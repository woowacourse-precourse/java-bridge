package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    @Test
    @DisplayName("사용자가 입력한 길이만큼 다리를 만든다.")
    void makeBridge() {
        //given
        int size = 10;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        //when
        int actualSize = bridgeMaker.makeBridge(size).size();

        //then
        assertEquals(size, actualSize);
    }
}