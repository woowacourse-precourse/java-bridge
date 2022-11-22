package bridge.Model;

import bridge.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeGameTest {
    private final BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("유저 입력값, 다리의 정답값, 출력 테스트")
    @ParameterizedTest
    @CsvSource(value = {
      "U,U, [ O ], [   ]",
      "U,D, [ X ], [   ]",
      "D,D, [   ], [ O ]",
      "D,U, [   ], [ X ]"
    })
    void move(String move, String bridge, String answer1, String answer2) {
        List<String> answers = new ArrayList<>(List.of(bridge));
        bridgeGame.move(move, answers);
        assertThat(answer1).isEqualTo(bridgeGame.getUpperMap());
        assertThat(answer2).isEqualTo(bridgeGame.getLowerMap());
    }

}