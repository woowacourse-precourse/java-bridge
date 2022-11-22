package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeRandomNumberGeneratorTest extends NsTest{

    @DisplayName("Generate 되는 값들 중 0, 1이 아닌 값이 있는가 ")
    @Test
    void checkRandomGeneratorException() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        for (int i = 0; i < 100; i++) {
            int generated = bridgeRandomNumberGenerator.generate();
            if (generated != 0 && generated != 1) {
                throw new IllegalArgumentException();
            }
        }
    }
    
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}