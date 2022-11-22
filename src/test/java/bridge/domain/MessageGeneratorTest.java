package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.enums.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class MessageGeneratorTest {

    private static final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private static final Integer BRIDGE_SIZE = 3;

    @DisplayName("'이동 가능 방향' 개수 만큼 리스트가 존재해야 한다.")
    @Test
    void 이동방향개수_만큼_리스트_존재() {
        // given
        BridgeGame bridgeGame = BridgeGame.initNewGame(BRIDGE_SIZE);

        // when
        move(bridgeGame, 1);
        List<String> mapImage = MessageGenerator.getInstance().getMapImage(bridgeGame);

        // then
        Assertions.assertThat(mapImage.size()).isEqualTo(Direction.getNumOfDirections());
    }

    @DisplayName("하나의 layer에, 한 개의 값이 있어야 한다.")
    @Test
    void 하나의_레이어에_하나의값_존재() {
        // given
        int moveCount = 3;
        BridgeGame bridgeGame = BridgeGame.initNewGame(BRIDGE_SIZE);

        // when
        move(bridgeGame, moveCount);
        List<String> mapImage = MessageGenerator.getInstance().getMapImage(bridgeGame);

        // then
        Assertions.assertThat(countDirectionSign(mapImage)).isEqualTo(moveCount);
    }

    private int countDirectionSign(List<String> mapImage) {
        int count = 0;

        for (String layer : mapImage) {
            String[] chunks = layer.split("\\|");
            for (String chunk : chunks) {
                count += getNumOfSign(chunk);
            }
        }
        return count;
    }

    private int getNumOfSign(String chunk) {
        int count = 0;
        for (int index = 0 ; index < chunk.length(); index++) {
            if (chunk.charAt(index) == 'O' || chunk.charAt(index) == 'X') {
                count++;
            }
        }
        return count;
    }

    private String getRandomDirection() {
        int randomNumber = bridgeNumberGenerator.generate();

        return Direction.getAbbrByCode(randomNumber);
    }

    private void move(BridgeGame bridgeGame, int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            bridgeGame.move(getRandomDirection());
        }
    }
}