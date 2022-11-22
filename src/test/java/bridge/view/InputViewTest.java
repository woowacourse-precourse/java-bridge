package bridge.view;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("다리길이를 입력 받을 때 입력 값이 숫자가 아니면 예외문구를 출력하고, 다시 입력을 받을 수 있다.")
    void 다리길이를_입력_받을때_숫자를_입력하지_않은_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("three","3", "U", "D", "U");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );

        }, 1, 0, 1);
    }

    @Test
    @DisplayName("다리길이를 입력 받을 때 범위를 넘어섰다면 예외 문구를 출력하고 다시 입력 받을 수 있다.")
    void 다리길이를_입력_받을때_범위를_넘은_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("30","3", "U", "D", "U");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );

        }, 1, 0, 1);
    }

    @Test
    @DisplayName("사용자가 이동할 칸을 입력할 때 D,U외의 입력을 할 경우 예외문구를 출력하고 다시 입력을 받을 수 있다.")
    void 사용자가_이동할_칸을_잘못_입력한_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "R", "D", "U");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
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