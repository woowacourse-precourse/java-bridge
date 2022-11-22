package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.domain.BridgeGame;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    @DisplayName("생성자 테스트")
    @Test
    public void bridgeGameConstructorTest() {
        // given
        List<String> bridge = List.of("D", "D", "D");

        // when
        BridgeGame bridgeGame = new BridgeGame(bridge);

        // then
        assertThat(bridgeGame.getBridge().size()).isEqualTo(bridge.size());
    }

    @DisplayName("comparePositionLength 테스트")
    @Test
    public void comparePositionLengthTest() {
        // given
        List<String> bridge1 = List.of("U", "U", "U");
        List<String> bridge2 = new ArrayList<>();
        BridgeGame bridgeGame1 = new BridgeGame(bridge1);
        BridgeGame bridgeGame2 = new BridgeGame(bridge2);

        // when

        boolean case1 = bridgeGame1.comparePositionLength();
        boolean case2 = bridgeGame2.comparePositionLength();

        // then
        assertThat(case1).isEqualTo(false);
        assertThat(case2).isEqualTo(true);
    }

    @DisplayName("checkThisStep 테스트")
    @Test
    public void checkThisStepTest() {
        // given
        String userInput = "U";
        List<String> bridge = List.of("U", "U", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);

        // when
        boolean correctOrWrong = bridgeGame.checkThisStep(userInput);

        // then
        assertThat(correctOrWrong).isEqualTo(true);
    }

    @DisplayName("move 테스트")
    @Test
    public void moveTest() {
        // given
        List<String> list = List.of("U", "D", "U");
        BridgeGame bridgeGame = new BridgeGame(list);
        int position = 1;

        // when
        bridgeGame.move();

        // then
        assertThat(bridgeGame.getPosition()).isEqualTo(position);
    }

    @DisplayName("retry 테스트")
    @Test
    public void retryTest() {
        // given
        List<String> list = List.of("U", "D", "U");
        BridgeGame bridgeGame = new BridgeGame(list);
        int position = 0;
        bridgeGame.move();

        // when
        bridgeGame.retry();

        // then
        assertThat(bridgeGame.getPosition()).isEqualTo(position);
    }
}
