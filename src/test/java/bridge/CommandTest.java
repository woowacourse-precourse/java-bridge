package bridge;

import bridge.model.BridgeGame;
import bridge.model.Command;
import bridge.model.Direction;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CommandTest {

    @Test
    public void 단축어로부터_Command로_변환() {
        Command retry = Command.fromSymbol("R");
        Command quit = Command.fromSymbol("Q");

        assertThat(retry).isEqualTo(Command.RETRY);
        assertThat(quit).isEqualTo(Command.QUIT);
    }

    @Test
    public void 올바르지_않은_단축어_예외_발생() {
        assertThatThrownBy(() -> Command.fromSymbol("foo"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void RETRY_명령어_실행으로_BridgeGame_재시작() {
        Command retry = Command.RETRY;
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "U"));

        // 초기 상태
        assertThat(bridgeGame.getTrial()).isEqualTo(1);
        assertThat(bridgeGame.getHistory().size()).isEqualTo(0);

        bridgeGame.move(Direction.DOWN);

        // 이동 후 상태
        assertThat(bridgeGame.getHistory().size()).isEqualTo(1);

        retry.exec(bridgeGame);

        // 재시도 후 상태
        assertThat(bridgeGame.getTrial()).isEqualTo(2);
        assertThat(bridgeGame.getHistory().size()).isEqualTo(0);
    }

    @Test
    public void QUIT_명령어_실행으로_BridgeGame_포기() {
        Command quit = Command.QUIT;
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "U"));

        // 초기 상태
        assertThat(bridgeGame.isGiveUp()).isEqualTo(false);

        // 재시도 명령어 실행
        quit.exec(bridgeGame);

        // 재시도 후 상태
        assertThat(bridgeGame.isGiveUp()).isEqualTo(true);
    }
}
