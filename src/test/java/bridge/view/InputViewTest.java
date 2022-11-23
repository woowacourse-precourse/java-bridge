package bridge.view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    private final InputView inputView = new InputView();
    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "20"})
    void 다리의_길이_입력이_정상인경우(String normalInput) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(normalInput.getBytes());
        System.setIn(byteArrayInputStream);

        inputView.readBridgeSize();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .doesNotContain("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a\n3", "3a\n3"})
    void 다리의_길이_입력이_숫자가_아닌_경우(String nonNumericInput) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(nonNumericInput.getBytes());
        System.setIn(byteArrayInputStream);

        inputView.readBridgeSize();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .contains("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"\n\n3", " \n3", "\n3"})
    void 다리의_길이_입력이_공백인_경우(String emptyInput) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(emptyInput.getBytes());
        System.setIn(byteArrayInputStream);

        inputView.readBridgeSize();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .contains("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1\n3", " 0\n3", "2\n3"})
    void 다리의_길이_입력이_3미만인_경우(String wrongRangeInput) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(wrongRangeInput.getBytes());
        System.setIn(byteArrayInputStream);

        inputView.readBridgeSize();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .contains("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"21\n3", "999999999999999999999999\n3"})
    void 다리의_길이_입력이_20초과인_경우(String wrongRangeInput) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(wrongRangeInput.getBytes());
        System.setIn(byteArrayInputStream);

        inputView.readBridgeSize();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .contains("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void 사용자가_이동할_다리_입력이_U또는_D인_경우(String normalInput) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(normalInput.getBytes());
        System.setIn(byteArrayInputStream);

        inputView.readMoving();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .doesNotContain("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"UU\nU", "DD\nU", "3\nU"})
    void 사용자가_이동할_다리_입력이_U_또는_D가_아닌_경우(String wrongInput) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(wrongInput.getBytes());
        System.setIn(byteArrayInputStream);

        inputView.readMoving();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .contains("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"\nU", " \nU", "\n\nU"})
    void 사용자가_이동할_다리_입력이_공백인_경우(String wrongInput) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(wrongInput.getBytes());
        System.setIn(byteArrayInputStream);

        inputView.readMoving();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .contains("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void 게임을_다시_시도할지의_입력이_R또는_Q인_경우(String normalInput) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(normalInput.getBytes());
        System.setIn(byteArrayInputStream);

        inputView.readGameCommand();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .doesNotContain("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"\n\nQ", "\nQ", " \nQ"})
    void 게임을_다시_시도할지의_입력이_공백인_경우(String wrongInput) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(wrongInput.getBytes());
        System.setIn(byteArrayInputStream);

        inputView.readGameCommand();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .contains("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"RR\nQ", "QQ\nQ", " 3\nQ"})
    void 게임을_다시_시도할지의_입력이_R_또는_Q가_아닌_경우(String wrongInput) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(wrongInput.getBytes());
        System.setIn(byteArrayInputStream);

        inputView.readGameCommand();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .contains("[ERROR]");
    }
}