package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @DisplayName("U 입력을 요구할때 U를 입력한 경우 테스트")
    @Test
    void calculateMovingUpAndUp() {
        Bridge bridge = Calculator.moveCalculate("U","U");
        assertThat(bridge.getUpShape()).isEqualTo("O");
        assertThat(bridge.getDownShape()).isEqualTo(" ");
    }

    @DisplayName("U 입력을 요구할때 D를 입력한 경우 테스트")
    @Test
    void calculateMovingUpAndDown() {
        Bridge bridge = Calculator.moveCalculate("U","D");
        assertThat(bridge.getUpShape()).isEqualTo(" ");
        assertThat(bridge.getDownShape()).isEqualTo("X");
    }

    @DisplayName("D 입력을 요구할때 D를 입력한 경우 테스트")
    @Test
    void calculateMovingDownAndDown() {
        Bridge bridge = Calculator.moveCalculate("D","D");
        assertThat(bridge.getUpShape()).isEqualTo(" ");
        assertThat(bridge.getDownShape()).isEqualTo("O");
    }

    @DisplayName("D 입력을 요구할때 U를 입력한 경우 테스트")
    @Test
    void calculateMovingDownAndUp() {
        Bridge bridge = Calculator.moveCalculate("D","U");
        assertThat(bridge.getUpShape()).isEqualTo("X");
        assertThat(bridge.getDownShape()).isEqualTo(" ");
    }
}
