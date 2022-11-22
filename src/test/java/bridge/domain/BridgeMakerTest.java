package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

public class BridgeMakerTest {
    private static BridgeMaker bridgeMaker;

    @BeforeEach
    void beforeEach() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    @DisplayName("다리의 길이가 주어지면 윗칸은 U, 아랫칸은 D로 나타내어지는 다리를 생성한다.")
    @Test
    void makeBridge() {
        MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 0, 1);

        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "U");
        mock.close();
    }

    @DisplayName("NumberGenerator를 통해 0과 1 이외의 숫자가 뽑혀온다면 IllegalArgumentException 에러를 발생시킨다.")
    @Test
    void makeBridgeWithInvalidGeneratedNumber() {
        MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(2, 1, 1);
        assertThatThrownBy(() -> bridgeMaker.makeBridge(3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        "[ERROR]",
                        "방향으로 적절하지 않은 숫자가 확인되었습니다."
                );
        mock.close();
    }
}
