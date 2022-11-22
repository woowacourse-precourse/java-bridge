package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.util.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeRandomGeneratorTest {

    @DisplayName("컴퓨터가 0과 1 둘 중의 하나의 값을 반환했는지 확인해주는 Test")
    @Test
    public void generateTest() {

        int zeroNumber = 0;
        int oneNumber = 1;
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        int randomNumber = bridgeRandomNumberGenerator.generate();

        boolean checkOneAndZero = (randomNumber==zeroNumber || randomNumber==oneNumber);

        assertThat(checkOneAndZero).isTrue();

    }
}
