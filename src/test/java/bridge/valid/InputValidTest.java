package bridge.valid;

import static org.assertj.core.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidTest {
    InputValid valid = new InputValid();

    @DisplayName("입력 받은 다리의 길이가 하나의 숫자가 아니면 false를 반환한다")
    @Test
    void createIsNumberValid() {
        assertThat(valid.checkLengthValid("te")).isEqualTo(false);
    }

    @DisplayName("입력 받은 다리의 길이가 3이상 20이하에 있지 않으면 false를 반환한다")
    @Test
    void createIsRangeValid() {
        assertThat(valid.checkLengthValid("100")).isEqualTo(false);
    }

    @DisplayName("입력받은 이동칸이 U 또는 D가 아니면 false를 반환한다")
    @Test
    void createIsUPDownValid() {
        assertThat(valid.checkChoice("TT")).isEqualTo(false);
    }

    @DisplayName("입력 받은 재시도 값이 R 또는 Q가 아니면 false를 반환한다")
    @Test
    void createIsContinueValid() {
        assertThat(valid.checkCommand("QQ")).isEqualTo(false);
    }

}
