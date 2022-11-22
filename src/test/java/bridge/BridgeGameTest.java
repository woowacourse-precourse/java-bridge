package bridge;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeGameTest {

    private final BridgeGame bridgeGame = new BridgeGame();

    @Test
    void 다리건너기_정답_테스트() {
        List<String> footholds = Arrays.asList("U", "U", "D", "D");
        List<String> crossed = Arrays.asList("U", "U", "D", "D");
        Bridge bridge = new Bridge(footholds, crossed);

        Boolean correct = bridgeGame.isCorrect(bridge);

        Assertions.assertThat(correct).isEqualTo(true);
    }

    @Test
    void 다리건너기_오답_테스트() {
        List<String> footholds = Arrays.asList("U", "U", "D", "D");
        List<String> crossed = Arrays.asList("U", "U", "D", "U");
        Bridge bridge = new Bridge(footholds, crossed);

        Boolean correct = bridgeGame.isCorrect(bridge);

        Assertions.assertThat(correct).isEqualTo(false);
    }

    @Test
    void 다리건너기_완료_테스트() {
        List<String> footholds = Arrays.asList("U", "D", "U", "D");
        List<String> crossed = Arrays.asList("U", "D", "U", "D");
        Bridge bridge = new Bridge(footholds, crossed);

        boolean allCrossed = bridgeGame.isAllCrossed(bridge);

        Assertions.assertThat(allCrossed).isEqualTo(true);
    }

    @Test
    void 다리건너기_미완료_테스트() {
        List<String> footholds = Arrays.asList("U", "D", "U", "D");
        List<String> crossed = Arrays.asList("U", "D", "U");
        Bridge bridge = new Bridge(footholds, crossed);

        boolean allCrossed = bridgeGame.isAllCrossed(bridge);

        Assertions.assertThat(allCrossed).isEqualTo(false);
    }

    @Test
    void 건넌다리_초기화_작동_테스트() {
        Bridge bridge = new Bridge(Arrays.asList("U", "D", "U", "D", "U"), Arrays.asList("U", "D", "U", "D", "D"));
        bridgeGame.resetCrossed(bridge);

        Assertions.assertThat(bridge.getCrossed().size()).isEqualTo(0);
    }

    @Test
    void 재도전_횟수_증가_테스트() {
        Bridge bridge = new Bridge(Arrays.asList("U", "D", "U", "D", "U"), Arrays.asList("U", "D", "U", "D", "D"));
        bridgeGame.increaseTried(bridge);

        Assertions.assertThat(bridge.getTried()).isEqualTo(2);
    }

    @Test
    void 게임_클리어_실패_미도착_테스트() {
        List<String> footholds = Arrays.asList("U", "D", "U", "D", "U");
        List<String> crossed = Arrays.asList("U", "D", "U", "D");
        Bridge bridge = new Bridge(footholds, crossed);

        boolean clear = bridgeGame.isClear(bridge);

        Assertions.assertThat(clear).isEqualTo(false);
    }

    @Test
    void 게임_클리어_실패_오답_테스트() {
        List<String> footholds = Arrays.asList("U", "D", "U", "D", "U");
        List<String> crossed = Arrays.asList("U", "D", "U", "D", "D");
        Bridge bridge = new Bridge(footholds, crossed);

        boolean clear = bridgeGame.isClear(bridge);

        Assertions.assertThat(clear).isEqualTo(false);
    }

    @Test
    void 게임_클리어_성공_테스트() {
        List<String> footholds = Arrays.asList("U", "D", "U", "D", "U");
        List<String> crossed = Arrays.asList("U", "D", "U", "D", "U");
        Bridge bridge = new Bridge(footholds, crossed);

        boolean clear = bridgeGame.isClear(bridge);

        Assertions.assertThat(clear).isEqualTo(true);
    }

}
