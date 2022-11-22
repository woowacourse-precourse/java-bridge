package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BridgeTest {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMaker bridgeMaker = new BridgeMaker();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeNumberGenerator();


    @DisplayName("입력받은 다리 길이만큼 다리 생성했는지 확인 ")
    @Test
    public void makeBridgeTest() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
       assertEquals(bridgeMaker.makeBridge(3).size(), 3);
    }

    @DisplayName("허용된 범위 안에서 입력했는지 확인")
    @Test
    public void IsInRange(){
        int overNum = 30;
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            inputView.checkRange(overNum);
        });
    }


}
