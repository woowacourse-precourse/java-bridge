package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest extends NsTest {

    @DisplayName("3~20의 수를 입력받으면 그 수를 잘 출력한다.")
    @ValueSource(strings = {"3", "4", "5", "10", "15", "20"})
    @ParameterizedTest
    void readBridgeSize(Integer input) {
        InputView inputView = new InputView();
        command("3", "4", "5", "10", "15", "20");

        Integer size = inputView.readBridgeSize();

        assertThat(size).isEqualTo(input);
    }

    @DisplayName("숫자가 아닌 입력을 받으면 예외를 발생시킨다.")
    @ValueSource(strings = {"a", ">>", "67@", "1@#$", "한글"})
    @ParameterizedTest
    void readBridgeSizeNotNumber(String string) {
        InputView inputView = new InputView();
        command("a", ">>", "67@", "1@#$", "한글");

        assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 입력을 받으면 예외를 발생시킨다. - 메시지 테스트")
    @ValueSource(strings = {"a", ">>", "67@", "1@#$", "한글"})
    @ParameterizedTest
    void readBridgeSizeNotNumberPrint(String string) {
        InputView inputView = new InputView();
        command("a", ">>", "67@", "1@#$", "한글");

        try {
            inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        assertThat(output().trim()).contains(ExceptionPhrases.NOT_NUMBER.toString());
    }

    @DisplayName("범위 밖의 숫자를 입력받으면 예외를 발생시킨다.")
    @ValueSource(strings = {"-3", "0", "1", "21", "1000", "2147483647"})
    @ParameterizedTest
    void readBridgeSizeNumberOutOfRange() {
        InputView inputView = new InputView();
        command("-3", "0", "1", "21", "1000", "2147483647");

        try {
            inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        assertThat(output().trim()).contains(ExceptionPhrases.OUT_OF_RANGE.toString());
    }

    @DisplayName("범위 밖의 숫자를 입력받으면 예외를 발생시킨다. - 메시지 테스트")
    @ValueSource(strings = {"-3", "0", "1", "21", "1000", "2147483647"})
    @ParameterizedTest
    void readBridgeSizeNumberOutOfRangePrint() {
        InputView inputView = new InputView();
        command("-3", "0", "1", "21", "1000", "2147483647");

        assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}