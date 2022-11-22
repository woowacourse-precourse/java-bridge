package bridge;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;
import org.junit.jupiter.api.DisplayName;


// @ author ninaaano
class BridgeMakerTest {

    @Test
    @DisplayName("다리의 길이를 입력받고 다리 생성")
    void makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridges = bridgeMaker.makeBridge(10);
        assertThat(bridges).matches(s -> s.size() == 10);
        assertThat(bridges).allMatch(value -> value.equals("U") || value.equals("D"))
                .contains("U", "D");
    }
}