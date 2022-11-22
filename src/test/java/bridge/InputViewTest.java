package bridge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    @ValueSource(strings = {"3", "10", "20"})
    @ParameterizedTest
    void 다리_길이를_입력받는다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThat(new InputView().readBridgeSize())
                .isEqualTo(Integer.parseInt(input));
    }

    @ValueSource(strings = {"-1\n3", "0\n2\n3", "21\n3"})
    @ParameterizedTest
    void 다리_길이가_3이상_20이하가_아니면_다시_입력받는다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThat(new InputView().readBridgeSize())
                .isEqualTo(3);
    }

    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void 이동할_칸을_입력한다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThat(new InputView().readMoving())
                .isEqualTo(input);
    }

    @ValueSource(strings = {"1\n2\nU", "a\nU", "!@#\nU", "가나다\nU"})
    @ParameterizedTest
    void 이동할_칸이_U또는_D가_아니면_다시_입력받는다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThat(new InputView().readMoving())
                .isEqualTo("U");
    }

    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void 게임_커맨드를_입력한다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThat(new InputView().readGameCommand())
                .isEqualTo(input);
    }

    @ValueSource(strings = {"1\nU\nR", "a\nR", "!@#\nR", "가나다\nR"})
    @ParameterizedTest
    void 커맨드가_R또는_Q가_아니면_다시_입력받는다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThat(new InputView().readGameCommand())
                .isEqualTo("R");
    }
}
