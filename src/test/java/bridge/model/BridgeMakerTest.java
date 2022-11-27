package bridge.model;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    @DisplayName("입력한 수만큼 다리가 만들어지는가?")
    @Test
    public void createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int BRIDGE_SIZE = 3;

        List<String> bridge = bridgeMaker.makeBridge(BRIDGE_SIZE);
        assertThat(bridge.size()).isEqualTo(BRIDGE_SIZE);
        for (String position : bridge) assertThat(position).containsAnyOf("U", "D");
    }


}