package bridge;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.ErrorMessage;

class BridgeMakerTest {
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    @Test
    @DisplayName("[makeBridge] 사용자의 다리 사이즈 만큼 올바르게 다리를 생성하는지 테스트")
    void makeBridgeCorrectSize() {
        //given
        int userInput=4;
        //when
        List<String> bridge = bridgeMaker.makeBridge(userInput);
        //then
        assertThat(bridge.size()).isEqualTo(userInput);
    }

    @Test
    @DisplayName("[makeBridge] 다리가 U 혹은 D만을 생성하는지 테스트")
    void makeCorrectBridge() {
        //given
        int userInput=12;
        //when
        List<String> bridge = bridgeMaker.makeBridge(userInput);
        //then
        assertThat(bridge).containsAnyOf(BridgeDirect.UP.getDirection(),BridgeDirect.DOWN.getDirection());

    }


    @DisplayName("[validateBridgeSize] 다리 길이의 입력값이 범위내 없는경우 예외발생")
    @ParameterizedTest
    @ValueSource(ints = {2, -1, 132, 21})
    void notCorrectBridgeSize(int size) {
        //given
        //when
        //then
        assertThatThrownBy(() -> BridgeMaker.validateBridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.NOT_RANGE_BRIDGE_SIZE);
    }

    @DisplayName("[validateBridgeSize] 다리 길이의 입력값이 정상 범위인경우")
    @ParameterizedTest
    @ValueSource(ints = {3, 14, 20})
    void correctBridgeSize(int size) {
        //given
        //when
        //then
        assertDoesNotThrow(() -> BridgeMaker.validateBridgeSize(size));
    }
}