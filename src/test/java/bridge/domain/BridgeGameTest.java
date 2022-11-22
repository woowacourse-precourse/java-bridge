package bridge.domain;

import static bridge.utils.value.GameCommand.*;
import static bridge.utils.value.Move.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.utils.value.GameCommand;
import bridge.utils.value.Move;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        bridgeGame = new BridgeGame(List.of("U", "D", "D"));
    }

    @DisplayName("이동할 수 있는 곳으로 움직이면 O를 표시한다.")
    @Test
    void 이동할_수_있는_곳으로_움직이면_O를_표시한다() {
        bridgeGame.move(UP);
        MoveResult moveResult = bridgeGame.getMoveResult();

        String result = moveResult.getUpMovesString();

        assertThat(result).isEqualTo("O");
    }

    @DisplayName("이동할 수 없는 곳으로 움직이면 X를 표시한다.")
    @Test
    void 이동할_수_없는_곳으로_움직이면_X를_표시한다() {
        bridgeGame.move(DOWN);
        MoveResult moveResult = bridgeGame.getMoveResult();

        String result = moveResult.getDownMovesString();

        assertThat(result).isEqualTo("X");
    }

    @DisplayName("잘못된 입력이 들어오면 예외가 발생한다.")
    @Test
    void 잘못된_입력이_들어오면_예외가_발생한다() {
        assertThatThrownBy(() -> Move.validateMove("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작으로 R을 입력하면 필드값을 초기화한다.")
    @Test
    void 재시작으로_R을_입력하면_게임을_초기화한다() {
        bridgeGame.move(DOWN);
        bridgeGame.retry(PLAY);

        assertThat(bridgeGame.getMoveResult().getStep()).isEqualTo(0);
    }

    @DisplayName("재시작으로 Q를 입력하면 값을 초기화하지 않는다.")
    @Test
    void 재시작으로_Q를_입력하면_값을_초기화하지_않는다() {
        bridgeGame.move(DOWN);
        bridgeGame.retry(FINISH);

        assertThat(bridgeGame.getMoveResult().getStep()).isNotEqualTo(0);
    }

    @DisplayName("재시작으로 잘못된 값을 입력하면 예외가 발생한다.")
    @Test
    void 재시작으로_잘못된_값을_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> GameCommand.validateCommand("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작하면 게임 시도 횟수가 증가한다.")
    @Test
    void 재시작하면_게임_시도_횟수가_증가한다() {
        // when
        bridgeGame.retry(PLAY);

        // then
        assertThat(bridgeGame.getTotalCount()).isEqualTo(2);
    }
}