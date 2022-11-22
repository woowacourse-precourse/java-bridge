package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import camp.nextstep.edu.missionutils.test.NsTest;

public class BridgeGameTest {
    private final String PASS = "O";
    private final String FAIL = "X";

    @DisplayName("사용자가 입력한 이동할 칸과 다리를 제대로 비교하는 지 확인")
    @Test
    void compareTest() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D", "U", "D", "U"));
        assertThat(bridgeGame.checkAnswer("D"))
                .isEqualTo(List.of("D",FAIL));
        assertThat(bridgeGame.checkAnswer("U"))
                .isEqualTo(List.of("U",PASS));
    }
}
