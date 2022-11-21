package bridge.domain;

import static bridge.utils.Move.*;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.utils.Move;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class MoveResultTest {
    private MoveResult moveResult;

    @BeforeEach
    void init() {
        moveResult = new MoveResult();
    }

    @DisplayName("플레이어가 위로 움직이면 움직인 결과가 저장된다.")
    @ParameterizedTest
    @EnumSource(value = Move.class, names = {"SUCCESS", "FAIL"})
    void 플레이어가_위로_움직이면_움직인_결과가_저장된다(Move result) {
        // when
        moveResult.addMove(UP, result);

        // then
        assertThat(moveResult.getUpMovesString()).isEqualTo(result.getMoving());
    }

    @DisplayName("플레이어가 아래로 움직이면 움직인 결과가 저장된다.")
    @ParameterizedTest
    @EnumSource(value = Move.class, names = {"SUCCESS", "FAIL"})
    void 플레이어가_아래로_움직이면_움직인_결과가_저장된다(Move result) {
        // when
        moveResult.addMove(DOWN, result);

        // then
        assertThat(moveResult.getDownMovesString()).isEqualTo(result.getMoving());
    }

    @DisplayName("현재 다리를 얼마나 건넜는지 인덱스를 반환한다.")
    @Test
    void 현재_다리를_얼마나_건넜는지_인덱스를_반환한다() {
        moveResult.addMove(UP, SUCCESS);
        moveResult.addMove(UP, SUCCESS);
        moveResult.addMove(UP, SUCCESS);

        int result = moveResult.getStep();

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("다리를 끝까지 건넜다면 True를 반환한다.")
    @Test
    void 다리를_끝까지_건넜다면_True를_반환한다() {
        moveResult.addMove(UP, SUCCESS);
        moveResult.addMove(UP, SUCCESS);
        moveResult.addMove(UP, SUCCESS);

        boolean finish = moveResult.isFinish(3);

        assertThat(finish).isTrue();
    }

    @DisplayName("다리를 끝까지 건너지 못했다면 False를 반환한다.")
    @Test
    void 다리를_끝까지_건너지_못했다면_False를_반환한다() {
        moveResult.addMove(UP, SUCCESS);

        boolean finish = moveResult.isFinish(3);

        assertThat(finish).isFalse();
    }
}