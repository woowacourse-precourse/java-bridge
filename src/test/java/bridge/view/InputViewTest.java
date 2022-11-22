package bridge.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    InputView inputView = new InputView();

    @DisplayName("다리 길이 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"String", "1", "100"})
    void validateSize(String msg) {
        Assertions.assertThatThrownBy(() -> inputView.validateSize(msg))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 움직일 때 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"String", "Y", "1"})
    void validateMove(String msg) {
        Assertions.assertThatThrownBy(() -> inputView.validateMove(msg))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"String", "2", "Y"})
    void validateCommand(String msg) {
        Assertions.assertThatThrownBy(() -> inputView.validateCommand(msg))
                .isInstanceOf(IllegalArgumentException.class);
    }
}