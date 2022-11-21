package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    @ParameterizedTest
    @CsvSource(value = {"U,U,U:[ O ],[ O |   ],[ O |   | O ]:[   ],[   | X ],[   | X |   ]"}, delimiter = ':')
    void move(String playerInput,String expectedUp, String expectedDown) {
        List<String> answerBridge = List.of("U", "D", "U");
        String[] playerInputSplit = playerInput.split(",");
        String[] expectedUpSplit = expectedUp.split(",");
        String[] expectedDownSplit = expectedDown.split(",");
        BridgeGame bridgeGame = new BridgeGame(answerBridge, 0);
        for (int i = 0; i < playerInputSplit.length; i++) {
            String result = bridgeGame.move(playerInputSplit[i]);
            assertThat(result).isEqualTo(expectedUpSplit[i] + "\n" + expectedDownSplit[i]);
        }
    }
}
