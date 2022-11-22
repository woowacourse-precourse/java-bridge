package view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    private static final InputView inputView = new InputView();

    @ParameterizedTest
    @ValueSource(strings = {"21", "2", "-1"})
    @DisplayName("다리의 길이가 3에서 20사이의 숫자가 아닐 경우 예외를 발생시킵니다.")
    void readBridgeSizeTest1(String input) {
        setTestInput(input);

        assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ab", "*^", "a1b"})
    @DisplayName("다리의 길이가 숫자가 아닐경우 예외를 발생시킵니다.")
    void readBridgeSizeTest2(String input) {
        setTestInput(input);

        assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리의 길이가 유효할 경우 반환값은 3에서 20사이의 숫자입니다.")
    void readBridgeSizeTest3() {
        setTestInput("14");

        assertThat(inputView.readBridgeSize()).isEqualTo(14);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Q", "R", "u", "d"})
    @DisplayName("이동 방향의 입력이 잘못된 문자일 경우 예외를 발생시킵니다.")
    void readMovingTest1(String input) {
        setTestInput(input);

        assertThatThrownBy(inputView::readMoving).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "2", "-1", "0"})
    @DisplayName("이동 방향의 입력이 문자가 아닐 경우 예외를 발생시킵니다.")
    void readMovingTest2(String input) {
        setTestInput(input);

        assertThatThrownBy(inputView::readMoving).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이동 방향의 입력이 올바를 경우 잘 동작합니다.")
    void readMovingTest3() {
        setTestInput("U");

        assertThat(inputView.readMoving()).isEqualTo("U");
    }

    @ParameterizedTest
    @ValueSource(strings = {"q", "r", "U", "D"})
    @DisplayName("게임 종료 여부 커맨드의 입력이 잘못된 문자일 경우 예외를 발생시킵니다.")
    void readGameCommandTest1(String input) {
        setTestInput(input);

        assertThatThrownBy(inputView::readGameCommand).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "0", "-1"})
    @DisplayName("게임 종료 여부 커맨드의 입력이 문자가 아닐 경우 예외를 발생시킵니다.")
    void readGameCommandTest2(String input) {
        setTestInput(input);

        assertThatThrownBy(inputView::readGameCommand).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 종료 여부 커맨드의 입력이 올바를 경우 잘 동작합니다.")
    void readGameCommandTest3() {
        setTestInput("R");

        assertThat(inputView.readGameCommand()).isEqualTo("R");
    }

    private void setTestInput(String testInput) {
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
    }
}
