package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeSizeGetterTest {
    @ParameterizedTest
    @DisplayName("다리 길이 입력 받아오기 기능 테스트: 올바르지 않은 입력일 경우 예외 발생")
    @ValueSource(strings = {"let", "it", "crash", "부서져라", "21", "2", "020", ""})
    void getBridgeSizeTest_exceptionThrowingTest(String userInput) {
        BridgeSizeGetter getter = new BridgeSizeGetter();

        System.setIn(new ByteArrayInputStream((userInput).getBytes()));

        assertThatThrownBy(getter::getBridgeSizeFromConsole)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("다리 길이 입력 받아오기 기능 테스트: 올바른 입력일 경우 상응하는 정수 타입 값을 반환")
    @ValueSource(strings = {
            "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
            "13", "14", "15", "16", "17", "18", "19", "20"})
    void getBridgeSizeTest_normalExecutionTest(String userInput) {
        BridgeSizeGetter getter = new BridgeSizeGetter();
        System.setIn(new ByteArrayInputStream((userInput).getBytes()));

        Integer correctResult = Integer.parseInt(userInput);
        Integer actualResult = getter.getBridgeSizeFromConsole();

        assertThat(actualResult).isEqualTo(correctResult);
    }
}
