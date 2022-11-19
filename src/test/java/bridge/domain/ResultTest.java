package bridge.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    Result result = new Result();

    @DisplayName("사용자의 이동 입력이 정답인 경우와 오답인 경우 테스트")
    @Test
    void testResult() {
        assertEquals(result.returnResult(true), "성공");
        assertEquals(result.returnResult(false), "실패");
    }
}
