package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeRetryTest {

    @DisplayName("재시도 문자가 R,Q 이 아닌 경우 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"A","@#%@#","123","r","u","D","U"})
    void 이동_문자_형식_테스트(String moving){
        assertThatThrownBy(() -> BridgeRetry.createBridgeRetry(moving))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
