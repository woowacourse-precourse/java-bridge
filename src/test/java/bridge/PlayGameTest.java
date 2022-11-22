package bridge;

import model.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayGameTest {

    private final BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("플레이어가 이동한 칸과 건널 수 있는 칸을 비교해서 이동에 대한 true, false 비교")
    @Test
    void playerMoveTest() {
        List<String> crossAble = List.of("U", "D", "D", "U");
        List<Integer> turns = List.of(0,1,2,3);
        List<String> move = List.of("U","U","D","D");
        List<Boolean> bridgeAnswer = new ArrayList<>();
        List<Boolean> answer = List.of(true, false, true, false);
        for(int turn = 0; turn < turns.size(); turn++){
            bridgeAnswer.add(bridgeGame.move(crossAble, turns.get(turn), move.get(turn)));
        }
        assertThat(bridgeAnswer).isEqualTo(answer);
    }
}
