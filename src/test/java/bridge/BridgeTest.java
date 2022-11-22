package bridge;

import bridge.util.BridgeSizeValidator;
import bridge.util.CommandValidator;
import bridge.util.Judge;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeTest {

    @DisplayName("범위 벗어나는 숫자 입력시 예외 발생")
    @Test
    void createBridgeByOverRange() {
        InputStream in = new ByteArrayInputStream("50".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> new BridgeSizeValidator().run(Console.readLine()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 값 입력시 예외 발생")
    @Test
    void createBridgeByWrongInput() {
        InputStream in = new ByteArrayInputStream("10J".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> new BridgeSizeValidator().run(Console.readLine()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("길이 만큼 다리 생성")
    @Test
    void createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThat(bridgeMaker.makeBridge(3).size())
                .isEqualTo(3);
    }

    @DisplayName("사용자 명령 잘못된 값일 경우 예외 발생")
    @Test
    void moveCommandByWrongInput() {
        CommandValidator commandValidator = new CommandValidator();
        assertThatThrownBy(() -> commandValidator.validate("W"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> commandValidator.retryValidate("W"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정답이면 O, 오답이면 X 반환")
    @Test
    void moveCommandCorrectTest() {
        Judge judge = new Judge();

        assertThat(judge.isCorrect("U", "U")).contains("O");
        assertThat(judge.isCorrect("U", "D")).contains("X");
    }
}
