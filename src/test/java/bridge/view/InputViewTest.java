package bridge.view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private final InputView inputView = new InputView();
    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }


    @Test
    void 다리의_길이_입력이_정상인경우() {
        String normalInput = "3";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(normalInput.getBytes());
        System.setIn(byteArrayInputStream);

        inputView.readBridgeSize();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .doesNotContain("[ERROR]");
    }

    @Test
    void 다리의_길이_입력이_숫자가_아닌_경우() {
        String nonNumericInput = "a\n3";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(nonNumericInput.getBytes());
        System.setIn(byteArrayInputStream);

        inputView.readBridgeSize();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .contains("[ERROR]");
    }

    @Test
    void 다리의_길이_입력이_공백인_경우() {
        String emptyInput = "\n3";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(emptyInput.getBytes());
        System.setIn(byteArrayInputStream);

        inputView.readBridgeSize();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .contains("[ERROR]");
    }

    @Test
    void 다리의_길이_입력이_3미만인_경우() {
        String wrongRangeInput = "2\n3";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(wrongRangeInput.getBytes());
        System.setIn(byteArrayInputStream);

        inputView.readBridgeSize();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .contains("[ERROR]");
    }

    @Test
    void 다리의_길이_입력이_20초과인_경우() {
        String wrongRangeInput = "21\n3";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(wrongRangeInput.getBytes());
        System.setIn(byteArrayInputStream);

        inputView.readBridgeSize();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .contains("[ERROR]");
    }

    @Test
    void 사용자가_이동할_다리_입력이_U인_경우() {
        String normalInput = "U";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(normalInput.getBytes());
        System.setIn(byteArrayInputStream);

        inputView.readMoving();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .doesNotContain("[ERROR]");
    }

    @Test
    void 사용자가_이동할_다리_입력이_D인_경우() {
        String normalInput = "D";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(normalInput.getBytes());
        System.setIn(byteArrayInputStream);

        inputView.readMoving();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .doesNotContain("[ERROR]");
    }

    @Test
    void 사용자가_이동할_다리_입력이_U_또는_D가_아닌_경우() {
        String wrongInput = "UU\nU";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(wrongInput.getBytes());
        System.setIn(byteArrayInputStream);

        inputView.readMoving();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .contains("[ERROR]");
    }

    @Test
    void 사용자가_이동할_다리_입력이_공백인_경우() {
        String wrongInput = "\n\nU";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(wrongInput.getBytes());
        System.setIn(byteArrayInputStream);

        inputView.readMoving();

        Assertions.assertThat(byteArrayOutputStream.toString())
                .contains("[ERROR]");
    }
}