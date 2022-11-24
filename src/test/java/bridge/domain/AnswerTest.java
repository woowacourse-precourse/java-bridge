package bridge.domain;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AnswerTest {
    @DisplayName("true,false에 따라 정답을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"true,RIGHT", "false,WRONG"})
    void returnAnswer(boolean isCorrect, Answer answer) {
        Answer result = Answer.of(isCorrect);

        assertThat(result).isEqualTo(answer);
    }

}