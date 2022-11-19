package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    private Result result;

    @BeforeEach
    void init() {
        result = new Result();
    }

    @DisplayName("이동 가능한 칸이면 O, 아니면 X를 추가")
    @Test
    void updateResult() {
        result.update("O", "U");
        result.update("X", "U");
        assertThat(result.getUp().get(0)).isEqualTo("O");
        assertThat(result.getUp().get(1)).isEqualTo("X");
        assertThat(result.getDown().size()).isEqualTo(0);
    }

    @DisplayName("시도 횟수 증가 확인")
    @Test
    void updateNumberOfTrial() {
        result.updateNumberOfTrial();
        assertThat(result.getNumberOfTrial()).isEqualTo(1);
    }
}