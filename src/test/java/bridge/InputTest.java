package bridge;

import org.junit.jupiter.api.Test;

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
                .isInstanceOf(IllegalArgumentException.class);
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
        systemIn("");
        InputView inputTest = new InputView();
        assertThatThrownBy(inputTest::readMoving)
                .isInstanceOf(IllegalArgumentException.class);
    }
}

