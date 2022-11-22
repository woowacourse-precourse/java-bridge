package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInputTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    InputException inputException = new InputException();

    @DisplayName("다리 길이가 3~20 범위가 아닐 때 오류 테스트")
    @Test
    void 다리_길이_범위_테스트_1() {
        assertSimpleTest(() -> {
            runException("22");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("다리 길이가 3~20 범위가 아닐 때 오류 테스트")
    @Test
    void 다리_길이_범위_테스트_2() {
        assertSimpleTest(() -> {
            runException("2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("다리 길이가 숫자가 아닐 때 오류 테스트")
    @Test
    void 다리_길이_유효_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("플레이어가 입력한 이동할 칸이 U(위 칸)와 D(아래 칸)가 아닐 때 오류 테스트")
    @Test
    void 이동_경로_유효_테스트() {
        assertThatThrownBy(() ->
                inputException.exceptionMoving("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 입력한 재시작/종료 여부가 R,Q가 아닐 때 오류 테스트")
    @Test
    void 재시작_종료_유효_테스트() {
        assertThatThrownBy(() ->
                inputException.exceptionGameCommand("D"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
