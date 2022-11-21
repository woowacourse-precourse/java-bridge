package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {

    @DisplayName("입력받은 다리의 길이만큼 랜덤한 숫자가 생성되어야 한다.")
    @Test
    void makeBridgeByRandomNumber(){
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());

        assertThat(maker.makeBridge(10).toArray()).contains("U", "D");
        assertThat(maker.makeBridge(10).size()).isEqualTo(10);
    }
}
