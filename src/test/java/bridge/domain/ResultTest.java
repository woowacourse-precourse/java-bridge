package bridge.domain;

import bridge.domain.MoveDirection;
import bridge.domain.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    private static final String UP_SIGN = "U";
    private static final String DOWN_SIGN = "D";

    private Result result;
    @BeforeEach
    void setUp() {
        result = new Result();
    }

    @DisplayName("정답 여부가 결과에 입력되었을 때, 정답 여부 리스트가 잘 저장되는지 테스트")
    void updateIsAnswers() {
        //given
        //when
        result.updateIsAnswers(new MoveDirection(UP_SIGN), true);
        result.updateIsAnswers(new MoveDirection(DOWN_SIGN), true);
        result.updateIsAnswers(new MoveDirection(DOWN_SIGN), false);
        //then
        assertThat(result.getIsAnswers()
                                    .get(0)).isTrue();
        assertThat(result.getIsAnswers()
                                    .get(1)).isTrue();
        assertThat(result.getIsAnswers()
                                    .get(2)).isFalse();
    }

    @DisplayName("사용자가 입력한 방향이 U이고, 실제 정답일 경우 참을 반환하는지 테스트")
    @Test
    void isUpSignAnswer() {
        //given
        boolean isAnswer = true;
        MoveDirection direction = new MoveDirection(UP_SIGN);
        //when
        boolean upSignAnswer = result.isUpSignAnswer(isAnswer, direction);
        //then
        assertThat(upSignAnswer)
                  .isTrue();
    }

    @DisplayName("사용자가 입력한 방향이 U이고, 실제 정답이 아닐 경우 참을 반환하는지 테스트")
    @Test
    void isUpSignWrongAnswer() {
        //given
        boolean isAnswer = false;
        MoveDirection direction = new MoveDirection(UP_SIGN);
        //when
        boolean upSignWrongAnswer = result.isUpSignWrongAnswer(isAnswer, direction);
        //then
        assertThat(upSignWrongAnswer)
                .isTrue();
    }

    @DisplayName("사용자가 입력한 방향이 D이고, 실제 정답일 경우 참을 반환하는지 테스트")
    @Test
    void isDownSignAnswer() {
        //given
        boolean isAnswer = true;
        MoveDirection direction = new MoveDirection(DOWN_SIGN);
        //when
        boolean downSignAnswer = result.isDownSignAnswer(isAnswer, direction);
        //then
        assertThat(downSignAnswer)
                .isTrue();
    }

    @DisplayName("사용자가 입력한 방향이 D이고, 실제 정답이 아닐 경우 참을 반환하는지 테스트")
    @Test
    void isDownSignWrongAnswer() {
        //given
        boolean isAnswer = false;
        MoveDirection direction = new MoveDirection(DOWN_SIGN);
        //when
        boolean downSignWrongAnswer = result.isDownSignWrongAnswer(isAnswer, direction);
        //then
        assertThat(downSignWrongAnswer)
                .isTrue();
    }

    @DisplayName("사용자가 입력한 값 중 오답이 포함되어 있다면, 참을 반환하는지 테스트")
    @Test
    void hasWrong() {
        //given
        result.updateIsAnswers(new MoveDirection(UP_SIGN), false);
        //when
        boolean hasWrong = result.hasWrong();
        //then
        assertThat(hasWrong).isTrue();
    }
}