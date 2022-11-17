package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {
    @DisplayName("정답 다리와 유저 입력 다리 테스트")
    @Test
    void compareCorrectBridgesTest(){
        Bridge answerBridge = new Bridge(List.of("U", "D", "U", "U", "N"));
        Bridge userBridge = new Bridge(List.of("U", "D", "U"));
        boolean answer = true;
        assertThat(answer).isEqualTo(answerBridge.checkBridge(userBridge));
    }

    @DisplayName("틀린 다리와 유저 입력 다리 테스트")
    @Test
    void compareWrongBridgesTest(){
        Bridge answerBridge = new Bridge(List.of("U", "D", "U", "U", "N"));
        Bridge userBridge = new Bridge(List.of("U", "D", "D"));
        boolean answer = false;
        assertThat(answer).isEqualTo(answerBridge.checkBridge(userBridge));
    }
}
