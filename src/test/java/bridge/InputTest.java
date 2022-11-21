package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class InputTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 빈_값_입력_경우_오류_테스트() {
        assertSimpleTest(() -> {
            //given
            String input = " ";
            //when
            runException(input);
            //then
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 문자_입력_경우_오류_테스트() {
        assertSimpleTest(() -> {
            //given
            String input = "ㅁ";
            //when
            runException(input);
            //then
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
