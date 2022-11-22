package bridge;

import bridge.Bridge;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class BridgeTest {

    @Test
    void 성공테스트(){
        List<String> randomBridge = List.of("U","D","D");
        List<String> answerUpBridge = List.of("O"," "," ");
        List<String> answerDownBridge = List.of(" ","O","O");
        Bridge bridge = new Bridge(randomBridge);

        bridge.runBridge("U");
        bridge.runBridge("D");
        bridge.runBridge("D");
        assertThat(bridge.resultUpBridge).isEqualTo(answerUpBridge);
        assertThat(bridge.resultDownBridge).isEqualTo(answerDownBridge);
    }

    @Test
    void 틀린_값이_들어오는_경우(){
        List<String> randomBridge = List.of("U","D","D");
        List<String> answerUpBridge = List.of("O","X");
        List<String> answerDownBridge = List.of(" "," ");
        Bridge bridge = new Bridge(randomBridge);

        bridge.runBridge("U");
        bridge.runBridge("U");
        assertThat(bridge.resultUpBridge).isEqualTo(answerUpBridge);
        assertThat(bridge.resultDownBridge).isEqualTo(answerDownBridge);
    }
}