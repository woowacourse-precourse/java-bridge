package bridge.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class EmptyCheckerTest extends NsTest {

    @DisplayName("빈 입력을 잘 처리하는가 - '   ' 경우 (공백)")
    @Test
    void checkEmptyCheckException1() {
        assertThatThrownBy(() -> EmptyChecker.check("    "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 입력을 잘 처리하는가 - null 경우 (공백)")
    @Test
    void checkEmptyCheckException2() {
        assertThatThrownBy(() -> EmptyChecker.check(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 입력을 잘 처리하는가 -  \"\"  경우 (공백)")
    @Test
    void checkEmptyCheckException3() {
        assertThatThrownBy(() -> EmptyChecker.check(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}