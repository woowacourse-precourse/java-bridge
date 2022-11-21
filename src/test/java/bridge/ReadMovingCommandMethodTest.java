package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ReadMovingCommandMethodTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final InputView inputview = new InputView();

    @DisplayName("공통 예외: 공백(white space)으로만 구성된 입력을 받은 경우")
    @ParameterizedTest
    @ValueSource(strings = {" ", "\t", "\n", "", "            "})
    void readGameCommandMethodExceptionTest1(String whiteSpaceInput) {
        assertSimpleTest(() -> {
            run(whiteSpaceInput, "U");
            assertThat(output()).contains("[ERROR] 값을 입력해주세요.");
        });
    }

    @DisplayName("게임 재시작/종료 코드 예외 1: 문자열 길이가 2 이상인 입력")
    @ParameterizedTest
    @ValueSource(strings = {"ABC", "NEPPINESS", "neppiness", "12", "00", "*#"})
    void readGameCommandMethodExceptionTest2(String inputLongerThanOne) {
        assertSimpleTest(() -> {
            run(inputLongerThanOne, "U");
            assertThat(output()).contains("[ERROR] 한 글자만 입력해주세요.");
        });
    }

    @DisplayName("게임 재시작/종료 코드 예외 2: U 또는 D가 아닌 문자 하나 입력")
    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "a", "R", "Q", "u", "d", "&", "`"})
    void readGameCommandMethodExceptionTest3(String neitherRNorQ) {
        assertSimpleTest(() -> {
            run(neitherRNorQ, "U");
            assertThat(output()).contains("[ERROR] U 또는 D를 입력해주세요.");
        });
    }

    @DisplayName("정상 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void readGameCommandMethodTest(String correctInput) {
        assertSimpleTest(() -> {
            run(correctInput);
            assertThat(output()).doesNotContain(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        InputView inputview = new InputView();
        inputview.readMovingCommand();
    }
}
