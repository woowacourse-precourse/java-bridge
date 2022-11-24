package bridge;

import bridge.domain.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    Result result;

    @BeforeEach
    void setUp() {
        result = new Result();
    }

    @Test
    @DisplayName("UP 1개, DOWN 2개일 때 출력문이 UP: [ O |   |   ], DOWN: [   | O | O ]다.")
    void UP1개_DOWN2개_출력문을_테스트한다() {
        result.addUpstairs();
        result.addDownsStairs();
        result.addDownsStairs();

        assertThat(result.makeUpStairsMessage()).isEqualTo("[ O |   |   ]");
        assertThat(result.makeDownStairsMessage()).isEqualTo("[   | O | O ]");
    }
}
