package bridge.service;

import bridge.util.BridgeUtil;
import bridge.util.View;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameTest {

    /**
     * 생성자를 포함한 아래의 메서드를 테스트 합니다.
     * 1. BridgeGame()
     * 2. initBridge(int bridgeSize)
     * 3. initPlayer()
     * 4. move(String moveCommand)
     * 5. getBridgeMap()
     */

    @DisplayName("(생성자 테스트) bridgeMaker")
    @Test
    void 생성자와_다리생성_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.initBridge(3);
        bridgeGame.initPlayer();
        bridgeGame.move(BridgeUtil.UP);

        assertThat(bridgeGame.getBridgeMap().get(0).size()).isEqualTo(1);
    }

    @DisplayName("재시도 횟수는 기존 1과 반복횟수의 합이므로 2번 반복 (retry()) 시 3이 반환 되어야한다.")
    @Test
    void 재시도_횟수_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.initBridge(3);
        bridgeGame.initPlayer();

        int expectTryCount = 2;
        for (int tryTimes = 0; tryTimes < expectTryCount; tryTimes++) {
            bridgeGame.retry();
        }

        assertThat(bridgeGame.getTryCount()).isEqualTo(expectTryCount + 1);
    }

    @DisplayName("마지막에 다다르면 false 반환 이전 조건에 만족하지 않고 최근의 choice와 bridge 의 동일 인덱스 값이 같으면 true 반환" +
            "둘다 포함되지 않으면 false 반환")
    @Test
    void 계속_이동이_가능한지_확인() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.initBridge(3);
        bridgeGame.initPlayer();

        int expectTryCount = 3;
        for (int move = 0; move < expectTryCount; move++) {
            bridgeGame.move(BridgeUtil.UP);
        }

        assertThat(bridgeGame.moveAgain()).isFalse();
        assertThat(bridgeGame.getBridgeMap().get(0).get(2)).isIn(View.ANSWER_RESULT, View.WRONG_ANSWER_RESULT);
    }

    @DisplayName("계속 이동이 불가능하면 false 반환")
    @Test
    void 계속_이동이_불가능한것을_확인() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.initBridge(3);
        bridgeGame.initPlayer();

        int expectTryCount = 3;
        for (int move = 0; move < expectTryCount; move++) {
            bridgeGame.move(BridgeUtil.UP);
        }

        assertThat(bridgeGame.moveAgain()).isFalse();
    }

    @DisplayName("다리 길이제한 검증 예외테스트")
    @Test
    void 다리길이의_제한을_넘는_21_길이가_주어지면_예외출력() {
        BridgeGame bridgeGame = new BridgeGame();

        assertThatThrownBy(() -> bridgeGame.validateBridgeSize("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 숫자 검증 예외테스트")
    @Test
    void 다리길이가_숫자로변환을_못하는_문자가_주어지면_예외출력() {
        BridgeGame bridgeGame = new BridgeGame();

        assertThatThrownBy(() -> bridgeGame.validateBridgeSize("a"))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    void validateInputMoveCommand() {
    }

    @Test
    void validateInputGameCommand() {
    }

    @Test
    void isRestartGame() {
    }

    @Test
    void getTryCount() {
    }

    @Test
    void isCrossAllBridge() {
    }
}