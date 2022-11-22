package bridge.domain.bridge;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class BridgeMoveTest {
    
    @DisplayName("gnearateNumber가 0이면 DOWN을 반환한다.")
    @Test
    void generateByNumberForDown() {
        assertThat(BridgeMove.generateByNumber(0))
                .isEqualTo(BridgeMove.DOWN);
    }
    
    @DisplayName("gnearateNumber가 1이면 UP을 반환한다.")
    @Test
    void generateByNumberForUp() {
        assertThat(BridgeMove.generateByNumber(1))
                .isEqualTo(BridgeMove.UP);
    }
    
    @DisplayName("잘못된 생성 Number를 인수로 실행하면 AssertionError를 발생시킨다.")
    @Test
    void generateByNumberByInvalidGenerateNumber() {
        assertThatThrownBy(() -> BridgeMove.generateByNumber(5))
                .isInstanceOf(AssertionError.class);
    }
    
    @DisplayName("인수가 BridgeMove의 direction에 포함되는지 확인한다.")
    @EnumSource(value = BridgeMove.class)
    @ParameterizedTest
    void isContainByValid(BridgeMove move) {
        assertThat(BridgeMove.isContain(move.getDirection())).isEqualTo(true);
    }
    
    @DisplayName("인수가 BridgeMove의 direction에 포함되지 않으면 false를 반환한다.")
    @Test
    void isContainByInvalid() {
        assertThat(BridgeMove.isContain("A")).isEqualTo(false);
    }
    
}
