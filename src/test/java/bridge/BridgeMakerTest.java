package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;


class BridgeMakerTest {
    @DisplayName("1(U)또는 0(D)이 아닌 값을 갖는 경우")
    @Test
    void createBridgeByWrongValue_1(){
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 2, 3));
        assertThatThrownBy(() -> new BridgeMaker(numberGenerator).makeBridge(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createBridgeByWrongValue_2(){
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, -1));
        assertThatThrownBy(() -> new BridgeMaker(numberGenerator).makeBridge(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 경우")
    @Test
    void 정상적인_다리생성(){
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge).containsExactly("U", "D", "U", "D", "D");
    }

}