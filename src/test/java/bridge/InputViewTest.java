package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"3", "20"})
    @DisplayName("다리 길이가 3 이상 20 이하 숫자라면 숫자를 리턴한다.")
    void readBridgeSize_정상_입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputView inputView = new InputView();
        assertThat(inputView.readBridgeSize())
                .isEqualTo(Integer.parseInt(input));
    }
    @ParameterizedTest
    @ValueSource(strings = {"20a", " ", "a"})
    @DisplayName("다리 길이를 숫자로 입력받지 않으면 예외가 발생한다.")
    void readBridgeSize_예외_문자_입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputView inputView = new InputView();
        assertThatIllegalArgumentException()
                .isThrownBy(inputView::readBridgeSize);
    }

    @ParameterizedTest
    @ValueSource(strings = {"21", "2"})
    @DisplayName("다리 길이가 3 이상 20 이하가 아니라면 예외가 발생한다.")
    void readBridgeSize_예외_숫자_범위(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputView inputView = new InputView();
        assertThatIllegalArgumentException()
                .isThrownBy(inputView::readBridgeSize);
    }

    @ParameterizedTest
    @ValueSource(strings = {})
    void readMoving() {
    }

    @ParameterizedTest
    @ValueSource(strings = {})
    void readGameCommand() {
    }
}