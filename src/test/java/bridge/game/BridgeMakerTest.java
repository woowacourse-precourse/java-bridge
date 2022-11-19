package bridge.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class BridgeMakerTest {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("원하는 길이를 반환했는지 확인하는 테스트")
    @ValueSource(ints = {3, 5, 10, 20})
    @ParameterizedTest
    void makeBridgeLengthTest(Integer input) {
        List<String> bridge = bridgeMaker.makeBridge(input);

        Assertions.assertThat(bridge.size()).isEqualTo(input);
    }

    @Test
    @DisplayName("Bridge가 'U'와 'D'로 이루어졌는지 확인하는 테스트")
    void makeBridgeDirectionTest() {
        List<String> bridge = bridgeMaker.makeBridge(10);

        boolean correct = hasCorrectCharacters(bridge);

        Assertions.assertThat(correct).isEqualTo(true);
    }

    private boolean hasCorrectCharacters(List<String> bridge) {
        for (String tile : bridge) {
            if (!isCorrect(tile)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCorrect(String tile) {
        return tile.equals(Bridge.UPPER_DIRECTION.getDirection()) || tile.equals(Bridge.LOWER_DIRECTION.getDirection());
    }
}