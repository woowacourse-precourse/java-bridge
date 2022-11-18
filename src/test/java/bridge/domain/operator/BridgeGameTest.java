package bridge.domain.operator;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.bridge.Bridge;
import bridge.domain.player.Player;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    @DisplayName("플레이어가 선택한 칸으로 이동시키고 이동 결과를 저장한다.")
    void moveTest() {
        //given
        Bridge bridge = new Bridge(List.of("0", "0", "1"));
        BridgeGame bridgeGame = new BridgeGame(bridge, new Player());

        String playerSelection1 = "D";
        String playerSelection2 = "U";

        //when
        bridgeGame.move(playerSelection1);
        bridgeGame.move(playerSelection2);

        //then
        List<Boolean> upBridgeResult = bridgeGame.getBridgeResult().getUpBridge();
        List<Boolean> downBridgeResult = bridgeGame.getBridgeResult().getDownBridge();

        assertThat(upBridgeResult.get(0)).isEqualTo(null);
        assertThat(upBridgeResult.get(1)).isEqualTo(false);
        assertThat(downBridgeResult.get(0)).isEqualTo(true);
        assertThat(downBridgeResult.get(1)).isEqualTo(null);
    }

    @Nested
    @DisplayName("플레이어 이동 후 변화는")
    class HandleAfterMoveTest {

        @Test
        @DisplayName("플레이어가 건널 수 없는 칸으로 이동한 것이라면 상태는 실패이며, 게임 시도 횟수가 증가한다.")
        void case1() {
            //given
            Bridge bridge = new Bridge(List.of("0", "0", "1"));
            Player player = new Player();
            BridgeGame bridgeGame = new BridgeGame(bridge, player);

            BridgeResult bridgeResult = bridgeGame.getBridgeResult();
            int beforeMoveAttempt = bridgeResult.getAttempt();

            String playerSelection = "U";

            //when
            bridgeGame.move(playerSelection);

            //then
            int afterMoveAttempt = bridgeResult.getAttempt();
            assertThat(player.isSuccess()).isEqualTo(false);
            assertThat(afterMoveAttempt).isEqualTo(beforeMoveAttempt + 1);
        }

        @Test
        @DisplayName("플레이어가 건널 수 있는 칸으로 이동한 것이라면 상태는 성공이며, 게임 시도 횟수는 변화 없다.")
        void case2() {
            //given
            Bridge bridge = new Bridge(List.of("0", "0", "1"));
            Player player = new Player();
            BridgeGame bridgeGame = new BridgeGame(bridge, player);

            BridgeResult bridgeResult = bridgeGame.getBridgeResult();
            int beforeMoveAttempt = bridgeResult.getAttempt();

            String playerSelection = "D";

            //when
            bridgeGame.move(playerSelection);

            //then
            int afterMoveAttempt = bridgeResult.getAttempt();
            assertThat(player.isSuccess()).isEqualTo(true);
            assertThat(afterMoveAttempt).isEqualTo(beforeMoveAttempt);
        }
    }

}
