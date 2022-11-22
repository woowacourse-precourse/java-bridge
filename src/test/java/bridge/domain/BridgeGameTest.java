package bridge.domain;

import bridge.MoveResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    private static Bridge bridge;
    private static BridgeGame bridgeGame;

    @BeforeAll
    static void setup() {
        bridge = new Bridge(List.of("U", "U", "D"));
    }

    @BeforeEach
    void setBridgeGame() {
        bridgeGame = new BridgeGame(bridge);
    }

    @Test
    void 유저_이동명령시_계속하기() {
        //given
        //when
        MoveResult moveResult = bridgeGame.move(MoveCommand.UP);
        //then
        assertThat(moveResult.getGameStatus()).isEqualTo(GameStatus.CONTINUE);
    }

    @Test
    void 유저_이동명령시_정답() {
        //given
        //when
        bridgeGame.move(MoveCommand.UP);
        bridgeGame.move(MoveCommand.UP);
        MoveResult moveResult = bridgeGame.move(MoveCommand.DOWN);
        //then
        assertThat(moveResult.getGameStatus()).isEqualTo(GameStatus.CORRECT);
    }

    @Test
    void 유저_이동명령시_실패() {
        //given
        //when
        MoveResult moveResult = bridgeGame.move(MoveCommand.DOWN);
        //then
        assertThat(moveResult.getGameStatus()).isEqualTo(GameStatus.FAIL);
    }

    @Test
    void 게임_재시작시_시도횟수_증가하고_다리는_재사용() {
        //given
        //when
        bridgeGame.retry();
        MoveResult moveResult = moveCorrectWay();
        //then
        assertThat(bridgeGame.getTotalAttempt()).isEqualTo(2);
        assertThat(moveResult.getGameStatus()).isEqualTo(GameStatus.CORRECT);
    }

    private MoveResult moveCorrectWay() {
        bridgeGame.move(MoveCommand.UP);
        bridgeGame.move(MoveCommand.UP);
        MoveResult moveResult = bridgeGame.move(MoveCommand.DOWN);
        return moveResult;
    }
}