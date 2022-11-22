package bridge;

import controller.BridgeController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BridgeTest {

    @DisplayName("입력 값과 다리 이동 정답이 일치하는지 여부를 판단한다")
    @Test
    void 정답_일치여부_테스트(){

        Bridge bridge = new Bridge(List.of("U","U","U"));
        BridgeController bridgeController = new BridgeController();

        bridgeController.moveOneStep(0,"D",bridge);

        assertTrue(BridgeGame.getIsPlayerFailed());
    }

    @DisplayName("사용자의 입력이 답과 같을 때, O로 이동을 기록하는지를 확인한다.")
    @Test
    void 사용자_이동_성공_테스트(){
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move("U");

        assertThat(BridgeGame.getUpSideBridge().toString())
                .contains("O");
    }

    @DisplayName("사용자의 입력이 답과 다를 때, X로 실패를 기록하는지를 확인한다.")
    @Test
    void 사용자_이동_실패_테스트(){
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.moveFailed("U");

        assertThat(BridgeGame.getUpSideBridge().toString())
                .contains("X");
    }

}
