package bridge.domain;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Player 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PlayerTest {

    @Test
    void move_메서드는_방향을_입력받아_다리_건너기_게임을_진행하고_결과를_저장한다() {
        BridgeGameResult bridgeGameResult = mock(BridgeGameResult.class);
        Player player = new Player(GamePlayCount.firstGame(), Round.firstRound(), bridgeGameResult);
        BridgeGame bridgeGame = mock(BridgeGame.class);
        when(bridgeGame.move(any(), any())).thenReturn(MoveResult.SUCCESS);

        player.move(bridgeGame, Direction.UP);

        verify(bridgeGame, only()).move(any(Round.class), eq(Direction.UP));
        verify(bridgeGameResult, only()).addResult(any(Round.class), any(PlayerMove.class));
    }

    @Test
    void reset_메서드는_Round와_BridgeGameResult를_초기화하고_다음_게임_카운트를_증가시킨다() {
        GamePlayCount gamePlayCount = mock(GamePlayCount.class);
        BridgeGameResult bridgeGameResult = mock(BridgeGameResult.class);

        Player player = new Player(gamePlayCount, Round.firstRound(), bridgeGameResult);

        player.reset();

        verify(gamePlayCount, only()).nextGame();
        verify(bridgeGameResult, only()).reset();
    }

    @Test
    void getGameResult_메서드는_BridgeGameResult의_getResult를_호출한다() {
        BridgeGameResult bridgeGameResult = mock(BridgeGameResult.class);
        Player player = new Player(GamePlayCount.firstGame(), Round.firstRound(), bridgeGameResult);

        player.getBridgeGameResult();

        verify(bridgeGameResult, only()).getResult();
    }

    @Test
    void getGamePlayCount_메서드는_GamePlayCount의_getCount를_호출한다() {
        GamePlayCount gamePlayCount = mock(GamePlayCount.class);
        Player player = new Player(gamePlayCount, Round.firstRound(), new BridgeGameResult());

        player.getGamePlayCount();

        verify(gamePlayCount, only()).getCount();
    }

    @Test
    void checkGamePassed_메서드는_BridgeGameResult의_checkPassed를_호출한다() {
        BridgeGameResult bridgeGameResult = mock(BridgeGameResult.class);
        Player player = new Player(GamePlayCount.firstGame(), Round.firstRound(), bridgeGameResult);

        player.checkGamePassed();

        verify(bridgeGameResult, only()).checkPassed();
    }
}
