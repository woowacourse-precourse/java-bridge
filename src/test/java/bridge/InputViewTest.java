package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void beforeEach() {
        inputView = new InputView();
    }

    @ParameterizedTest
    @DisplayName("입력 받는 다리 길이 유효성 테스트")
    @CsvSource(value = {"123, fail", "30, fail", "24, fail", "10, success", "21, fail", "2, fail", "15, success",
                            "ㅁㄴ, fail", "as, fail", "@#!#$, fail", " \\t, fail",
                                ",null"})
    void checkBridgeSizeValidationTest(String bridgeSize, String expectedValidationResult) {

        if (expectedValidationResult.equals("success")) {
            assertThatCode(() -> inputView.checkBridgeSizeValidation(bridgeSize));
        } else if (expectedValidationResult.equals("fail")){
            assertThatThrownBy(() -> inputView.checkBridgeSizeValidation(bridgeSize))
                    .isInstanceOf(IllegalArgumentException.class);
        } else if (expectedValidationResult.equals("null")) {
            assertThatThrownBy(() -> inputView.checkBridgeSizeValidation(bridgeSize))
                    .isInstanceOf(NullPointerException.class);
        }
    }
}