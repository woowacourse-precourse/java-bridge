package bridge;

import bridge.view.InputView;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.DisplayName;

import java.io.*;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @DisplayName("다리 길이를 입력 할 때 범위 내 숫자가 아닌 문자를 입력하면 예외 발생")
    @ValueSource(strings = {"2","21","a"," ","1 "})
    @ParameterizedTest
    void inputExceededRangeBridgeSize (String inputNumber) {
        InputView input = new InputView();
        String bridgeSize = inputNumber;

        InputStream in = new ByteArrayInputStream(bridgeSize.getBytes());
        System.setIn(in);

        assertThatThrownBy(input::readBridgeSize)
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("이동할 칸을 입력할 땐 U,D외의 문자를 입력하면 예외 발생")
    @ValueSource(strings = {"P"," ","1","U "})
    @ParameterizedTest
    void inputOutOfFormMoving () {
        InputView input = new InputView();
        String bridgeSize = "P";

        InputStream in = new ByteArrayInputStream(bridgeSize.getBytes());
        System.setIn(in);

        assertThatThrownBy(input::readMoving)
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("재시작 커맨드 입력 시 지정된 문자 외의 다른 문자를 입력하면 예외 발생")
    @ValueSource(strings = {"U","1","R ","Q "})
    @ParameterizedTest
    void inputOutOfFormCommand () {
        InputView input = new InputView();
        String bridgeSize = "U ";

        InputStream in = new ByteArrayInputStream(bridgeSize.getBytes());
        System.setIn(in);

        assertThatThrownBy(input::readGameCommand)
                .isInstanceOf(NoSuchElementException.class);
    }
}
