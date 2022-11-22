package bridge;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest {


    @Test
    void testMove(){
        BridgeGameInfo bridgeGameInfo = new BridgeGameInfo(3);
        BridgeGame bridgeGame = new BridgeGame(bridgeGameInfo);

        bridgeGame.move("U");
        assertThat(bridgeGameInfo.getPlayer()).isEqualTo("U");
        assertThat(bridgeGameInfo.getPosition()).isEqualTo(0);

        bridgeGame.move("D");
        assertThat(bridgeGameInfo.getPlayer()).isEqualTo("D");
        assertThat(bridgeGameInfo.getPosition()).isEqualTo(1);
    }

    @Test
    void testRetry(){
        BridgeGameInfo bridgeGameInfo = new BridgeGameInfo(3);
        BridgeGame bridgeGame = new BridgeGame(bridgeGameInfo);

        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.retry();
        assertThat(bridgeGameInfo.getTrial()).isEqualTo(2);
        assertThat(bridgeGameInfo.getPosition()).isEqualTo(-1);

        bridgeGame.move("D");
        bridgeGame.retry();
        assertThat(bridgeGameInfo.getTrial()).isEqualTo(3);
        assertThat(bridgeGameInfo.getPosition()).isEqualTo(-1);
    }

    @Test
    void testGetPlayerStatus(){
        assertRandomNumberInRangeTest(
                () -> {
                    BridgeGameInfo bridgeGameInfo = new BridgeGameInfo(5);
                    BridgeGame bridgeGame = new BridgeGame(bridgeGameInfo);
                    bridgeGame.move("U");
                    bridgeGame.move("D");
                    assertThat(bridgeGame.status()).isEqualTo(Player.SURVIVE);
                    bridgeGame.move("D");
                    assertThat(bridgeGame.status()).isEqualTo(Player.DIE);
                },
                1, 0, 1, 0, 1
        );
    }
}
