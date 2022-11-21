package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeManagerTest {
    private static final String exceptionMessage = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static BridgeManager sut;

    @BeforeAll()
    static void setup() {
        BridgeNumberGenerator bridgeNumberGenerator = new ApplicationTest.TestNumberGenerator(new ArrayList<>(List.of(0, 0, 1, 0, 0, 1)));
        sut = new BridgeManager(bridgeNumberGenerator);
        sut.setBridgeWithSize(6);
    }

    @DisplayName("주어진 인덱스와 커맨드를 이용해서 다리를 건널 수 있는 지 검증한다.")
    @ParameterizedTest(name = "주어진 인덱스와 커맨드로 다리 건너기 테스트[{index}] => {1}번째 칸에 {0}을 입력하면 건널 수 있다.")
    @CsvSource(value = {"U:2", "U:5", "D:0", "D:1", "D:3", "D:4"}, delimiter = ':')
    void isMovableWithIndexAndCommand(String command, int index) {
        boolean actual = sut.isMovable(command, index);
        assertThat(actual).isTrue();
    }

    @DisplayName("다리 매니저에게 주어진 다리의 사이즈가 3 미만이라면 예외를 발생한다.")
    @ParameterizedTest(name = "다리 사이즈 유효성 검사 테스트[{index}] => {0}은 3 미만이기 때문에 예외를 발생한다.")
    @ValueSource(ints = {1, 2, -1, 0, -2, -3})
    void ifBridgeSizeLessThenThreeReturingException(int actual) {
        assertThatThrownBy(() -> sut.setBridgeWithSize(actual))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(exceptionMessage);
    }

    @DisplayName("다리 매니저에게 주어진 다리의 사이즈가 21 이상이라면 예외를 발생한다.")
    @ParameterizedTest(name = "다리 사이즈 유효성 검사 테스트[{index}] => {0}은 21 이상이기 때문에 예외를 발생한다.")
    @ValueSource(ints = {21, 22, 23, 24, 25, 999})
    void ifBridgeSizeGreaterThenTwentyOneReturingException(int actual) {
        assertThatThrownBy(() -> sut.setBridgeWithSize(actual))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(exceptionMessage);
    }
}