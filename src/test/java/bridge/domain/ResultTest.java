package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @DisplayName("성공인 경우의 Result를 반환합니다.")
    @Test
    void 성공_Result_반환() {
        boolean isSuccess = true;

        Result result = Result.getResultBySuccess(isSuccess);

        assertThat(result).isEqualTo(Result.SUCCESS);
    }

    @DisplayName("실패인 경우의 Result를 반환합니다.")
    @Test
    void 실패_Result_반환() {
        boolean isSuccess = false;

        Result result = Result.getResultBySuccess(isSuccess);

        assertThat(result).isEqualTo(Result.FAIL);
    }

}