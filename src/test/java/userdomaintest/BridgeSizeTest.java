package userdomaintest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import userdomain.operator.UserException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeSizeTest {

    @DisplayName("다리 길이 입력 크기의 예외처리 기능을 테스트한다")
    @ValueSource(strings = {"1", "2","21","50"})
    @ParameterizedTest
    void 다리_길이_크기_예외처리_테스트(String bridgeSize){
        assertThatThrownBy(() -> new UserException().checkBridgeSizeInput(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력 범위의 예외처리 기능을 테스트한다")
    @ValueSource(strings = {"01"," 1","ㄱ","q"})
    @ParameterizedTest
    void 다리_길이_범위_예외처리_테스트(String bridgeSize){
        assertThatThrownBy(() -> new UserException().checkBridgeSizeRange(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력 기능을 테스트한다")
    @ValueSource(strings = {"3", "5","6","10","16","20"})
    @ParameterizedTest
    void 다리_길이_입력_테스트(String bridgeSize){
        assertThat(new UserException().checkBridgeSize(bridgeSize))
                .isEqualTo(false);
    }

}
