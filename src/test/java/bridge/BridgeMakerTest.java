package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void initiateBridgeMakerTest() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("다리 길이로 2를 입력했을때, 예외를 던진다.")
    @Test
    void isValid() {
        assertThatThrownBy(() -> bridgeMaker.isValid(2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}