package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputTestMovingStr extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";



    @DisplayName("이동할 칸 입력 테스트 : 다리길이 입력 후 U or D 가 아닌 다른 영어 입력")
    @Test
    void testMovingByOtherEnglish() {
        assertSimpleTest(() -> {
            runException("5", "a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("이동할 칸 입력 테스트 : 다리길이 입력 후 공백 입력")
    @Test
    void testMovingBySpaceBar() {
        assertSimpleTest(() -> {
            runException("5", " ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
