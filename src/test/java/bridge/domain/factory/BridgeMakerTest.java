package bridge.domain.factory;

import bridge.domain.strategy.BridgeNumberGeneratorTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BridgeMakerTest {
    public static final BridgeMaker UPPER_BRIDGE_MAKER = new BridgeMaker(BridgeNumberGeneratorTest.BRIDGE_NUMBER_GENERATOR_ONE);
    public static final BridgeMaker LOWER_BRIDGE_MAKER = new BridgeMaker(BridgeNumberGeneratorTest.BRIDGE_NUMBER_GENERATOR_ZERO);
    
    @Test
    @DisplayName("사다리 생성")
    void createBridge() {
        assertAll(
                () -> assertThat(UPPER_BRIDGE_MAKER.makeBridge(3)).isEqualTo(List.of("U", "U", "U")),
                () -> assertThat(LOWER_BRIDGE_MAKER.makeBridge(3)).isEqualTo(List.of("D", "D", "D"))
        );
    }
}