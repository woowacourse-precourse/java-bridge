package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.Game;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    private final BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("사용자의 값과 컴퓨터의 값이 같으면 한 칸 움직이는지 확인하는 테스트(승리하지 않았을 경우)")
    @Test
    public void moveTestWithNotWin() {
        String userFirstInputMove = "U";
        String userSecondInputMove = "D";
        Bridge bridge = new Bridge(List.of("U","D","D"));
        Game game = new Game();

        bridgeGame.move(bridge,game,userFirstInputMove);
        bridgeGame.move(bridge,game,userSecondInputMove);

        assertThat(bridge.getNowIndex()).isEqualTo(2);

    }

    @DisplayName("게임 종료(이겼을 경우)를 확인시켜주는 테스트")
    @Test
    public void endGameTestWithWin() {
        Bridge bridge = new Bridge(List.of("U","D","D"));
        Game game = new Game();

        bridgeGame.move(bridge,game,"U");
        bridgeGame.move(bridge,game,"D");
        bridgeGame.move(bridge,game,"D");

        assertThat(bridge.isEndPoint()).isTrue();
        assertThat(game.isWinGame()).isTrue();
        assertThat(game.isGameDone()).isTrue();
    }

    @DisplayName("게임을 재시작할 경우에 다리의 인덱스를 0으로 초기화해고, 게임 횟수를 1 늘려주는지 확인하는 테스트")
    @Test
    public void retryTest() {
        Bridge bridge = new Bridge(List.of("U","U","U"));
        Game game = new Game();

        bridgeGame.retry(bridge, game);
        bridgeGame.retry(bridge, game);
        bridgeGame.retry(bridge, game);

        assertThat(game.getGameCount()).isEqualTo(4);
        assertThat(bridge.getNowIndex()).isEqualTo(0);
    }

    @DisplayName("게임에서 다리의 마지막 지점인지 확인해주는 테스트")
    @Test
    public void checkEndPointTest() {
        Bridge bridge = new Bridge(List.of("U","U","U"));
        Game game = new Game();

        bridgeGame.move(bridge, game, "U");
        bridgeGame.move(bridge, game, "U");
        bridgeGame.move(bridge, game, "D");

        assertThat(game.isWinGame()).isFalse();
        assertThat(game.isGameDone()).isFalse();
    }



}
