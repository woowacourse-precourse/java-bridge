package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BridgeMovingTest {

    @DisplayName("이동할 칸 문자가 U,D 이 아닌 경우 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"A","123","awda","u"})
    void 이동_문자_형식_테스트(String moving){
        assertThatThrownBy(() ->  BridgeMoving.createBridgeMoving(moving))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
