package bridge;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame();
    Bridge bridge = new Bridge(List.of("U", "D", "U"));
    Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @DisplayName("유저가 현재 선택한 결과를 반환하는 함수 테스트")
    @Test
    void isCorrect() {
        player.addChoice("U");
        boolean result = bridgeGame.isCorrectChoice(bridge.getAnswers(), player.getChoices(), 0);
        assertThat(result).isTrue();

        player.addChoice("U");
        result = bridgeGame.isCorrectChoice(bridge.getAnswers(), player.getChoices(), 1);
        assertThat(result).isFalse();
    }

    @DisplayName("유저가 끝까지 도달했을 경우 테스트")
    @Test
    void isApproachEndTest() {
        player.addChoice("U");
        player.addChoice("D");
        player.addChoice("U");
        boolean result = bridgeGame.isApproachLast(bridge.getAnswersSize(), player.getChoicesSize());
        assertThat(result).isTrue();
    }
}
