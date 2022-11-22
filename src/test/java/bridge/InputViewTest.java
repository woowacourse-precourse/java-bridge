package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("3 ~ 20이 아닌 값으로 다리 크기를 지정하면 오류메세지를 출력한다.")
    @Test
    void build_bridge_out_of_bound_size() {
        assertSimpleTest(() -> {
            runException("212");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("다리 이동 시 U 또는 D를 입력하지 않으면 예외를 발생시킨다.")
    @Test
    void move_with_invalid_input() {
        assertThatThrownBy(() -> {
            runException("3","Q");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임을 재시작할 때 입력값이 R 또는 Q가 아니면 예외를 발생시킨다.")
    @Test
    void retry_with_invalid_input() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "C");
            assertThatThrownBy(() -> {
                assertThat(output()).contains(
                        "[ O |   |   ]",
                        "[   | O | X ]",
                        "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
                );
            }).isInstanceOf(IllegalArgumentException.class);
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
