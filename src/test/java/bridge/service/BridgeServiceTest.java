package bridge.service;

import bridge.exception.BridgeException;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeServiceTest {
    @Test
    void 다리길이_입력검증(){
        String good = "6";
        String notNumeric = "a";
        String notLengthRange = "30";

        assertThat(6).isEqualTo(BridgeService.validateBridgeLength(good));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> BridgeService.validateBridgeLength(notNumeric));
        assertThat(exception.getMessage()).isEqualTo(BridgeException.NOT_NUMERIC.getErrorMessage());

        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, ()-> BridgeService.validateBridgeLength(notLengthRange));
        assertThat(exception1.getMessage()).isEqualTo(BridgeException.INVALID_LENGTH_RANGE.getErrorMessage());
    }

    @Test
    void 이동칸_입력검증(){
        String good = "D";
        String invalidMove = "a";

        assertThat("D").isEqualTo(BridgeService.validateMove(good));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> BridgeService.validateMove(invalidMove));
        assertThat(exception.getMessage()).isEqualTo(BridgeException.INVALID_MOVE.getErrorMessage());
    }

    @Test
    void 재시작_입력검증(){
        String good = "Q";
        String invalidRestartStatus = "a";

        assertThat("Q").isEqualTo(BridgeService.validateRestartStatus(good));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> BridgeService.validateRestartStatus(invalidRestartStatus));
        assertThat(exception.getMessage()).isEqualTo(BridgeException.INVALID_RESTART_STATUS.getErrorMessage());
    }
}