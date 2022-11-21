package bridge.domain;

import bridge.utils.generator.BridgeSpecificNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void setup() {
        bridgeGame = new BridgeGame(6, new BridgeMaker(new BridgeSpecificNumberGenerator()));
    }

    @DisplayName("저장된 다리를 건널 수 있다면 true")
    @Test
    void 다리를_건널_수_있으면_true() {
        assertThat(bridgeGame.move("U")).isTrue();
    }

    @DisplayName("저장된 다리를 건널 수 없다면 false")
    @Test
    void 다리를_건널_수_없으면_false() {
        assertThat(bridgeGame.move("D")).isFalse();
    }

    @DisplayName("저장된 다리를 건널 수 있다면 UP이 저장된다.")
    @Test
    void 다리를_건널_수_있으면_UP_저장() {
        bridgeGame.move("U");

        assertThat(bridgeGame.getPlayer().getPlayResult().getPlayResult().get(0))
                .isEqualTo(MoveStatus.UP);
    }

    @DisplayName("저장된 다리를 건널 수 없다면 FAIL이 저장된다.")
    @Test
    void 다리를_건널_수_없으면_FAIL_저장() {
        bridgeGame.move("D");

        assertThat(bridgeGame.getPlayer().getPlayResult().getPlayResult().get(0))
                .isEqualTo(MoveStatus.DOWN_FAIL);
    }

    @DisplayName("재시작 코드가 입력되면 true")
    @Test
    void 재시작_코드가_입력되면_true() {
        bridgeGame.move("D");

        assertThat(bridgeGame.retry("R"))
                .isTrue();
    }

    @DisplayName("종료 코드가 입력되면 false")
    @Test
    void 종료_코드가_입력되면_false() {
        bridgeGame.move("D");

        assertThat(bridgeGame.retry("Q"))
                .isFalse();
    }

    @DisplayName("재시작 코드가 입력되면 실패 결과는 삭제된다.")
    @Test
    void 재시작_코드가_입력되면_실패_결과_삭제() {
        bridgeGame.move("D");
        bridgeGame.retry("R");

        assertThat(bridgeGame.getPlayer().getPlayResult().getPlayResult().size())
                .isEqualTo(0);
    }

    @DisplayName("재시작 코드가 입력되면 시도 횟수 증가")
    @Test
    void 재시작_코드가_입력되면_시도_횟수_증가() {
        bridgeGame.move("D");
        bridgeGame.retry("R");

        assertThat(bridgeGame.getPlayer().getPlayResult().getTryCount().toString())
                .isEqualTo("2");
    }
}