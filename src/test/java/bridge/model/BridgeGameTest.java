package bridge.model;

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

    @DisplayName("플레이어가 선택한 결과에 대한 정답을 알려주는 함수 테스트")
    @Test
    void isCorrect() {
        player.addChoice("U");
        boolean result = bridgeGame.isCorrectChoice(bridge.getAnswers(), player.getChoices(), 0);
        assertThat(result).isTrue();

        player.addChoice("U");
        result = bridgeGame.isCorrectChoice(bridge.getAnswers(), player.getChoices(), 1);
        assertThat(result).isFalse();
    }
}
