package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeGameTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        BridgeGame bridgeGame = new BridgeGame(5);
        List<String> bridge = bridgeGame.getBridge();
        assertThat(bridge).contains("U", "D");
        assertThat(bridge).hasSize(5);
    }

    @DisplayName("잘못된 다리 길이 입력 시 예외 처리")
    @ValueSource(ints = {-5, 0, 2, 22})
    @ParameterizedTest
    void 예외_테스트_다리길이(int input) {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                new BridgeGame(input);
            }).isInstanceOf(IllegalArgumentException.class);
            output().contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {

    }
}
