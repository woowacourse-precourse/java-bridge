package bridge.bridgeGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.bridgeRouter.exception.NotFoundBridgeException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameLogTest {
    @ParameterizedTest
    @CsvSource(value = {"true,U,1", "false,U,2"})
    public void addLogTest(boolean isMove, String command, int countResult) {
        BridgeGameLog log = new BridgeGameLog();
        log.addLog(isMove, command);
        assertThat(log.getCount()).isEqualTo(countResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"true,u", "false,d"})
    public void addLogErrorTest(boolean isMove, String command) {
        BridgeGameLog log = new BridgeGameLog();
        assertThatThrownBy(() -> log.addLog(isMove, command)).isInstanceOf(NotFoundBridgeException.class);
    }
}