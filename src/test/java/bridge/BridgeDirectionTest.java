package bridge;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeDirectionTest {
    
    @DisplayName("gnearateNumber가 0이면 DOWN을 반환한다.")
    @Test
    void generateByNumberForDown() {
        assertThat(BridgeDirection.generateByNumber(0))
                .isEqualTo(BridgeDirection.DOWN);
    }
    
    @DisplayName("gnearateNumber가 1이면 UP을 반환한다.")
    @Test
    void generateByNumberForUp() {
        assertThat(BridgeDirection.generateByNumber(1))
                .isEqualTo(BridgeDirection.UP);
    }
    
    @DisplayName("잘못된 생성 Number를 인수로 실행하면 AssertionError를 발생시킨다.")
    @Test
    void generateByNumberByInvalidGenerateNumber() {
        assertThatThrownBy(() -> BridgeDirection.generateByNumber(5))
                .isInstanceOf(AssertionError.class);
    }
}
