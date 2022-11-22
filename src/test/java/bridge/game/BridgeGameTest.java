package bridge.game;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeMaker;
import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeSize;
import bridge.domain.bridge.maker.BridgeMakerFake;
import bridge.domain.code.BridgePosition;
import bridge.utils.TestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        var fakeGenerate = new BridgeMakerFake(TestUtils.convertStringToListNumber("1,0,1,0"));
        var makeBridge = new BridgeMaker(fakeGenerate);
        var bridgeSize = new BridgeSize("4");
        var bridge = new Bridge(makeBridge, bridgeSize);

        this.bridgeGame = new BridgeGame(bridge);
    }

    @AfterEach
    void tearDown() {
        this.bridgeGame = null;
    }

    @Test
    void 게임이_모두_완료가_되면_클리어_상태를_출력합니다() {
        this.moveAnswer();

        var gameStatus = bridgeGame.getGameStatus();

        assertThat(gameStatus.resultMessage()).contains("성공");
    }

    @Test
    void 게임을_실패하면_실패상태가_됩니다() {
        bridgeGame.move(BridgePosition.DOWN);

        var gameStatus = bridgeGame.getGameStatus();

        assertThat(gameStatus.resultMessage()).contains("실패");
    }

    @Test
    void 게임을_실패하면_실패상태에서_재시작한_이후_성공하면_클리어상태가_됩니다() {
        this.bridgeGame.move(BridgePosition.DOWN);
        var beforeStatus = bridgeGame.getGameStatus();

        this.bridgeGame.retry();
        this.moveAnswer();

        var lastStatus = bridgeGame.getGameStatus();

        assertThat(beforeStatus.resultMessage()).contains("실패");
        assertThat(lastStatus.resultMessage()).contains("성공");
    }

    private void moveAnswer() {
        bridgeGame.move(BridgePosition.UP);
        bridgeGame.move(BridgePosition.DOWN);
        bridgeGame.move(BridgePosition.UP);
        bridgeGame.move(BridgePosition.DOWN);
    }


}