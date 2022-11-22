package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.model.BridgeRandomNumberGenerator;
import bridge.validator.Validator;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("다리길이 올바른 입력")
    void correctBridgeSizeInput() {
        assertThatCode(() -> Validator.checkBridgeSize(10))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("플레이어 이동 시 올바른 입력")
    void correctMove() {
        assertThatCode(() -> Validator.checkMoveInput("U"))
                .doesNotThrowAnyException();

        assertThatCode(() -> Validator.checkMoveInput("D"))
                .doesNotThrowAnyException();

    }

    @Test
    void Random_Bridge_Make_Test() {
        List<String> bridge;
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = 10;
        bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge.size()).isEqualTo(size);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
