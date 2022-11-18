package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    private final InputView inputView;

    public InputViewTest() {
        this.inputView = new InputView();
    }

    @Test
    void readBridgeSizeTest1() {
        assertSimpleTest(() -> {
            command("15");
            assertThat(inputView.readBridgeSize()).isEqualTo(15);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "21", "2a", ""})
    void readBridgeSizeExceptionTest1(String line) {
        assertSimpleTest(() -> {
            command(line);
            assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void readMovingTest1() {
        assertSimpleTest(() -> {
            command("D");
            assertThat(inputView.readMoving()).isEqualTo("D");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "", " ", "DU", "D U", "123",})
    void readMovingExceptionTest1(String line) {
        assertSimpleTest(() -> {
            command(line);
            assertThatThrownBy(inputView::readMoving).isInstanceOf(IllegalArgumentException.class);
        });
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}