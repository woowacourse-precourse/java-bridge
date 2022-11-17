package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {
    BridgeMaker bridgeMaker;

    @BeforeEach()
    void setUp() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    @DisplayName("랜덤 숫자 생성기는 오직 0 또는 1을 생성한다.")
    void 랜덤숫자생성기는_오직_0_OR_1_생성한다() {
        assertThat(new BridgeRandomNumberGenerator().generate()).isIn(0, 1);
    }
}
