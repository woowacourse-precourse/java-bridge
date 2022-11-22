//package bridge.domain;
//
//import bridge.domain.object.Bridge;
//import bridge.domain.object.Player;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static bridge.controller.GameState.*;
//import static org.assertj.core.api.Assertions.assertThat;
//
//class BridgeGameTest {
//    private BridgeGame game;
//
//    @BeforeEach
//    void setBridgeGame() {
//        Player player = new Player();
//        Bridge bridge = new Bridge(List.of("U", "D", "U"));
//        game = new BridgeGame(player, bridge);
//    }
//
//    @DisplayName("move: 플레이어를 이동시킨다.")
//    @Test
//    void move() {
//        game.move("U");
//
//        assertThat(game.getPlayer().getMoves().get(0)).isEqualTo("U");
//    }
//
//    @DisplayName("checkGameState: 현재까지의 이동 경로가 맞다면 RUN 이 반환된다.")
//    @Test
//    void checkRun() {
//        game.move("U");
//
//        assertThat(game.checkGameState()).isEqualTo(RUN);
//    }
//
//    @DisplayName("checkGameState: 현재까지의 이동 경로가 다르다면 FAIL 이 반환된다.")
//    @Test
//    void checkFail() {
//        game.move("D");
//
//        assertThat(game.checkGameState()).isEqualTo(FAIL);
//    }
//
//    @DisplayName("checkGameState: 다리를 전부 건넜다면 CLEAR 가 반환된다.")
//    @Test
//    void checkClear() {
//        game.move("U");
//        game.move("D");
//        game.move("U");
//
//        assertThat(game.checkGameState()).isEqualTo(CLEAR);
//    }
//
//    @DisplayName("retry: 게임 상태 RUN, 플레이어의 입력값 초기화, 시도횟수가 1 증가한다.")
//    @Test
//    void retry() {
//        game.move("U");
//        game.move("D");
//        game.move("D");
//
//        game.retry();
//
//        assertThat(game.checkGameState()).isEqualTo(RUN);
//        assertThat(game.getTryCount()).isEqualTo(2);
//        assertThat(game.getPlayer().getMoves().size()).isEqualTo(0);
//    }
//}