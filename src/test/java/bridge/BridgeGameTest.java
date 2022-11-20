package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest extends NsTest {

//    @DisplayName("제시작때 받는 인풋이 R 또는 Q가 아닐경우에는 IllegalArgumentException 발생")
//    @ValueSource(strings = {"U", "D", "100", "a", "r", "q", "!"})
//    @ParameterizedTest
//    void 제시작_테스트(String input) {
//        BridgeGame bg = new BridgeGame();
//        assertThatThrownBy(() -> bg.retry(input))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
    @Override
    protected void runMain() {}
}
