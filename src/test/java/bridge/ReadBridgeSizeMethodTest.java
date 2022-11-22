package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ReadBridgeSizeMethodTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("공통 예외: 공백(white space)으로만 구성된 입력을 받은 경우")
    @ParameterizedTest
    @ValueSource(strings = {" ", "\t", "\n", "", "            "})
    void readBridgeSizeMethodExceptionTest1(String whiteSpaceInput) {
        assertSimpleTest(() -> {
            run(whiteSpaceInput, "5");
            assertThat(output()).contains("[ERROR] 값을 입력해주세요.");
        });
    }

    @DisplayName("다리 길이 입력 예외 1: 문자열 길이가 3 이상인 입력")
    @ParameterizedTest
    @ValueSource(strings = {"ABC", "NEPPINESS", "neppiness", "132", "000", "$*#"})
    void readBridgeSizeMethodExceptionTest2(String inputLongerThanTwo) {
        assertSimpleTest(() -> {
            run(inputLongerThanTwo, "5");
            assertThat(output()).contains("[ERROR] 한 글자 또는 두 글자만 입력해주세요.");
        });
    }

    @DisplayName("다리 길이 입력 예외 2: 숫자 외 다른 문자가 사용된 입력")
    @ParameterizedTest
    @ValueSource(strings = {"$!", "aa", "0x", "*%", "1O", "정현", "김"})
    void readBridgeSizeMethodExceptionTest3(String nonNumberInput) {
        assertSimpleTest(() -> {
            run(nonNumberInput, "5");
            assertThat(output()).contains("[ERROR] 숫자 외 다른 문자는 입력할 수 없습니다.");
        });
    }

    @DisplayName("다리 길이 입력 예외 3: 십의 자리 숫자가 0인 숫자 입력")
    @ParameterizedTest
    @ValueSource(strings = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09"})
    void readBridgeSizeMethodExceptionTest4(String numberWithZeroAtTenthsPlace) {
        assertSimpleTest(() -> {
            run(numberWithZeroAtTenthsPlace, "5");
            assertThat(output()).contains("[ERROR] 십의 자리가 0일 수 없습니다.");
        });
    }

    @DisplayName("다리 길이 입력 예외 4: 3 이상 20 이하의 숫자가 아닌 입력")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "21", "22", "23", "24", "25", "26"})
    void readBridgeSizeMethodExceptionTest5(String numberOutOfRange) {
        assertSimpleTest(() -> {
            run(numberOutOfRange, "5");
            assertThat(output()).contains("[ERROR] 3 이상 20 이하의 자연수를 입력해주세요.");
        });
    }

    @DisplayName("다리 길이 입력 정상 테스트: 3 이상 20 이하의 자연수")
    @ParameterizedTest
    @ValueSource(strings = {"3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"})
    void readGameCommandMethodTest(String correctInput) {
        assertSimpleTest(() -> {
            run(correctInput);
            assertThat(output()).doesNotContain(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        InputView inputview = new InputView();
        inputview.readBridgeSize();
    }
}
