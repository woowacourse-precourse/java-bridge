package bridge;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class UpAndDownTest {

    @DisplayName("숫자에 따라 해당하는 문자열 반환")
    @Test
    void _1의경우_U를반환(){
        final int upNumber = 1;
        Assertions.assertSimpleTest(() -> {
            assertThat(UpAndDown.UP.convertNumberToUpAndDown(upNumber)).isEqualTo("U");
        });
    }


    @DisplayName("알파벳과 방향의 일치 여부")
    @Test
    void _U의경우UP(){
        Assertions.assertSimpleTest(()->{
            assertThat(UpAndDown.UP.isEqualDirection("U")).isTrue();
        });
    }
}