package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"wrong", "input"})
    void 다리사이즈는_숫자만_입력가능(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        assertThatThrownBy(InputView::readBridgeSize)
                .hasMessage("[ERROR] : 숫자만 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" U", "U "," U "})
    void 다리이동_공백입력_테스트(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        assertDoesNotThrow(InputView::readMoving);
    }

    @ParameterizedTest
    @ValueSource(strings = {"u", "d"})
    void 다리이동_소문자입력_테스트(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        assertDoesNotThrow(InputView::readMoving);
    }

    @ParameterizedTest
    @ValueSource(strings = {" R", "R "," Q "})
    void 재시작_공백입력_테스트(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        assertDoesNotThrow(InputView::readGameCommand);
    }

    @ParameterizedTest
    @ValueSource(strings = {"r", "q"})
    void 재시작_소문자입력_테스트(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        assertDoesNotThrow(InputView::readGameCommand);
    }

}