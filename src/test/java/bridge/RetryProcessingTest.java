package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RetryProcessingTest extends CustomNsTest {

    private final RetryProcessing retryProcessing =
            new RetryProcessing();

    @Test
    @DisplayName("게임 다시 시작 여부 묻기")
    void readRetryTest() {

        //정상 종료할 경우
        {
            command("Q");
            retryProcessing.readRetry();
            assertThat(output()).contains(
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
            );
        }

        //리트라이 할 경우
        {
            command("R");
            retryProcessing.readRetry();
            assertThat(output()).contains(
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
            );
        }

        //처음 잘못된 문자로 인해 오류가 날 경우
        {
            command("QQ", "Q");
            retryProcessing.readRetry();
            assertThat(output()).contains(
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "[ERROR]"
            );
        }

        //처음 잘못된 문자로 인해 오류가 날 경우
        {
            command("RR", "R");
            retryProcessing.readRetry();
            assertThat(output()).contains(
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "[ERROR]"
            );
        }

        //처음 잘못된 문자로 인해 오류가 날 경우
        {
            command("D", "R");
            retryProcessing.readRetry();
            assertThat(output()).contains(
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "[ERROR]"
            );
        }
    }
}