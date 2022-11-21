package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class InputTestBridgeSize extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";


    @DisplayName("다리 길이 입력 테스트 : 숫자가 아닌 영어 입력")
    @Test
    void testBridgeSizeByNotANumber() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("다리 길이 입력 테스트 : 범위를 벗어나는 숫자 입력")
    @Test
    void testBridgeSizeOutOfRange1() {
        assertSimpleTest(() -> {
            runException("1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("다리 길이 입력 테스트 : 범위를 벗어나는 숫자 입력 2")
    @Test
    void testBridgeSizeOutOfRange2() {
        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("다리 길이 입력 테스트 : 소수 입력")
    @Test
    void testBridgeSizeByFloatingNumber() {
        assertSimpleTest(() -> {
            runException("3.5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("다리 길이 입력 테스트 : space bar (whitespace 입력)")
    @Test
    void testBridgeSizeBySpaceBar() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("다리 길이 입력 테스트 : 줄바뀜 문자 입력")
    @Test
    void testBridgeSizeByOpeningChar() {
        assertSimpleTest(() -> {
            runException("\n");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
