package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class BridgeGameTest {
    static BridgeGame bridgeGame;

    @BeforeAll
    public static void setup() {
        bridgeGame = new BridgeGame();
    }
    
    @DisplayName("모든 이동이 성공했는지 확인하는 메서드 테스트")
    @Test
    void move() {
        String command1 = "U";
        String command2 = "U";
        String command3 = "U";

        Bridge bridge = new Bridge(Arrays.asList("U", "D", "U"));
        assertThat(bridgeGame.move(bridge, command1)).isEqualTo(true);
        assertThat(bridgeGame.move(bridge, command2)).isEqualTo(false);
        assertThat(bridgeGame.move(bridge, command3)).isEqualTo(true);
    }


//
//    @DisplayName("움직이는 명령어가 'U', 'D'가 아닌 경우 예외가 발생한다.")
//    @CsvSource({"k", "&&", "f4j"})
//    @ParameterizedTest
//    void incorrectBridgeCommand(String command) {
//        BridgeGame bridgeGame = new BridgeGame();
//
//        int nextIndex = 2;
//        List<String> bridge = Arrays.asList("U", "D", "U");
//        assertThatThrownBy(() -> bridgeGame.move(command, bridge.get(nextIndex)))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("재시작 여부 확인하는 메서드 테스트")
//    @Test
//    void retry() {
//        BridgeGame bridgeGame = new BridgeGame();
//
//        String command = "R";
//        assertThat(bridgeGame.retry(command)).isEqualTo(true);
//    }
//
//    @DisplayName("움직이는 명령어가 'U', 'D'가 아닌 경우 예외가 발생한다.")
//    @CsvSource({"k", "&&", "f4j"})
//    @ParameterizedTest
//    void incorrectRetryCommand(String command) {
//        BridgeGame bridgeGame = new BridgeGame();
//
//        assertThatThrownBy(() -> bridgeGame.retry(command))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
}
