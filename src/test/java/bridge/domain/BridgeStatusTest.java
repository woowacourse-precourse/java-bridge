package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeStatusTest {
    @DisplayName("다리 상태가 잘 저장되는지 확인")
    @Test
    void should_Save_When_addStatus() {
        BridgeStatus bridgeStatus = new BridgeStatus();
        final String UP_BLOCK = "O";
        final String DOWN_BLOCK = " ";
        bridgeStatus.addStatus(UP_BLOCK, DOWN_BLOCK);
        Assertions.assertThat(bridgeStatus.getUpBlocks()).contains("O");
        Assertions.assertThat(bridgeStatus.getDownBlocks()).contains(" ");
    }
}
