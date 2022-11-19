package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @DisplayName("정답 여부가 결과에 입력되었을 때, 정답 여부 리스트와 시도 횟수가 잘 저장되는지 테스트")
    @Test
    void updateIsAnswers() {
        //given
        Result result = new Result();

        //when
        result.updateIsAnswers(new MoveDirection("U"), true);
        result.updateIsAnswers(new MoveDirection("D"), true);
        result.updateIsAnswers(new MoveDirection("D"), false);

        //then
        Assertions.assertThat(result.getTryCount())
                  .isEqualTo(3);
        Assertions.assertThat(result.getIsAnswers()
                                    .get(0)).isTrue();
        Assertions.assertThat(result.getIsAnswers()
                                    .get(1)).isTrue();
        Assertions.assertThat(result.getIsAnswers()
                                    .get(2)).isFalse();
    }
}