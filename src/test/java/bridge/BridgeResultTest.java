package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeResultTest {
    @Test
    public void saveCorrectStep_한번_뒤에_각Layer_결과_확인() throws Exception {
        //given
        BridgeResult bridgeResult = new BridgeResult();

        //when
        bridgeResult.saveCorrectStep("U");

        //then
        assertThat(bridgeResult.getResult(0)).isEqualTo("O ");
    }

    @Test
    public void saveCorrectStep_두번_뒤에_각Layer_결과_확인() throws Exception {
        //given
        BridgeResult bridgeResult = new BridgeResult();

        //when
        bridgeResult.saveCorrectStep("U");
        bridgeResult.saveCorrectStep("D");

        //then
        assertThat(bridgeResult.getResult(0)).isEqualTo("O ");
        assertThat(bridgeResult.getResult(1)).isEqualTo(" O");
    }

    @Test
    public void saveWrongStep_뒤에_각Layer_결과_확인() throws Exception {
        //given
        BridgeResult bridgeResult = new BridgeResult();

        //when
        bridgeResult.saveWrongStep("U");

        //then
        assertThat(bridgeResult.getResult(0)).isEqualTo("X ");
    }

    @Test
    public void saveCorrectStep후_saveWrongStep_각Layer_결과_확인() throws Exception {
        //given
        BridgeResult bridgeResult = new BridgeResult();

        //when
        bridgeResult.saveCorrectStep("U");
        bridgeResult.saveWrongStep("D");

        //then
        assertThat(bridgeResult.getResult(0)).isEqualTo("O ");
        assertThat(bridgeResult.getResult(1)).isEqualTo(" X");
    }
}