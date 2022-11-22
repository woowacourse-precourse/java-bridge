package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    private Bridge bridge;
    private BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(3));
        bridgeGame = BridgeGame.getInstance();
    }

    @DisplayName("유저의 이동이 제대로 기록이 되는지 동시에 종료 판정이 되는지")
    @Test
    void moveTest() {
        bridge.getBridge().stream().forEach(eachMovement -> bridgeGame.move(eachMovement));
        Assertions.assertThat(bridge.getBridge()).isEqualTo(bridgeGame.getUserLog());
        Assertions.assertThat(bridgeGame.isOver(bridge)).isTrue();
    }

    @DisplayName("유저가 잘못된 선택을 하는 경우 사망 판정이 되는지")
    @Test
    void missChooseTest() {
        String firstMovement = bridge.getBridge().get(0);

        if(firstMovement.equals(Command.UP.getValue())) {
            bridgeGame.move(Command.DOWN.getValue());
        }
        if(firstMovement.equals(Command.DOWN.getValue())) {
            bridgeGame.move(Command.UP.getValue());
        }

        Assertions.assertThat(bridgeGame.isUserDead(bridge)).isTrue();
    }

    @DisplayName("재시도 횟수가 제대로 카운팅 되는지")
    @Test
    void retryCountTest() {
        String firstMovement = bridge.getBridge().get(0);

        if(firstMovement.equals(Command.UP.getValue())) {
            bridgeGame.move(Command.DOWN.getValue());
        }
        if(firstMovement.equals(Command.DOWN.getValue())) {
            bridgeGame.move(Command.UP.getValue());
        }

        bridgeGame.retry(Command.RETRY.getValue());

        bridge.getBridge().stream().forEach(eachMovement -> bridgeGame.move(eachMovement));

        Assertions.assertThat(bridgeGame.getRetryCount()).isEqualTo(2);
    }


}