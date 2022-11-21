package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class InputTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";


    @DisplayName("다리 길이 입력 테스트 : 숫자가 아닌 영어 입력")
    @Test
    void testByNotANumber() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("다리 길이 입력 테스트 : 범위를 벗어나는 숫자 입력")
    @Test
    void testOutOfRange1() {
        assertSimpleTest(() -> {
            runException("1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("다리 길이 입력 테스트 : 범위를 벗어나는 숫자 입력 2")
    @Test
    void testOutOfRange2() {
        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("다리 길이 입력 테스트 : 소수 입력")
    @Test
    void testByFloatingNumber() {
        assertSimpleTest(() -> {
            runException("3.5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("다리 길이 입력 테스트 : space bar (whitespace 입력)")
    @Test
    void testBySpaceBar() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("다리 길이 입력 테스트 : 줄바뀜 문자 입력")
    @Test
    void testByOpeningChar() {
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
