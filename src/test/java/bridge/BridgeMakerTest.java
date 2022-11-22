package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.model.Direction;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    @Test
    void 사이즈만큼_다리가_생성된다() {
        int size = 5;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);

        assertThat(bridge.size()).isEqualTo(size);

        List<String> directions = Arrays.stream(Direction.values())
                .map(Direction::getCommand)
                .collect(Collectors.toList());
        bridge.forEach(direction -> assertThat(directions).contains(direction));
    }
}