//package bridge;
//
//import controller.Controller;
//import enumCollections.GameStatus;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import view.InputView;
//import view.OutputView;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//public class BridgeGameTest {
//    @DisplayName("다음 칸이 이동 가능한 칸인지 확인하는 테스트")
//    @Test
//    void 아래칸_이동_테스트() {
//        BridgeGame bridgeGame = new BridgeGame();
//        assertThat(bridgeGame.tryMoveTo("D"))
//                .isEqualTo(GameStatus.CONTINUE);
//    }
//
//    @DisplayName("다음 칸이 이동 가능한 칸인지 확인하는 테스트")
//    @Test
//    void 위칸_이동_테스트() {
//        BridgeGame bridgeGame = new BridgeGame();
//        assertThat(bridgeGame.tryMoveTo("U"))
//                .isEqualTo(GameStatus.CONTINUE);
//    }
//
//    @DisplayName("다음칸 이동 불가능으로 게임 실패 케이스 테스트")
//    @Test
//    void 위칸_이동_실패_테스트() {
//        BridgeGame bridgeGame = new BridgeGame();
//        assertThat(bridgeGame.tryMoveTo("U"))
//                .isEqualTo(GameStatus.FAILURE);
//    }
//
//    @DisplayName("다음칸 이동 불가능으로 게임 실패 케이스 테스트")
//    @Test
//    void 아래칸_이동_실패_테스트() {
//        BridgeGame bridgeGame = new BridgeGame();
//        assertThat(bridgeGame.tryMoveTo("D"))
//                .isEqualTo(GameStatus.FAILURE);
//    }
//
//    @DisplayName("다리 길이가 1일 때 게임 성공 테스트")
//    @Test
//    void 다리_길이_1_게임_성공_테스트() {
//        BridgeGame bridgeGame = new BridgeGame();
//        assertThat(bridgeGame.tryMoveTo("U"))
//                .isEqualTo(GameStatus.SUCCESS);
//    }
//
//    @DisplayName("다리 길이가 1일 때 게임 성공 테스트")
//    @Test
//    void 다리_길이_2_게임_성공_테스트() {
//        BridgeGame bridgeGame = new BridgeGame();
//        bridgeGame.tryMoveTo("U");
//        assertThat(bridgeGame.tryMoveTo("D"))
//                .isEqualTo(GameStatus.SUCCESS);
//    }
//
//    @DisplayName("삭제")
//    @Test
//    void 삭제() {
//        Controller controller = new Controller(new OutputView(), new InputView());
//        BridgeGame bridgeGame = new BridgeGame();
//        bridgeGame.generateBridge(4);
//        controller.play(bridgeGame, GameStatus.CONTINUE);
//        controller.play(bridgeGame, GameStatus.CONTINUE);
//        controller.play(bridgeGame, GameStatus.CONTINUE);
//        controller.play(bridgeGame, GameStatus.CONTINUE);
//    }
//}
