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

   

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}