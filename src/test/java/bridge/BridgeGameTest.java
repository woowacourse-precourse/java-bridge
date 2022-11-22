package bridge;

import bridge.model.Result;
import bridge.service.BridgeGame;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BridgeGameTest {
    private final BridgeGame bridgeGame = new BridgeGame();

    @BeforeEach
    public void settingTreeSizeBridge(){
        bridgeGame.start(List.of("U","D","U"));
    }

    @Test
    void 첫번째_다리건너기에_성공한경우_통과한_단계를_올바르게_반환하는지_테스트(){
        int correctStep = bridgeGame.move("U");
        assertThat(correctStep).isEqualTo(1);
    }

    @Test
    void 두번쨰_다리건너기에_성공한경우_통과한_단계를_올바르게_반환하는지_테스트(){
        int correctStep = bridgeGame.move("U");
        correctStep = bridgeGame.move("D");
        assertThat(correctStep).isEqualTo(2);
    }

    @Test
    void 재시작할경우_키입력에_따라_올바르게_반환하는지_테스트(){
        assertThat(bridgeGame.retry("R")).isEqualTo(true);
        assertThat(bridgeGame.retry("Q")).isEqualTo(false);
    }

    @Test
    void 게임결과목록을_올바르게_반환하는지_테스트(){
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("D");

        List<Result> gameResults = bridgeGame.getGameResult();

        assertThat(gameResults.size()).isEqualTo(2);
        assertThat(gameResults.get(0).isSameResult(new Result("U", true))).isEqualTo(true);
        assertThat(gameResults.get(1).isSameResult(new Result("D", true))).isEqualTo(true);
    }

    @Test
    void 재시작_횟수에_따른_시도횟수값이_올바르게_반환하는지_테스트(){
        bridgeGame.retry("R");
        bridgeGame.retry("R");
        assertThat(bridgeGame.getRetryCount()).isEqualTo(3);
    }

    @Test
    void 최근_선택한_방향의_정답유무를_올바르게_반환하는지_테스트(){
        bridgeGame.move("U");
        assertThat(bridgeGame.isSuccess()).isEqualTo(true);
        bridgeGame.move("U");
        assertThat(bridgeGame.isSuccess()).isEqualTo(false);
    }

}
