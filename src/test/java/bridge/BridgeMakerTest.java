package bridge;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



class BridgeMakerTest {

    @Test
    void 랜덤_숫자_생산_테스트_사이즈(){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

        List<String> bridgeList = new BridgeMaker(bridgeRandomNumberGenerator).makeBridge(20);

        assertAll(
                ()->assertEquals(bridgeList.size(),20),
                ()->assertThat(bridgeList).containsOnly("U","D")
        );
    }




}