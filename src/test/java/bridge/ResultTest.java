package bridge;

import bridge.domain.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    private final Result result = new Result();

    @DisplayName("입력 값에 따라 재시작 여부를 결정한다.")
    @ParameterizedTest
    @CsvSource(value = {"R,"+true, "Q,"+false})
    void checkRestart(String input, boolean expected){
        result.checkKeeping(input);
        assertThat(result.isKeeping()).isEqualTo(expected);
    }

    @DisplayName("승패 여부를 결정한다.")
    @ParameterizedTest
    @CsvSource(value = {true+",성공", false+",실패"})
    void checkResult(boolean input, String expected){
        result.judgeResult(input);
        assertThat(result.getResultType().getName()).isEqualTo(expected);
    }
}
