package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class InputViewTest{

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

    @Test
    void readBridgeSizeTest2() {
        assertSimpleTest(() -> {
            command("2");
            assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void readBridgeSizeTest3() {
        assertSimpleTest(() -> {
            command("21");
            assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void readBridgeSizeTest4() {
        assertSimpleTest(() -> {
            command("2a");
            assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void readBridgeSizeTest5() {
        assertSimpleTest(() -> {
            command("");
            assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(IllegalArgumentException.class);
        });
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}