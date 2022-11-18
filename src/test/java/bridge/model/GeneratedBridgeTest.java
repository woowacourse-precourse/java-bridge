package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GeneratedBridgeTest {

    GeneratedBridge generatedBridge;

    @BeforeEach
    void setGeneratedBridge() {
        List<String> bridgeShape = List.of("U", "D", "U");
        generatedBridge = new GeneratedBridge(bridgeShape);
    }

    @Test
    void 다음_칸으로_이동_가능_여부_판단_가능() {
        boolean canMove = generatedBridge.canMoveNextStep(0, "U");

        assertThat(canMove).isTrue();
    }

    @Test
    void 다음_칸으로_이동_가능_여부_판단_불가능() {
        boolean canMove = generatedBridge.canMoveNextStep(1, "U");

        assertThat(canMove).isFalse();
    }
}