package bridge;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;

public class BridgeMakerTest {

    @DisplayName("랜덤 값 1일때 위 0일때 아래 칸 다리로 생성되는 테스트")
    @Test
    void makeBridgeTest() {
        MockedStatic<Randoms> randomsMockedStatic = Mockito.mockStatic(Randoms.class);
        Mockito.when(Randoms.pickNumberInRange(0, 1)).thenReturn(1, 0, 1, 0, 1, 0, 1, 0, 1, 0);

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(10);

        randomsMockedStatic.close();

        Assertions.assertThat(bridge).containsExactly("U", "D", "U", "D", "U", "D", "U", "D", "U", "D");
    }
}
