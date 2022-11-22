package bridge;

import bridge.exception.BridgeException;
import bridge.exception.ErrorMessage;
import bridge.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    InputView inputView = new InputView();

    @DisplayName("다리 길이의 입력값이 3-20 사이가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "21", "22"})
    void createBridgeByNotInRange(String size) {
        InputStream in = new ByteArrayInputStream(size.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.SIZE_LANGE_ERROR);
    }
    @DisplayName("다리 길이의 입력값이 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"!!!","nope"})
    void createBridgeByNotNumber(String size){
        InputStream in = new ByteArrayInputStream(size.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.SIZE_FORMAT_ERROR);

    }

    @DisplayName("이동할 칸의 입력값이 대문자 U나 대문자 D가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"d", "u", "s", "1"})
    void checkMovingByNotRequired(String moving) {
        InputStream in = new ByteArrayInputStream(moving.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MOVING_ERROR);
    }


    @DisplayName("게임 재시작시 입력값이 대문자 R이나 대문자 Q이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "1","S","R Q","RQ"})
    void checkRestartByNotRequired(String restart) {
        InputStream in = new ByteArrayInputStream(restart.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.readGameCommand())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.RESTART_ERROR);
    }

}
