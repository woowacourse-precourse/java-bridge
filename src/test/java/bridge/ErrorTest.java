package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class ErrorTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("게임을 실패할 경우를 출력하는 기능 테스트")
    @Test
    void 실패_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "U", "D", "D", "Q");
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O |   |   ]",
                "[   | O |   | O | X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   | O |   |   ]");
            int downSideIndex = output().indexOf("[   | O |   | O | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1,0,1);
    }

    @DisplayName("게임을 재시작할 경우를 출력하는 기능 테스트")
    @Test
    void 재시작_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "D", "R", "D", "R", "U", "D", "U", "D", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O |   | O ]",
                    "[   | O |   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 3"
            );

            int upSideIndex = output().indexOf("[ O |   | O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1,0,1);
    }

    @DisplayName("다리 생성 입력기능에 빈칸이 포함되어 있으면 에러를 표시한다.")
    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("다리 생성 입력이 범위를 벗어나면 에러를 표시한다.")
    @Test
    void 예외_테스트_2() {
        assertSimpleTest(() -> {
            runException("50");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("다리이동 입력기능에 다른 문자를 입력하면 에러를 표시한다.")
    @Test
    void 다리이동_예외_테스트() {
        assertSimpleTest(() -> {
            runException("A");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("재시작 입력기능에 다른 문자를 입력하면 에러를 표시한다.")
    @Test
    void 재시작_예외_테스트() {
        assertSimpleTest(() -> {
            runException("A");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }


}
