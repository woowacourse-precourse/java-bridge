package bridge;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;

public class BridgeMakerTest {
    /*@DisplayName("다리에 숫자 0,1을 사용자가 입력한 길이 만큼 무작위로 들어갔는지 검사")
    @Test
    void putNumberTest(){
        int size = 3;
        List<Integer> bridgeNumber = new ArrayList<>(size);
        BridgeNumberGenerator bridgeNumberGenerator = null;
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        assertThat(bridgeMaker.)
    }*/

    @DisplayName("다리에 U와 D값이 정확히 들어갔는지 검사")
    @Test
    void putTextTest(){
        assertThat(BridgeMaker.putText(0)).contains("U");
    }
}
