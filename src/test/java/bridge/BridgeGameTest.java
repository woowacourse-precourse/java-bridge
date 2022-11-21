package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    @Test
    void 다리_맞추기_실패_테스트(){
        List<String> answerList = List.of("U","D","D");
        BridgeGame bridgeGame = new BridgeGame(answerList);
        String input = "D";
        String result = bridgeGame.move(input);
        assertThat(result).isEqualTo("X");
    }

    @Test
    void 다리_맞추기_성공_테스트(){
        List<String> answerList = List.of("U","D","D");
        BridgeGame bridgeGame = new BridgeGame(answerList);
        String input = "U";
        String result = bridgeGame.move(input);
        assertThat(result).isEqualTo("O");
    }

}
