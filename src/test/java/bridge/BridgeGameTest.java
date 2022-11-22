package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class BridgeGameTest {

    @DisplayName("다리 길이 입력 테스트")
    @Test
    void bridgeLengthTest(){
        assertThatThrownBy(() -> new BridgeGame(0).bridgeValidation("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("필드 입력 테스트")
    @Test
    void fieldValueTest(){
        assertThatThrownBy(() -> new BridgeGame(0).fieldValueValidation("C"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 입력 테스트")
    @Test
    void retryTest(){
        assertThatThrownBy(() -> new BridgeGame(0).retryValueValidation("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
