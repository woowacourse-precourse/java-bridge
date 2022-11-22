package bridge;

import static bridge.constant.Direction.LOWER;
import static bridge.constant.Direction.UPPER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.Direction;

class BridgeMakerTest {

    @Test
    void 크기만큼_다리_문자열을_만든다() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        assertThat(bridgeMaker.makeBridge(18)).hasSize(18);
    }

    @Test
    void 다리_문자열은_U_D로만_이루어진다() {
        List<String> bridgeStrings = makeBridgeWithNumbers(List.of(0, 1, 0));

        assertThat(bridgeStrings).containsOnly(UPPER.capitalLetter(), LOWER.capitalLetter());
    }

    @Test
    void 다리_문자열이_U_D가_아니면_예외를_던진다() {
        List<Direction> directions = List.of(UPPER, LOWER, UPPER, LOWER, UPPER);
        List<String> bridgeStrings = makeBridgeWithDirections(directions);

        assertThat(bridgeStrings).containsExactlyElementsOf(getCapitalLettersFrom(directions));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 10, 20})
    void 다리_크기는_3이상_20이하이다(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        assertThatNoException().isThrownBy(() -> bridgeMaker.makeBridge(size));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 2, 21})
    void 잘못된_다리크기는_예외를_던진다(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        assertThatIllegalArgumentException().isThrownBy(() -> bridgeMaker.makeBridge(size));
    }

    private List<String> makeBridgeWithNumbers(List<Integer> numbers) {
        Iterator<Integer> iterator = numbers.listIterator();
        BridgeMaker bridgeMaker = new BridgeMaker(iterator::next);
        return bridgeMaker.makeBridge(numbers.size());
    }

    private List<String> makeBridgeWithDirections(List<Direction> directions) {
        List<Integer> numbers = getBridgeNumbersFrom(directions);
        return makeBridgeWithNumbers(numbers);
    }

    private List<Integer> getBridgeNumbersFrom(List<Direction> directions) {
        return directions.stream()
                .map(Direction::bridgeNumber)
                .collect(Collectors.toList());
    }

    private List<String> getCapitalLettersFrom(List<Direction> directions) {
        return directions.stream()
                .map(Direction::capitalLetter)
                .collect(Collectors.toList());
    }
}