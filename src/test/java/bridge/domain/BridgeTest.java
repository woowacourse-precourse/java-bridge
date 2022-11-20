package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

    private Bridge bridge;
    private int bound;

    @BeforeEach
    void init() {
        List tmp = List.of("U", "U", "D", "U");
        this.bridge = new Bridge(tmp);
        this.bound = tmp.size();
    }

    @Test
    @DisplayName("인덱스에 대한 값이 일치하는지_정상")
    void matchWithIndex_true() {
        boolean result = bridge.matchWithIndex(1, "U");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("인덱스에 대한 값이 일치하는지_불일치")
    void matchWithIndex_false() {
        boolean result = bridge.matchWithIndex(1, "D");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("파라미터 값이 다리의 끝인가_일치")
    void isFinish_true() {
        boolean result = bridge.isFinish(bound - 1);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("파라미터 값이 다리의 끝인가_불일치")
    void isFinish_false() {
        boolean result = bridge.isFinish(0);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("매개변수로 입력한 값이 다리의 값과 일치하는지_일치")
    void getStateOf_true() {
        BridgeState result = bridge.getStateOf(0, "U");
        assertThat(result).isEqualTo(BridgeState.CORRECT);
    }

    @Test
    @DisplayName("매개변수로 입력한 값이 다리의 값과 일치하는지_불일치")
    void getStateOf_false() {
        BridgeState result = bridge.getStateOf(0, "D");
        assertThat(result).isEqualTo(BridgeState.WRONG);
    }

}