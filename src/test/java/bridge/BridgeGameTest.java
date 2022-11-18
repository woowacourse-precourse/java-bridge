package bridge;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.Answer;
import bridge.domain.Bridge;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    @DisplayName("사용자가 입력한 값에 따라 정답을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"RIGHT,U", "WRONG,D"})
    void finishTest(Answer answer, String userSelect) {
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "D", "D")));

        Answer result = bridgeGame.move(userSelect);

        assertThat(result).isEqualTo(answer);
    }

}