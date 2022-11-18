package bridge.domain.maker;

import static bridge.constant.Direction.LOWER;
import static bridge.constant.Direction.UPPER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import bridge.constant.Direction;

class BridgeMakerTest {

    @Test
    void 길이_만큼_다리를_만든다() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        assertThat(bridgeMaker.makeBridge(18)).hasSize(18);
    }

    @Test
    void 다리는_U_D_로만_이루어진다() {
        List<Direction> bridgeDirections = List.of(UPPER, LOWER, UPPER, LOWER, UPPER);
        Iterator<Integer> bridgeNumberIterator = getBridgeNumbersFrom(bridgeDirections).iterator();
        List<String> bridge = new BridgeMaker(bridgeNumberIterator::next).makeBridge(bridgeDirections.size());

        assertThat(bridge).containsExactlyElementsOf(getCapitalLettersFrom(bridgeDirections));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 2, 21})
    void 잘못된_다리길이는_예외를_던진다(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        assertThatIllegalArgumentException().isThrownBy(() -> bridgeMaker.makeBridge(size));
    }

    private List<Integer> getBridgeNumbersFrom(List<Direction> bridgeDirections) {
        return bridgeDirections.stream()
                .map(Direction::bridgeNumber)
                .collect(Collectors.toList());
    }

    private List<String> getCapitalLettersFrom(List<Direction> bridgeDirections) {
        return bridgeDirections.stream()
                .map(Direction::capitalLetter)
                .collect(Collectors.toList());
    }
}