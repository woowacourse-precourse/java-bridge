package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


class BridgeStatusTest {
    private final static BridgeStatus BRIDGE_MAP = new BridgeStatus();

    @ParameterizedTest
    @DisplayName("Status Class 테스트")
    @CsvSource(
            value = {
                    "U:U:[ O ],[   ]",
                    "D:D:[ O |   ],[   | O ]",
                    "U:D:[ O |   |   ],[   | O | X ]",
                    "D:U:[ O |   |   | X ],[   | O | X |   ]"},
            delimiter = ':')
    public void test(
            String answer,
            String userAnswer,
            String output
    ) {
        BRIDGE_MAP.updateBridgeMap(answer, userAnswer);
        BRIDGE_MAP.createMessage();
        String[] tmp = output.split(",");
        assertAll(
                () -> assertTrue(BRIDGE_MAP.getMessage().contains(tmp[0])),
                () -> assertTrue(BRIDGE_MAP.getMessage().contains(tmp[1]))
        );
    }
}