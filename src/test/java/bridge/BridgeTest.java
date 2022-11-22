package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

    private Bridge bridge;

    @BeforeEach
    void setUp() {
        bridge = new Bridge(new ArrayList<>(), new ArrayList<>());
    }

    @Test
    void 위_다리가_있을_때_위_다리로_이동하면_O가_추가된다() {
        bridge.moveUpperBridge();
        assertThat(bridge.toString()).isEqualTo("[ O ]" + "\n" + "[   ]");
    }

    @Test
    void 아래_다리가_있을_때_아래_다리로_이동하면_O가_추가된다() {
        bridge.moveLowerBridge();
        assertThat(bridge.toString()).isEqualTo("[   ]" + "\n" + "[ O ]");
    }

    @Test
    void 위_다리가_없을_때_위_다리로_이동하면_X가_추가된다() {
        bridge.cannotMoveUpperBridge();
        assertThat(bridge.toString()).isEqualTo("[ X ]" + "\n" + "[   ]");
    }

    @Test
    void 아래_다리가_없을_때_아래_다리로_이동하면_X가_추가된다() {
        bridge.cannotMoveLowerBridge();
        assertThat(bridge.toString()).isEqualTo("[   ]" + "\n" + "[ X ]");
    }
}