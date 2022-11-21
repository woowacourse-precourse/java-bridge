package bridge;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;

public class BridgeMakerTest {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @DisplayName("다리에 무작위로 들어간 0과 1이 정확히 들어갔는지 검사")
    @Test
    void putNumberTest(){
        List<Integer> testNumber = new ArrayList<>();
        System.out.println(bridgeMaker.putNumber(testNumber,3));
        //assertThat(bridgeMaker.putNumber(testNumber,3).contains(List.of(0,1)));
    }

    @DisplayName("다리에 U와 D값이 정확히 들어가는지 검사")
    @Test
    void putTextTest(){
        assertThat(bridgeMaker.putText(List.of(0,1,1))).contains("U","D","D");
    }
}
