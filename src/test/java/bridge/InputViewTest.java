package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    InputView inputView;

    @BeforeEach
    void setInputView() {
        inputView = new InputView();
    }

    @DisplayName("입력으로 준 문자열이 숫자로 반환되는지 확인")
    @Test
    void readBridgeSizeTest() {
        Assertions.assertThat(inputView.readBridgeSize("18")).isEqualTo(18);
    }

}