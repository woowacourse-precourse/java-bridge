package bridge.domain.gameManagement;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

class BridgeGameTest {
    BridgeGame bridgeGame = new BridgeGame();

    @Test
    void 게임_재시작_처리한다() {
        String gameRestartOrQuitCommand = "R";
        int currentLocation = 3;
        List<String> currentBridge = new ArrayList<>();
        currentBridge.add("O ");
        currentBridge.add("O ");
        currentBridge.add(" X");

        int result = bridgeGame.retry(gameRestartOrQuitCommand, currentLocation, currentBridge);

        int expected = 2;

        assertThat(result).isEqualTo(expected);
    }

    @ValueSource(strings = {"3", "4", "10", "15", "19", "20"})
    @ParameterizedTest
    void 다리_초기_세팅한다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<String> bridge = bridgeGame.constructBridge();

        int expected = Integer.parseInt(input);
        int result = bridge.size();
        assertThat(result).isEqualTo(expected);
    }
}