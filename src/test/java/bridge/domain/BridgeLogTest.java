package bridge.domain;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeLogTest {
    private BridgeLog bridgeLog;
    @BeforeEach
    void setUP() {
        bridgeLog = new BridgeLog();
    }

    @AfterEach
    void output() {
        System.out.println(bridgeLog.getMap());
    }

    @Test
    void matchingSuccess() {
        List<String> ansertLog = List.of("U", "D", "D");
        List<String> userCrossLog = List.of("U", "D", "D");

        List<List<String>> answer = List.of(List.of("O", " ", " "), List.of(" ", "O", "O"));

        for (int index = 0; index < ansertLog.size(); index++) {
            bridgeLog.addLog(ansertLog.get(index), userCrossLog.get(index));
        }
        assertThat(answer).isEqualTo(bridgeLog.getMap());
    }

    @Test
    void matchingFail() {
        List<String> ansertLog = List.of("U", "D", "D");
        List<String> userCrossLog = List.of("U", "D", "U");

        List<List<String>> answer = List.of(List.of("O", " ", "X"), List.of(" ", "O", " "));

        for (int index = 0; index < ansertLog.size(); index++) {
            bridgeLog.addLog(ansertLog.get(index), userCrossLog.get(index));
        }
        assertThat(answer).isEqualTo(bridgeLog.getMap());
    }
}