package bridge;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ResultTest {

    @DisplayName("결과 추가 테스트 - 위, 성공")
    @Test
    public void appnedResultTest_UP_SUCCESS() {
        Result result = new Result(0);
        result.appendResult(ResultType.SUCCESS, Direction.UP);
        List<ResultType> firstTestRow = List.of(ResultType.SUCCESS);
        List<ResultType> secondTestRow = List.of(ResultType.EMPTY);
        assertThat(result.getFirstRow()).isEqualTo(firstTestRow);
        assertThat(result.getSecondRow()).isEqualTo(secondTestRow);
    }

    @DisplayName("결과 추가 테스트 - 아래, 실패")
    @Test
    public void appnedResultTest_DOWN_FAIL() {
        Result result = new Result(0);
        result.appendResult(ResultType.FAIL, Direction.DOWN);
        List<ResultType> firstTestRow = List.of(ResultType.EMPTY);
        List<ResultType> secondTestRow = List.of(ResultType.FAIL);
        assertThat(result.getFirstRow()).isEqualTo(firstTestRow);
        assertThat(result.getSecondRow()).isEqualTo(secondTestRow);
    }

    @DisplayName("결과 시도 횟수 테스트")
    @Test
    public void getCountTest() {
        Result result = new Result(0);
        result.appendResult(ResultType.FAIL, Direction.DOWN);
        Result result2 = new Result(result.getCount());
        assertThat(result2.getCount()).isEqualTo(2);
    }

    @DisplayName("마지막 결과 테스트")
    @Test
    public void getLastResultTypeTest() {
        Result result = new Result(0);
        result.appendResult(ResultType.FAIL, Direction.DOWN);
        assertThat(result.getLastResultType()).isEqualTo(ResultType.FAIL);
    }
}
