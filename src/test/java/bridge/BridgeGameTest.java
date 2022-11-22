package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.Model.BridgeGame;
import bridge.Model.BridgeMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BridgeGameTest {

    private BridgeGame bridgeGame;
    private BridgeMap bridgeMap;

    @BeforeEach
    void init() {
        bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        bridgeMap = new BridgeMap();
    }

    @ParameterizedTest
    @CsvSource(value = {"U:0", "D:1", "D:2"}, delimiter = ':')
    void 다리_이동_테스트(String input, int num) {
        assertThat(bridgeGame.move(input, bridgeMap, num)).isTrue();
    }
}
