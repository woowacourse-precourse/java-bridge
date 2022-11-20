package bridge.domain.bridge;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.BridgeMaker;
import bridge.TestNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {
    
    Bridge bridge;
    
    @BeforeEach
    void setUp() {
        List<Integer> generateNumbers = newArrayList(0, 1, 0, 1, 0);
        bridge = new Bridge(
                new BridgeMaker(new TestNumberGenerator(generateNumbers)).makeBridge(generateNumbers.size()));
    }
    
    @DisplayName("BridgeMaker의 인수로 설정된 size와 bridge size는 같아야 한다.")
    @Test
    void sizeByFiveSize() {
        assertThat(bridge.size()).isEqualTo(5);
    }
    
    @DisplayName("선택한 move와 bridge 리스트 해당 index(position)의 원소가 같으면 true를 반환한다.")
    @Test
    void canMoveToPositionByTrue() {
        assertThat(bridge.canMoveToPosition(BridgeMove.DOWN, 0)).isEqualTo(true);
        assertThat(bridge.canMoveToPosition(BridgeMove.UP, 1)).isEqualTo(true);
        assertThat(bridge.canMoveToPosition(BridgeMove.DOWN, 2)).isEqualTo(true);
        assertThat(bridge.canMoveToPosition(BridgeMove.UP, 3)).isEqualTo(true);
        assertThat(bridge.canMoveToPosition(BridgeMove.DOWN, 4)).isEqualTo(true);
    }
    
    @DisplayName("선택한 move와 bridge 리스트 해당 index(position)의 원소가 다르면 false를 반환한다.")
    @Test
    void canMoveToPositionByFalse() {
        assertThat(bridge.canMoveToPosition(BridgeMove.UP, 0)).isEqualTo(false);
        assertThat(bridge.canMoveToPosition(BridgeMove.DOWN, 1)).isEqualTo(false);
        assertThat(bridge.canMoveToPosition(BridgeMove.UP, 2)).isEqualTo(false);
        assertThat(bridge.canMoveToPosition(BridgeMove.DOWN, 3)).isEqualTo(false);
        assertThat(bridge.canMoveToPosition(BridgeMove.UP, 4)).isEqualTo(false);
    }
    
    @DisplayName("다리 길이보다 큰 position으로 실행할 경우 IllegalArgumentException 예외를 발생시킨다.")
    @Test
    void canMoveToPositionByOverIndex() {
        assertThatThrownBy(() -> bridge.canMoveToPosition(BridgeMove.UP, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
