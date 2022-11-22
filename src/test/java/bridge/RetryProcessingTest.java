package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RetryProcessingTest extends CustomNsTest {

    private final RetryProcessing retryProcessing =
            new RetryProcessing();

    @ParameterizedTest
    @DisplayName("게임 다시 시작 여부 묻기")
    @CsvSource({
            "QQ, Q",
            "RR, R",
            "D, R"
    })
    void readRetryTest(String firstCommand, String secondCommand) {

        //처음 잘못된 문자로 인해 오류가 날 경우
        command(firstCommand, secondCommand);
        retryProcessing.readRetry();
        assertThat(output()).contains(
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                "[ERROR]"
        );
    }
}