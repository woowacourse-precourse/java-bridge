package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {
    List<String> bridge = List.of("U", "U", "U");
    Map<Integer, Map<String, String>> user =new HashMap<>();
    BridgeGame game = new BridgeGame();

    @DisplayName("플레이어의 입력값이 잘 저장되는지 확인")
    @Test
    void check_value() {
        String userInput = "U";

        assertThat(game.storeResult(user, bridge, userInput).get(0).get("U"))
                .isEqualTo("O");
    }

    @DisplayName("잘못된 매개변수 들어가면 예외 발생확인")
    @Test
    void check_Exception() {
        assertThatThrownBy(() -> game.checkEnd(user, bridge))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("질때 결과값 잘 리턴하는지 확인")
    @Test
    void check_Loose() {
        Map<String, String> status = new HashMap<>();
        status.put("U", "X");
        user.put(0, status);

        assertThat(game.checkEnd(user, bridge))
                .as("질 때")
                .isEqualTo(Condition.LOOSE);
    }

    @DisplayName("이길때 결과값 잘 리턴하는지 확인")
    @Test
    void check_Win() {
        Map<String, String> status = new HashMap<>();
        status.put("U", "O");
        user.put(0, status);
        user.put(1, status);
        user.put(2, status);

        assertThat(game.checkEnd(user, bridge))
                .as("이길 때")
                .isEqualTo(Condition.WIN);
    }
}
