package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class FeatureTest {

    @Test
    void 다리_만들기_테스트() {
        BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeSize = 3;
        List<String> directions = bm.makeBridge(bridgeSize);

        assertThat(directions).containsAnyElementsOf(Arrays.asList("U", "D"));
        assertThat(directions).hasSize(bridgeSize);
    }

    @Test
    void 사용자_객체_테스트() {
        User user = new User();
        user.saveChoice("U");
        user.saveChoice("D");
        user.saveChoice("D");

        assertThat(user.getUserMoveChoice()).hasSize(3);
        assertThat(user.getUserMoveChoice()).isEqualTo(Arrays.asList("U", "D", "D"));
    }

    @Test
    void 사용자_입력과_정답_비교_일치_테스트() {
        BridgeGame bg = new BridgeGame();
        List<String> answer = new ArrayList<>(Arrays.asList("U", "D", "D"));
        User user = new User();
        user.saveChoice("U");
        user.saveChoice("D");
        user.saveChoice("D");

        assertThat(bg.move(answer, user)).hasSize(3);
        assertThat(bg.move(answer, user)).isEqualTo(Arrays.asList(Arrays.asList("O", "U"), Arrays.asList("O", "D"), Arrays.asList("O", "D")));
    }

    @Test
    void 사용자_입력과_정답_비교_불일치_테스트() {
        BridgeGame bg = new BridgeGame();
        List<String> answer = new ArrayList<>(Arrays.asList("U", "U", "U"));
        User user = new User();
        user.saveChoice("U");
        user.saveChoice("D");
        user.saveChoice("D");

        assertThat(bg.move(answer, user)).hasSize(3);
        assertThat(bg.move(answer, user)).isEqualTo(Arrays.asList(Arrays.asList("O", "U"), Arrays.asList("X", "D"), Arrays.asList("X", "D")));
    }

    @Test
    void 재시도_여부_테스트() {
        BridgeGame bg = new BridgeGame();
        assertThat(bg.retry("R")).isEqualTo(true);
        assertThat(bg.retry("Q")).isEqualTo(false);
    }

}
