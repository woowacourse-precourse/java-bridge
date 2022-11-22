package bridge;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.InputMismatchException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeTest {

    @DisplayName("다리 길이가 3이상 20이하의 범위 밖의 수가 입력되는 경우에 대한 예외 처리")
    @ValueSource(ints = {1000, 200, 2})
    @ParameterizedTest
    void rangeTest(Integer input) {
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.rangeErr(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 커맨드 U,D 이외 문자 및 공백 예외처리")
    @ValueSource(strings = {"?","A","2","  "})
    @ParameterizedTest
    void moveTest(String input) {
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.throwException(input))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("재시작 커맨드 R,Q 이외 문자 및 공백 예외처리")
    @ValueSource(strings = {"A","?","1000j","  "})
    @ParameterizedTest
    void restartCommandTest(String input){
        InputView inputview = new InputView();

        assertThatThrownBy(() -> inputview.commandError(input))
                .isInstanceOf(InputMismatchException.class);
    }


}

