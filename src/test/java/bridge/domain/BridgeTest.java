package bridge.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeTest {

    @Test
    void 사용자가_생각하는_다리_요소_추가_함수_테스트(){
        Bridge bridge = new Bridge(newArrayList("U", "D", "D", "U"));
        String newOne = "U";
        bridge.setBridge(newOne);
        assertThat(bridge.getBridge()).containsExactly("U", "D", "D", "U", "U");
    }

    @Test
    void 다리_사이즈_얻기_테스트(){
        Bridge bridge = new Bridge(newArrayList("U", "D", "D"));
        int size = bridge.getBridgeSize();
        assertThat(size).isEqualTo(3);
    }

    @Test
    void 다리_리셋_테스트(){
        Bridge bridge = new Bridge(newArrayList("U", "D", "D"));
        bridge.clearAll();
        assertThat(bridge.getBridgeSize()).isEqualTo(0);
    }

    @Test
    void 다리_부분_원소_반환_테스트(){
        Bridge bridge = new Bridge(newArrayList("U", "U", "D", "D", "U", "U", "D", "D"));
        String comp1 = bridge.getBridgeComponent(2);
        String comp2 = bridge.getBridgeComponent(5);
        assertThat(comp1).isEqualTo("D");
        assertThat(comp2).isEqualTo("U");
    }
}