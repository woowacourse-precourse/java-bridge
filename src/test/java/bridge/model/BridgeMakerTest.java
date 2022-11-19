package bridge.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {
    BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker maker = new BridgeMaker(numberGenerator);

    @BeforeEach
    public void beforeEach() {
    }

    @Test
    @DisplayName("위 칸 테스트")
    public void topTest() {
        String actual = maker.topOrBottom(1);
        assertThat(actual).isEqualTo("U");
    }

    @Test
    @DisplayName("아래 칸 테스트")
    public void bottomTest() {
        String actual = maker.topOrBottom(0);
        assertThat(actual).isEqualTo("D");
    }

    @Test
    @DisplayName("숫자 에러 테스트")
    public void numberErrorTest() {
        assertThatThrownBy(() -> maker.topOrBottom(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

}