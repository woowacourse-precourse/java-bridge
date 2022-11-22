package bridge.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {
    private final InputView inputView = new InputView();
    private final String ERROR = "[ERROR]";

    @DisplayName("[예외 테스트] 다리길이 입력값이 숫자가 아님")
    @ValueSource(strings = {"a", "1a", "3b", " "})
    @ParameterizedTest
    void bridgeSizeNotANum(String input) {
        //given
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //when then
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @DisplayName("[예외 테스트] 다리길이 입력값이 범위를 벗어남")
    @ValueSource(strings = {"0", "1", "2", "21", "22"})
    @ParameterizedTest
    void bridgeSizeOutOfRange(String input) {
        //given
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //when then
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @DisplayName("다리길이 입력 받기")
    @ValueSource(strings = {"3", "4", "7", "15", "20"})
    @ParameterizedTest
    void readBridgeSize(String input) {
        //given
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //when
        int bridgeSize = inputView.readBridgeSize();
        //then
        assertThat(bridgeSize).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("[예외 테스트] 사용자 이동 입력값이 올바르지 않음")
    @ValueSource(strings = {"UP", "DOWN", " "})
    @ParameterizedTest
    void movingInputNotProper(String input) {
        //given
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //when then
        assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @DisplayName("사용자 이동 입력 받기")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void readMoving(String input) {
        //given
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //when
        String moving = inputView.readMoving();
        //then
        assertThat(moving).isEqualTo(input);
    }

    @DisplayName("[예외 테스트] 재시도 여부 입력값이 올바르지 않음")
    @ValueSource(strings = {"RETRY", "QUIT", " "})
    @ParameterizedTest
    void gameCommandInputNotProper(String input) {
        //given
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //when then
        assertThatThrownBy(() -> inputView.readGameCommand())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @DisplayName("재시도 여부 입력 받기")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void readGameCommand(String input) {
        //given
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //when
        String gameCommand = inputView.readGameCommand();
        //then
        assertThat(gameCommand).isEqualTo(input);
    }

    @DisplayName("제대로 된 다리 사이즈 입력받을 떄까지 요구")
    @Test
    void reReadBridgeSizeWhenError() {
        //given
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        List<String> inputs = List.of("0", "a", "1", "abd", "2", "21", "24", "20");
        String input = String.join("\n", inputs);
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //when
        inputView.reReadBridgeSizeWhenError();
        //then
        String[] resultLines = byteArrayOutputStream.toString().split("\n");
        assertThat(resultLines).allSatisfy(result -> assertThat(result).contains(ERROR));
    }

    @DisplayName("제대로 된 이동을 입력받을 떄까지 요구")
    @Test
    void reReadMovingWhenError() {
        //given
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        List<String> inputs = List.of("a", "1", "4", "UP", "DOWN", "U");
        String input = String.join("\n", inputs);
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //when
        inputView.reReadMovingWhenError();
        //then
        String[] resultLines = byteArrayOutputStream.toString().split("\n");
        assertThat(resultLines).allSatisfy(result -> assertThat(result).contains(ERROR));
    }

    @DisplayName("제대로 된 재도전 여부를 입력받을 떄까지 요구")
    @Test
    void reReadGameCommandWhenError() {
        //given
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        List<String> inputs = List.of("1", "a", "r", "q", "RETRY", "R");
        String input = String.join("\n", inputs);
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //when
        inputView.reReadGameCommandWhenError();
        //then
        String[] resultLines = byteArrayOutputStream.toString().split("\n");
        assertThat(resultLines).allSatisfy(result -> assertThat(result).contains(ERROR));
    }
}