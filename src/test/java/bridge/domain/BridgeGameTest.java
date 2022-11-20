package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        MoveResult moveResult = bridgeGame.move("U");

        // when
        String result = moveResult.getUpMovesString();

        // then
        assertThat(result).isEqualTo("O");
    }

    @DisplayName("이동할 수 없는 곳으로 움직이면 X를 표시한다.")
    @Test
    void 이동할_수_없는_곳으로_움직이면_X를_표시한다() {
        MoveResult moveResult = bridgeGame.move("D");

        // when
        String result = moveResult.getDownMovesString();

        // then
        assertThat(result).isEqualTo("X");
    }

    @DisplayName("잘못된 입력이 들어오면 예외가 발생한다.")
    @Test
    void 잘못된_입력이_들어오면_예외가_발생한다() {
        assertThatThrownBy(() -> bridgeGame.move("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}