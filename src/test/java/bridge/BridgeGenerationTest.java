package bridge;

import bridge.domain.user.UserMaker;
import bridge.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGenerationTest {
    private final UserMaker userMaker = new UserMaker();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("새로운 User 객체를 생성한다.")
    @Test
    void generateUsersBridgeCrossStatusTest() {
        User initialBridge = userMaker.makeUser(3);

        List<String> topSpace = initialBridge.getCurrentBridge().get(1);
        assertThat(topSpace).isEqualTo(List.of("[", "]"));
        List<String> underSpace = initialBridge.getCurrentBridge().get(0);
        assertThat(underSpace).isEqualTo(List.of("[", "]"));
        assertThat(initialBridge.getBridgeSize()).isEqualTo(3);
    }

    @DisplayName("길이가 10인 새로운 answerBridge를 생성한다.")
    @Test
    void generateAnswerBridgeTest() {
        List<String> answerBridge = bridgeMaker.makeBridge(10);
        assertThat(answerBridge.size()).isEqualTo(10);
        assertThat(answerBridge).satisfiesAnyOf(
                value -> {assertThat(answerBridge).containsOnly("U", "D");},
                value -> {assertThat(answerBridge).containsOnly("D");},
                value -> {assertThat(answerBridge).containsOnly("U");}
        );
    }

}
