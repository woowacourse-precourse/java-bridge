package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class FunctionTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리길이_입력_예외_테스트() {
        assertSimpleTest(
                () -> {
                    runException("x");
                    assertThat(output().contains(ERROR_MESSAGE));
                });
    }

    @Test
    void 이동칸_입력_예외_테스트() {
        assertSimpleTest(
                () -> {
                    runException("1", "x");
                    assertThat(output().contains(ERROR_MESSAGE));
                });
    }

    @Test
    void 다시시도_여부_예외_테스트() {
        assertRandomNumberInRangeTest(() -> {
            runException("3", "U", "D", "D", "x");
            assertThat(output().contains(ERROR_MESSAGE));
        }, 1, 0, 1);
    }

    @Test
    void 게임_성공_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            assertThat(output()).contains(
                    "다리 건너기 게임을 시작합니다",
                    "다리의 길이를 입력해주세요.",
                    "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                    "[ O ]",
                    "[   ]",
                    "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                    "[ O |   ]",
                    "[   | O ]",
                    "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );
        }, 1, 0, 1);
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }


}