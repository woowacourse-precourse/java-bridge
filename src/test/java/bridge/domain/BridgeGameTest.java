package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

class BridgeGameTest {

    private MovingMap movingMap = new MovingMap();
    BridgeGame bridgeGame = new BridgeGame();
    List<String> bridge = List.of("U", "U", "D");

    @BeforeEach
    void setUp() {
        movingMap.init();
    }

    @Test
    @DisplayName("move를 했을 때 result에 값이 제대로 담길 수 있다. ")
    void tryMoveSuccess() {
        String moving = "U";

        bridgeGame.move(bridge, moving, movingMap);
        Map<String, List<String>> result = movingMap.getMovingMap();
        String uStatus = result.get("U").get(0);
        String dStatus = result.get("D").get(0);

        assertThat(uStatus).isEqualTo(" O ");
        assertThat(dStatus).isEqualTo("   ");
    }

    @Test
    @DisplayName("move를 했을 때 result에 값이 제대로 담길 수 있다. ")
    void tryMoveFail() {
        String moving = "D";
        bridgeGame.move(bridge, moving, movingMap);
        Map<String, List<String>> result = movingMap.getMovingMap();
        String uStatus = result.get("U").get(0);
        String dStatus = result.get("D").get(0);

        assertThat(uStatus).isEqualTo("   ");
        assertThat(dStatus).isEqualTo(" X ");
    }

    @Test
    @DisplayName("moveCorrect 메서드를 통해 값 판정이 제대로 이루어져 isCorrect에 제대로 된 값을 넣을 수 있다.")
    void insertValueToIsCorrectSuccess() {
        String moving = "U";

        bridgeGame.moveCorrect(bridge, moving);

        assertThat(bridgeGame.isCorrect()).isTrue();
    }

    @Test
    @DisplayName("게임이 끝났는지 상태를 확인할 수 있다. ")
    void tryGameOverSuccess() {

        for (String step : bridge) {
            bridgeGame.move(bridge, step, movingMap);
        }

        boolean isGameOver = bridgeGame.isGameOver(bridge.size(), movingMap);

        assertThat(isGameOver).isTrue();
    }

    @Test
    @DisplayName("게임이 끝났는지 상태를 확인할 수 있다. ")
    void tryGameOverFail() {
        bridgeGame.move(bridge, "U", movingMap);
        bridgeGame.move(bridge, "U", movingMap);
        bridgeGame.move(bridge, "U", movingMap);

        boolean isGameOver = bridgeGame.isGameOver(bridge.size(), movingMap);

        assertThat(isGameOver).isFalse();
    }
}