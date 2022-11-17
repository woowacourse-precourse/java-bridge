package bridge.constantTest;

import bridge.constant.BridgeState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeStateTest {

    @ParameterizedTest
    @DisplayName("숫자로 생성된 다리가 0과 1이 아닌 경우 NoSuchElementException 에러를 출력한다.")
    @ValueSource(ints = {2, 3, 10, -1})
    public void checkWrongBridgeState(int bridgeState){
        assertThatThrownBy(()->BridgeState.validateBridgeState(bridgeState)).isInstanceOf(NoSuchElementException.class);
    }
    
    @ParameterizedTest
    @DisplayName("0과 1이 D와 U로 잘 변환되는지 확인한다.")
    @CsvSource(value = {"0: D", "1: U"},delimiter = ':')
    public void checkProperBridgeState(int bridgeStateNumber, String bridgeState){
        assertThat(BridgeState.transform(bridgeStateNumber)).isEqualTo(bridgeState);
    }
}
