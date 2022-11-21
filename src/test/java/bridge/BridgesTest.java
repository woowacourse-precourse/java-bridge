package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BridgesTest {

    @DisplayName("입력한 U,D에 따라 해당 bridge를 건널 수 있는지를 판단한다.")
    @Test
    void tryPass() {
        //given
        Bridges bridges = new Bridges(Arrays.asList("U", "D", "U", "D"));
        //when
        boolean isPass1 = bridges.tryPass("U");
        boolean isPass2 = bridges.tryPass("U");
        //then
        assertThat(isPass1).isEqualTo(true);
        assertThat(isPass2).isEqualTo(false);
    }

    @DisplayName("모든 bridge가 통과 성공한 상태인지 판단한다.")
    @Test
    void isAllPassed() {
        //given
        Bridges bridges = new Bridges(Arrays.asList("U", "D", "U", "D"));
        bridges.tryPass("U");
        bridges.tryPass("D");
        bridges.tryPass("U");
        bridges.tryPass("D");

        //then
        assertThat(bridges.isAllPassed()).isEqualTo(true);
    }
}