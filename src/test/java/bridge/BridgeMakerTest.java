package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    @Test
    void makeBridge() {
        /*given*/
        List<String> makeBridgeTest = List.of("U", "D");
        /*when*/
        List<String> makeBridgeActual = bridgeMaker.makeBridge(3);
        /*then*/
        for (int i = 0; i < makeBridgeActual.size(); i++) {
            assertThat(makeBridgeActual.get(i)).isIn(makeBridgeTest);
        }
    }
}