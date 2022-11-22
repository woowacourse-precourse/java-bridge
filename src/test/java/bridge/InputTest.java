package bridge;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest extends IOTest {
    @Test
    void 올바른_사이즈_테스트() {
        systemIn("3");
        InputView inputTest = new InputView();
        assertThat(inputTest.readBridgeSize()).isEqualTo(3);
    }


    @Test
    void 영으로_시작하는_숫자_사이즈_테스트() {
        systemIn("04");
        InputView inputTest = new InputView();
        assertThatThrownBy(inputTest::readBridgeSize)
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void 아무것도_없는_사이즈_테스트() {
        systemIn("");
        InputView inputTest = new InputView();
        assertThatThrownBy(inputTest::readBridgeSize)
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void 음수_사이즈_테스트() {
        systemIn("-3");
        InputView inputTest = new InputView();
        assertThatThrownBy(inputTest::readBridgeSize)
                .isInstanceOf(NoSuchElementException.class);
    }


    @Test
    void 올바른_칸_입력_테스트() {
        systemIn("U");
        InputView inputTest = new InputView();
        assertThat(inputTest.readMoving()).isEqualTo("U");
        systemIn("D");
        assertThat(inputTest.readMoving()).isEqualTo("D");
    }

    @Test
    void UD_이외의_칸_입력_테스트() {
        systemIn("X");
        InputView inputTest = new InputView();
        assertThatThrownBy(inputTest::readMoving)
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void UD_이외의_칸_입력_테스트2() {
        systemIn("");
        InputView inputTest = new InputView();
        assertThatThrownBy(inputTest::readMoving)
                .isInstanceOf(NoSuchElementException.class);
    }
}

