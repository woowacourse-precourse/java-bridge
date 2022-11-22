package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.model.Bridge;
import bridge.model.Direction;
import bridge.model.GameCondition;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @DisplayName("플레이어가 종료에 도달하지 않으면 true 반환한다.")
    @Test
    void canMove() {
        //given
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "D")));

        //when
        boolean result = bridgeGame.move(Direction.UP);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("플레이어가 종료에 도달하면 false 반환한다.")
    @Test
    void cannotMove() {
        //given
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "D")));

        //when
        bridgeGame.move(Direction.UP);
        boolean result = bridgeGame.move(Direction.DOWN);

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("플레이어가 이동할 수 없는 상태면 예외가 발생한다.")
    @Test
    void illegalMove() {
        //given
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "D")));

        //when
        bridgeGame.move(Direction.UP);
        bridgeGame.move(Direction.DOWN);

        //then
        assertThatThrownBy(() -> bridgeGame.move(Direction.UP)).isInstanceOf(
                IllegalStateException.class);
    }

    @DisplayName("재시작 상태면 true 반환한다.")
    @Test
    void canRetry() {
        //given
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "D")));
        GameCondition condition = GameCondition.RESTART;

        //when
        boolean result = bridgeGame.retry(condition);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("재시작 상태가 아니라면 false 반환한다.")
    @Test
    void cannotRetry() {
        //given
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "D")));
        GameCondition condition = GameCondition.QUIT;

        //when
        boolean result = bridgeGame.retry(condition);

        //then
        assertThat(result).isFalse();
    }

}