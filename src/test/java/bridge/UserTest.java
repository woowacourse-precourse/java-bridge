package bridge;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

class UserTest {
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    BridgeGame test = new BridgeGame(bridgeMaker.makeBridge(4));

    @DisplayName("BridgeGame 인스턴스 내의 method 들이 정상 작동하는지 확인")
    @Test
    void moveTest(){
        assertThat(test.getBridge().size()).isEqualTo(4);
        assertThat(test.move(test.getBridge().get(0))).isEqualTo(true);
        assertThat(test.retry("R")).isEqualTo(true);
    }

    @DisplayName("Movement 가 정상적으로 실행되는지 확인")
    @Test
    void movementTest(){
        Controller controller = new Controller();
        String input = test.getBridge().get(0);
        byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        assertThat(controller.movement(test)).isEqualTo(List.of(false, true));
    }

    @DisplayName("validCastingBridgeSize 가 잘 동작하는지 확인")
    @Test
    void validCastingBridgeSizeTest(){
        assertThat(Function.validCastingBridgeSize("a")).isEqualTo(false);
    }
    @DisplayName("validBridgeSize 가 잘 동작하는지 확인")
    @Test
    void validBridgeSizeTest(){
        assertThat(Function.validBridgeSize(1)).isEqualTo(false);
        assertThat(Function.validBridgeSize(21)).isEqualTo(false);
    }

    @DisplayName("validMoving 이 잘 동작하는지 확인")
    @Test
    void validMovingTest(){
        assertThat(Function.validMoving("UUU")).isEqualTo(false);
    }

    @DisplayName("validGameCommand 가 잘 동작하는지 확인")
    @Test
    void validGameCommandTest(){
        assertThat(Function.validGameCommand("RRR")).isEqualTo(false);
    }
}
