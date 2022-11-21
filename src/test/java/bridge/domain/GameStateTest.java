package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameStateTest {
    private static final GameState GAME_STATE = new GameState();
    private static final List<String> MOVES = GAME_STATE.getMoves();

    @DisplayName("상태가 업데이트 되는 지 테스트한다.")
    @ValueSource(strings = {"U,1", "D,2", "D,3", "U,4"})
    @ParameterizedTest
    void updateStateTest(String input) {
        String[] inputs = input.split(",");
        GAME_STATE.updateState(inputs[0], BridgeState.CROSSING);
        System.out.println(MOVES.size());
        assertThat(MOVES.get(MOVES.size() - 1)).isEqualTo(inputs[0]);
        assertThat(GAME_STATE.nextLocation()).isEqualTo(Integer.parseInt(inputs[1]));
    }

    @DisplayName("초기화되는 지 테스트한다.")
    @Test
    void initTest() {
        int attemptBefore = GAME_STATE.getAttempt();
        GAME_STATE.init();
        assertThat(MOVES.isEmpty()).isTrue();
        assertThat(GAME_STATE.getAttempt()).isEqualTo(attemptBefore + 1);
    }

}
