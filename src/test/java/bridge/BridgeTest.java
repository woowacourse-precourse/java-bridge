package bridge;

import bridge.util.BridgeSizeValidator;
import bridge.util.MoveCommandValidator;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class BridgeTest {

    @DisplayName("범위 벗어나는 숫자 입력시 예외 발생")
    @Test
    void createBridgeByOverRange(){
        InputStream in = new ByteArrayInputStream("50".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> new BridgeSizeValidator().run(Console.readLine()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 값 입력시 예외 발생")
    @Test
    void createBridgeByWrongInput(){
        InputStream in = new ByteArrayInputStream("10J".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> new BridgeSizeValidator().run(Console.readLine()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("길이 만큼 다리 생성")
    @Test
    void createBridge(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThat(bridgeMaker.makeBridge(3).size())
                .isEqualTo(3);
    }

    @DisplayName("사용자 명령 잘못된 값일 경우 예외 발생")
    @Test
    void moveCommandByWrongInput(){
        MoveCommandValidator moveCommandValidator = new MoveCommandValidator();
        assertThatThrownBy(() -> moveCommandValidator.validate("R"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
