package bridge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    @Test
    void makeBridgeTest() {
        BridgeNumberGenerator bridgeNumberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> list = new ArrayList<>();
        list = bridgeMaker.makeBridge(5);
        assertThat(list.size()).isEqualTo(5);
        assertThat(list).isEqualTo(List.of("U", "D", "D", "D", "D"));
    }
    @Test
    void addUpDownTest() {
        assertThat(BridgeMaker.addUpDown(0)).isEqualTo("D");
        assertThat(BridgeMaker.addUpDown(1)).isEqualTo("U");
    }

}




