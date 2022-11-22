package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.CalculationResult;
import bridge.domain.User;
import bridge.utils.BridgeNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculationResultTest {

    @BeforeEach
    void init() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(
                newArrayList(1, 0, 0, 1, 1));
        User.setBridgeSize("5");
        new Bridge(numberGenerator);
    }

    @DisplayName("현재까지 이동한 값과 생성한 다리가 정확히 비교되는지 테스트")
    @Test
    void checkCalculateResult() {
        User user = new User();
        User.recordUserMoving("U");
        User.recordUserMoving("D");
        User.recordUserMoving("D");
        boolean result = CalculationResult.calculateResult();
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("사용자의 값과 생성된 다리가 다를 경우 최종결과가 정확히 비교되는지 테스트")
    @Test
    void checkCalculateFinalResult() {
        User user = new User();
        User.recordUserMoving("U");
        User.recordUserMoving("D");
        User.recordUserMoving("D");
        User.recordUserMoving("U");
        User.recordUserMoving("D");
        boolean result = CalculationResult.calculateFinalResult();
        assertThat(result).isEqualTo(false);
    }

}
