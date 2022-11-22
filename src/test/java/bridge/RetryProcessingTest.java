package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RetryProcessingTest extends CustomNsTest {

    private final RetryProcessing retryProcessing =
            new RetryProcessing();

    @ParameterizedTest
    @DisplayName("게임 다시 시작 여부 묻기(실패 케이스)")
    @CsvSource({
            "QQ, Q",
            "RR, R",
            "D, R"
    })
    void readRetryFailTest(String firstCommand, String secondCommand) {

        command(firstCommand, secondCommand);
        retryProcessing.readRetry();
        assertThat(output()).contains(
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                "[ERROR]"
        );
    }

    @ParameterizedTest
    @DisplayName("게임 다시 시작 여부 묻기(성공 케이스)")
    @CsvSource({
            "Q",
            "R",
    })
    void readRetrySuccessTest(String firstCommand) {

        command(firstCommand);
        retryProcessing.readRetry();
        assertThat(output()).contains(
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
        );
    }
}