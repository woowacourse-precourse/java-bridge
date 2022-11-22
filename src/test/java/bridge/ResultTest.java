package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    Result result;

    @BeforeEach
    void setUp() {
        result = new Result();
    }

    @DisplayName("결과 추가 테스트")
    @Test
    void addResult() {
        String movingPosition = "U";
        boolean isCorrect = true;
        result.addResult(movingPosition, isCorrect);
        Assertions.assertThat(result.getResults().get(0)).isEqualTo(List.of("U", "O"));
    }

    @DisplayName("마지막 저장된 결과값 삭제 테스트")
    @Test
    void removeLastResult() {
        String movingPosition = "U";
        boolean isCorrect = true;
        result.addResult(movingPosition, isCorrect);
        result.removeLastResult();
        Assertions.assertThat(result.getResults().size()).isEqualTo(0);
    }

    @DisplayName("시도 횟수 증가 테스트")
    @Test
    void addTryCount() {
        result.addTryCount();
        Assertions.assertThat(result.getTryCount()).isEqualTo(2);
    }
}