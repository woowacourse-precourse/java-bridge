package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

public class ObjectGenerationTest {
    private final Utils utils = new Utils();

    @DisplayName("새로운 UsersBridgeCrossStatus 객체를 생성한다.")
    @Test
    void generateUsersBridgeCrossStatusTest() {
        UsersBridgeCrossStatus initialBridge = utils.makeInitialBridge();

        List<String> topSpace = initialBridge.getCurrentBridge().get(1);
        assertThat(topSpace).isEqualTo(List.of("[", " ", " ", "]"));
        List<String> underSpace = initialBridge.getCurrentBridge().get(0);
        assertThat(underSpace).isEqualTo(List.of("[", " ", " ", "]"));
    }

    @DisplayName("길이가 10인 새로운 answerBridge를 생성한다.")
    @Test
    void generateAnswerBridgeTest() {
        List<String> answerBridge = utils.makeAnswerBridge(10);
        assertThat(answerBridge.size()).isEqualTo(10);
        assertThat(answerBridge).satisfiesAnyOf(
                value -> {assertThat(answerBridge).containsOnly("U", "D");},
                value -> {assertThat(answerBridge).containsOnly("D");},
                value -> {assertThat(answerBridge).containsOnly("U");}
        );
    }

}
