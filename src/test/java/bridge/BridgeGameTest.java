package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    @DisplayName("사용자 이동 경로 정상 저장 테스트")
    @Test
    void saveUserMoveTest() {
        BridgeGame game = new BridgeGame(5);
        game.move("U");
        game.move("D");
        game.move("U");
        game.move("U");
        game.move("U");
        assertThat(game.getMovingUser()).isEqualTo(List.of("U", "D", "U", "U", "U"));
    }

    @DisplayName("재시작시 사용자 이동 경로 초기화 및 라운드 횟수 정상 저장 테스트")
    @Test
    void retryGameTest() {
        BridgeGame game = new BridgeGame(5);
        game.move("U");
        game.move("U");
        game.move("U");
        game.move("U");
        game.retry();
        game.move("U");
        assertThat(game.getRound()).isEqualTo(2);
        assertThat(game.getMovingUser().size()).isEqualTo(1);
    }

    @DisplayName("끝까지 못 간 경우 실패했다고 판단하는지 테스트")
    @Test
    void checkSuccess() {
        BridgeGame game = new BridgeGame(5);
        assertThat(game.isSuccess()).isEqualTo(false);
        game.move("U");
        assertThat(game.isSuccess()).isEqualTo(false);
        game.move("D");
        assertThat(game.isSuccess()).isEqualTo(false);
        game.move("U");
        assertThat(game.isSuccess()).isEqualTo(false);
        game.move("U");
        assertThat(game.isSuccess()).isEqualTo(false);
    }

    @DisplayName("올바르게 이동한 여부 정상 판단하는지 테스트")
    @Test
    void checkMove() {
        BridgeGame game = new BridgeGame(5);
        String move = "D";
        if (game.getBridge().get(1).equals("D")) {
            move = "U";
        }
        game.move(move);
        assertThat(game.isRightMove()).isEqualTo(false);
    }
}
