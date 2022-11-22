package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovingTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("건너갈 다리 (D or U) 외 잘못된 입력")
    @Test
    void 예외_테스트_다리입력_미일치_1() {
        assertSimpleTest(() -> {
            runException("3", "R");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_다리입력_미일치_2() {
        assertSimpleTest(() -> {
            runException("3", "34");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 옳바른_입력() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "R", "U", "U", "U");
            assertThat(output()).contains(
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                    "최종 게임 결과"
            );
        }, 1, 1, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
