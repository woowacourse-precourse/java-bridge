package bridge.game;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeSize;
import bridge.domain.bridge.maker.BridgeMaker;
import bridge.domain.bridge.maker.BridgeMakerFake;
import bridge.domain.code.BridgePosition;
import bridge.utils.TestUtils;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeGameTest {


    @Test
    void 게임이_모두_완료가_되면_클리어_상태를_출력합니다() {
        var makeBridge = new BridgeMaker(
                new BridgeMakerFake(TestUtils.convertStringToListNumber("1,0,1,0"))
        );
        var bridgeSize = new BridgeSize("4");

        var bridge = new Bridge(makeBridge, bridgeSize);
        var game = new BridgeGame(bridge);

        game.move(BridgePosition.UP);
        game.move(BridgePosition.DOWN);
        game.move(BridgePosition.UP);
        game.move(BridgePosition.DOWN);

        assertThat(game.canPlayerMove()).isFalse();
        assertThat(game.isClear()).isTrue();
    }

    @Test
    void 게임을_실패하면_실패상태가_됩니다() {
        var makeBridge = new BridgeMaker(
                new BridgeMakerFake(TestUtils.convertStringToListNumber("1,0,1,0"))
        );
        var bridgeSize = new BridgeSize("4");

        var bridge = new Bridge(makeBridge, bridgeSize);
        var game = new BridgeGame(bridge);

        game.move(BridgePosition.DOWN);

        assertThat(game.canPlayerMove()).isFalse();
        assertThat(game.isClear()).isFalse();
    }

}