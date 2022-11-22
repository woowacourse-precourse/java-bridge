package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BridgeTest {


    @DisplayName("맞는 다리칸을 입력하면 true")
    @Test
    void checkStepRightValue() {
        Bridge bridge = new Bridge(Arrays.asList("U", "U", "D"));
        boolean result = bridge.checkStep(0, "U");
        Assertions.assertThat(result).isTrue();
    }

    @DisplayName("틀린 다리칸을 입력하면 false")
    @Test
    void checkStepWrongValue() {
        Bridge bridge = new Bridge(Arrays.asList("U", "U", "D"));
        boolean result = bridge.checkStep(0, "D");
        Assertions.assertThat(result).isFalse();
    }

}