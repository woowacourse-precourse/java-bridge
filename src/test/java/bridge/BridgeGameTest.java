package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.List;



class BridgeGameTest {

    @Test
    public void makeBridgeTest() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        int bridgeSize = 20;

        //when
        List<String> bridge = bridgeGame.makeBridge(bridgeSize);

        //then
        assertThat(bridge.size()).isEqualTo(bridgeSize);
        assertThat(bridge.contains("A")).isEqualTo(false);
        assertThat(bridge.contains("U")).isEqualTo(true);
        assertThat(bridge.contains("D")).isEqualTo(true);
    }

    @Test
    void moveTest() {
        BridgeGame bridgeGame = new BridgeGame();
        /*given*/
        String moveTest = "[ O ]" +"\n"+"[   ]";
        /*when*/
        String moveActual = bridgeGame.move(List.of("U","U"),0,"U");
        /*then*/
        assertThat(moveActual).isEqualTo(moveTest);
    }
}