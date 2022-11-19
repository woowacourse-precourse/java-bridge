package bridge.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.exception.InputException.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {

    @DisplayName("이동할 칸 선택시 U, D가 아닌 다른 문자를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "u", "d"})
    void readMoving(String direction) {
        assertThatThrownBy(() -> isValidMovementDirection(direction))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 수 있는 칸인지 판단할 수 있다.")
    @ParameterizedTest
    @CsvSource({"0,U", "1,U", "2,D"})
    void judgeMovementDirection(int index, String direction) {
        Bridge bridge = new Bridge(List.of("U", "U", "D"));
        assertThat(bridge.isPossibleMove(index, direction)).isTrue();
    }

    @DisplayName("재시작 및 종료에 대한 입력이 R 또는 Q가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "1", "RR"})
    void readGameCommand(String command) {
        assertThatThrownBy(() -> isValidRestartOrQuitCommand(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작할 경우 처음에 만든 다리를 재사용한다.")
    @Test
    void reuseBridge() {
        Bridge originBridge = new Bridge(List.of("U", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(originBridge);

        bridgeGame.retry(originBridge);
        Bridge retryBridge = bridgeGame.getBridge();

        assertThat(originBridge.getBridge()).isEqualTo(retryBridge.getBridge());
    }
}
