package bridge.domain;

import java.util.List;

import static bridge.util.Constant.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BridgeTest {

    @Test
    void step_실행시_1걸음_이동() {
        Bridge bridge = new Bridge(0, List.of(UPLOCATION, UPLOCATION, DOWNLOCATION));
        bridge.step();
        assertThat(bridge.getBridgePosition()).isEqualTo(1);
    }

    @Test
    void 현재위치_마지막_포지션_검사() {
        Bridge bridge = new Bridge(4, List.of(UPLOCATION, UPLOCATION, DOWNLOCATION, DOWNLOCATION));
        assertThat(bridge.isLastStep()).isTrue();
    }

    @Test
    void 이동목적지_이동가능_판단(){
        Bridge bridge = new Bridge(0, List.of(UPLOCATION, UPLOCATION, DOWNLOCATION, DOWNLOCATION));
        assertThat(bridge.isSafe(UPLOCATION)).isTrue();
    }

    @Test
    void 이동목적지_이동가능시_O_추가() {
        Bridge bridge = new Bridge(0, List.of(UPLOCATION, UPLOCATION, DOWNLOCATION, DOWNLOCATION));
        bridge.addResult(UPLOCATION);
        assertThat(bridge.getUpperBridge().get(0)).isEqualTo(CORRECTSPOT);
    }

    @Test
    void 이동목적지_이동가능시_X_추가() {
        Bridge bridge = new Bridge(0, List.of(UPLOCATION, UPLOCATION, DOWNLOCATION, DOWNLOCATION));
        bridge.addResult(DOWNLOCATION);
        assertThat(bridge.getLowerBridge().get(0)).isEqualTo("X");
    }

    @Test
    void 허용되지_않은_위치_예외() {
        Bridge bridge = new Bridge(0, List.of(UPLOCATION, UPLOCATION, DOWNLOCATION, DOWNLOCATION));
        assertThatThrownBy(
            ()->bridge.addResult("X")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
