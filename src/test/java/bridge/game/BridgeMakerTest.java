package bridge.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeMakerTest {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @Test
    @DisplayName("원하는 길이를 반환했는지 확인하는 테스트")
    void makeBridgeLengthTest() {
        int expectedLength = 9;
        List<String> bridge = bridgeMaker.makeBridge(expectedLength);

        Assertions.assertThat(bridge.size()).isEqualTo(expectedLength);
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