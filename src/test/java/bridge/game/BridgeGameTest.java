package bridge.game;

import bridge.generator.BridgeMaker;
import bridge.generator.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameTest {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private GameCharacter character;
    private BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        character = new GameCharacter();
        bridgeGame = new BridgeGame(character);
    }

    @DisplayName("게임 캐릭터가 이동할 칸의 이동 가능 여부 체크 테스트")
    @ValueSource(strings = {"U", "D", "D", "U", "D"})
    @ParameterizedTest
    void isAbleToMove(String destination) {
        bridgeGame.setBridge(bridgeMaker.makeBridge(20));
        character.setNextMove(destination);
        String nextRightDestination = bridgeGame.showRightDestinationInArea(character.showNextArea());
        boolean ableToMove = bridgeGame.isAbleToMove();
        if (nextRightDestination.equals(destination)) {
            Assertions.assertThat(ableToMove).isTrue();
        }
        if (!nextRightDestination.equals(destination)) {
            Assertions.assertThat(ableToMove).isFalse();
        }
    }
}