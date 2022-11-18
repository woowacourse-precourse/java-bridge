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

    private void setTestInput(String testInput) {
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
    }
}
