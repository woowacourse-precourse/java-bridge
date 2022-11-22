package bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {
    @Test
    void 다리를_생성한다() {
        assertDoesNotThrow(() -> new Bridge(newArrayList("U", "D", "D", "U")));
    }

    @ValueSource(ints = {2, 21})
    @ParameterizedTest
    void 다리_길이가_3이상_20이하가_아니면_예외가_발생한다(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        assertThatThrownBy(() -> new Bridge(bridgeMaker.makeBridge(size)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리를_방문한다() {
        Bridge bridge = new Bridge(newArrayList("U", "D", "D", "U"));

        bridge.visit(BlockPosition.U);

        assertThat(bridge.inProgress()).isTrue();
    }

    @Test
    void 한_번_실패하면_다시_다리를_방문할_수_없다() {
        Bridge bridge = new Bridge(newArrayList("U", "D", "D", "U"));
        bridge.visit(BlockPosition.D);

        assertThatThrownBy(() -> bridge.visit(BlockPosition.U))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 다리를_초기화한다() {
        Bridge bridge = new Bridge(newArrayList("U", "D", "D"));
        bridge.visit(BlockPosition.U);
        bridge.visit(BlockPosition.D);
        bridge.visit(BlockPosition.D);

        bridge.reset();

        assertThat(bridge.isArrived()).isFalse();
    }

    @Test
    void 다리를_건너기_성공여부를_반환한다_true() {
        Bridge bridge = new Bridge(newArrayList("U", "D", "D"));
        bridge.visit(BlockPosition.U);
        bridge.visit(BlockPosition.D);
        bridge.visit(BlockPosition.D);

        assertThat(bridge.isArrived()).isTrue();
    }

    @Test
    void 다리를_건너기_성공여부를_반환한다_false() {
        Bridge bridge = new Bridge(newArrayList("U", "D", "D"));
        bridge.visit(BlockPosition.D);

        assertThat(bridge.isArrived()).isFalse();
    }

    @Test
    void 다리를_건너기가_진행중이면_성공여부는_false다() {
        Bridge bridge = new Bridge(newArrayList("U", "D", "D", "U"));
        bridge.visit(BlockPosition.U);

        assertThat(bridge.isArrived()).isFalse();
    }

    @Test
    void 다리를_건너기_진행여부를_반환한다_true() {
        Bridge bridge = new Bridge(newArrayList("U", "D", "D", "U"));
        bridge.visit(BlockPosition.U);

        assertThat(bridge.inProgress()).isTrue();
    }

    @Test
    void 다리를_건너기_진행여부를_반환한다_false() {
        Bridge bridge = new Bridge(newArrayList("U", "D", "D", "U"));
        bridge.visit(BlockPosition.D);

        assertThat(bridge.inProgress()).isFalse();
    }

    @Test
    void 도착했으면_다리를_건너기_진행여부는_false다() {
        Bridge bridge = new Bridge(newArrayList("U", "D", "D"));
        bridge.visit(BlockPosition.U);
        bridge.visit(BlockPosition.D);
        bridge.visit(BlockPosition.D);

        assertThat(bridge.inProgress()).isFalse();
    }

    @Test
    void 지나간_블럭_목록을_반환한다() {
        Bridge bridge = new Bridge(newArrayList("U", "D", "D", "U"));
        bridge.visit(BlockPosition.U);
        bridge.visit(BlockPosition.D);

        assertThat(bridge.blocks()).hasSize(2);
    }

    @Test
    void 다리_건너기에_실패한_경우_실패한_블럭까지만_반환한다() {
        Bridge bridge = new Bridge(newArrayList("U", "D", "D", "U"));
        bridge.visit(BlockPosition.U);
        bridge.visit(BlockPosition.D);
        bridge.visit(BlockPosition.U);

        assertThat(bridge.blocks()).hasSize(3);
    }
}
