package bridge.model;

import static bridge.util.Constants.INITIAL_ATTEMPTS;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    public static final List<String> bridge = List.of("U", "D", "D");
    private BridgeGame bridgeGame;
    private Result result;


    @BeforeEach
    void 게임_생성() {
        result = Result.byDefault();
        bridgeGame = new BridgeGame(new Bridge(bridge), result);
    }

    @Test
    void 이동_테스트() {
        Assertions.assertEquals(SurviveAndDie.SURVIVE, bridgeGame.move(0, Position.UP));
        Assertions.assertEquals(SurviveAndDie.SURVIVE, bridgeGame.move(1, Position.DOWN));
        Assertions.assertEquals(SurviveAndDie.DIE, bridgeGame.move(2, Position.UP));
    }

    @Test
    void 재시작_테스트() {
        Assertions.assertEquals(INITIAL_ATTEMPTS, result.getAttempts());
        bridgeGame.retry();
        Assertions.assertEquals(INITIAL_ATTEMPTS + 1, result.getAttempts());
    }

    @Test
    void 성공_테스트() {
        Assertions.assertEquals(SuccessAndFail.FAIL, result.getSuccessOrFail());
        result.setSuccess();
        Assertions.assertEquals(SuccessAndFail.SUCCESS, result.getSuccessOrFail());
    }

}