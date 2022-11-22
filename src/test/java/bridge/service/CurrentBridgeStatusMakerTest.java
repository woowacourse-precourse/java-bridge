package bridge.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CurrentBridgeStatusMakerTest {

    private CurrentBridgeStatusMaker currentBridgeStatusMaker = new CurrentBridgeStatusMaker();

    @DisplayName("플레이어가 지나온 다리를 문자열로 나타낼 수 있다.")
    @Test
    public void 다리_기록_출력() {
        List<String> playerBridgeStatus = List.of("U", "D", "U");
        List<String> createdBridgeStatus = List.of("U", "D", "U");
        List<StringBuilder> currentBridgeStatus =
                currentBridgeStatusMaker.convertCurrentBridgeStatus(playerBridgeStatus, createdBridgeStatus);

        Assertions.assertThat(currentBridgeStatus.get(1).toString()).isEqualTo("[ O |   | O ]");
        Assertions.assertThat(currentBridgeStatus.get(0).toString()).isEqualTo("[   | O |   ]");
    }
}
