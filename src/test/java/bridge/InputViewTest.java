package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"20a", " ", "a"})
    @DisplayName("다리 길이를 숫자로 입력받지 않으면 예외가 발생한다.")
    void readBridgeSize_문자_입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputView inputView = new InputView();
        assertThatIllegalArgumentException()
                .isThrownBy(inputView::readBridgeSize);
    }

    @ParameterizedTest
    @ValueSource(strings = {"21", "2"})
    @DisplayName("다리 길이가 3 이상 20 이하가 아니라면 예외가 발생한다.")
    void readBridgeSize_숫자_범위_오류(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputView inputView = new InputView();
        assertThatIllegalArgumentException()
                .isThrownBy(inputView::readBridgeSize);
    }

    @Test
    void readMoving() {

    }

    @Test
    void readGameCommand() {
    }
}