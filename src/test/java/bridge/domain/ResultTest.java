package bridge.domain;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

class ResultTest {

    Result result = new Result();

    @DisplayName("두번 째 시도에서 세 차례 연속으로 다리 건너기에 성공했다.")
    @BeforeEach
    void setup() {
        result.updateNumberOfTrials();

        result.setGameResult(Boolean.TRUE);
        result.setGameResult(Boolean.TRUE);
        result.setGameResult(Boolean.TRUE);
    }

    @DisplayName("시행 횟수를 조회한 결과 두 번째 시도이다.")
    @Test
    void getNumberOfTrials() {
        int trialNumber = result.getNumberOfTrials();

        assertThat(trialNumber).isEqualTo(2);
    }

    @DisplayName("게임의 결과를 정상적으로 초기화한다.")
    @Test
    void resetGameResult() {

        result.resetGameResult();

        assertThat(result.getGameResult()).isEqualTo(new ArrayList<>());
    }

    @DisplayName("한 차례 더 다리를 성공적으로 건넌 후 '성공' 문구를 리턴한다.")
    @Test
    void getSuccessComment() {
        result.setGameResult(Boolean.TRUE);

        String gameResultComment = result.getSuccessOrFailure();

        System.out.println(result.getGameResult());
        assertThat(gameResultComment).isEqualTo("성공");
    }

    @DisplayName("추가적으로 다리 건너기에 실패한 후 '실패' 문구를 리턴한다.")
    @Test
    void getFailureComment() {
        result.setGameResult(Boolean.FALSE);

        String gameResultComment = result.getSuccessOrFailure();

        System.out.println(result.getGameResult());
        assertThat(gameResultComment).isEqualTo("실패");
    }
}