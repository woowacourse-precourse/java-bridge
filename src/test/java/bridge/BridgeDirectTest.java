package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeDirectTest {

    @Test
    @DisplayName("[numToDirection] 1은 U로 0은 D로 매핑되는지 테스트")
    void numToDirection() {
        //given
        //when
        //then
        Assertions.assertThat(BridgeDirect.numToDirection(1)).isEqualTo("U");
        Assertions.assertThat(BridgeDirect.numToDirection(0)).isEqualTo("D");
    }

    @Test
    @DisplayName("[valueOfDirection] 입력값이 D인경우 BridgeDirect.DOWN객체가 가져오는지 테스트")
    void valueOfDirection() {
        //given
        String userInput = "D";
        //when
        //then
        Assertions.assertThat(BridgeDirect.valueOfDirection(userInput)).isEqualTo(BridgeDirect.DOWN);
    }
}