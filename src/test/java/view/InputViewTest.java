package view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    private static final InputView inputView = new InputView();

    @Test
    @DisplayName("다리의 길이가 3에서 20사이의 숫자가 아닐 경우 예외를 발생시킵니다.")
    void readBridgeSizeTest1() {
        setTestInput("21");

        assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리의 길이가 숫자가 아닐경우 예외를 발생시킵니다.")
    void readBridgeSizeTest2() {
        setTestInput("ab");

        assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리의 길이가 유효할 경우 반환값은 3에서 20사이의 숫자입니다.")
    void readBridgeSizeTest3() {
        setTestInput("14");

        assertThat(inputView.readBridgeSize()).isEqualTo(14);
    }

    @Test
    @DisplayName("이동 방향의 입력이 잘못된 문자일 경우 예외를 발생시킵니다.")
    void readMovingTest1() {
        setTestInput("Q");

        assertThatThrownBy(inputView::readMoving).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이동 방향의 입력이 문자가 아닐 경우 예외를 발생시킵니다.")
    void readMovingTest2() {
        setTestInput("1");

        assertThatThrownBy(inputView::readMoving).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이동 방향의 입력이 올바를 경우 잘 동작합니다.")
    void readMovingTest3() {
        setTestInput("U");

        assertThat(inputView.readMoving()).isEqualTo("U");
    }

    @Test
    @DisplayName("게임 종료 여부 커맨드의 입력이 잘못된 문자일 경우 예외를 발생시킵니다.")
    void readGameCommandTest1() {
        setTestInput("U");

        assertThatThrownBy(inputView::readGameCommand).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 종료 여부 커맨드의 입력이 문자가 아닐 경우 예외를 발생시킵니다.")
    void readGameCommandTest2() {
        setTestInput("1");

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
