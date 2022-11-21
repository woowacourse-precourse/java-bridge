package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeResultTest {
    @Test
    public void saveCorrectStep_한번_뒤에_각Layer_결과_확인() throws Exception {
        //given
        BridgeResult bridgeResult = new BridgeResult();

        //when
        bridgeResult.saveCorrectStep("U");

        //then
        assertThat(bridgeResult.getUpperResult()).isEqualTo(List.of("O"));
        assertThat(bridgeResult.getLowerResult()).isEqualTo(List.of(" "));
    }

    @Test
    public void saveCorrectStep_두번_뒤에_각Layer_결과_확인() throws Exception {
        //given
        BridgeResult bridgeResult = new BridgeResult();

        //when
        bridgeResult.saveCorrectStep("U");
        bridgeResult.saveCorrectStep("D");

        //then
        assertThat(bridgeResult.getUpperResult()).isEqualTo(List.of("O", " "));
        assertThat(bridgeResult.getLowerResult()).isEqualTo(List.of(" ", "O"));
    }

    @Test
    public void saveWrongStep_뒤에_각Layer_결과_확인() throws Exception {
        //given
        BridgeResult bridgeResult = new BridgeResult();

        //when
        bridgeResult.saveWrongStep("U");

        //then
        assertThat(bridgeResult.getUpperResult()).isEqualTo(List.of("X"));
        assertThat(bridgeResult.getLowerResult()).isEqualTo(List.of(" "));
    }

    @Test
    public void saveCorrectStep후_saveWrongStep_각Layer_결과_확인() throws Exception {
        //given
        BridgeResult bridgeResult = new BridgeResult();

        //when
        bridgeResult.saveCorrectStep("U");
        bridgeResult.saveWrongStep("D");

        //then
        assertThat(bridgeResult.getUpperResult()).isEqualTo(List.of("O", " "));
        assertThat(bridgeResult.getLowerResult()).isEqualTo(List.of(" ", "X"));
    }
}