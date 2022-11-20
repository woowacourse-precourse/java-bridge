package bridge.utils;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;


class EmptyCheckerTest  extends NsTest{
    // 테스트가 빈 공백, "", null 등 다양한 빈 입력에 대한 처리를 할 수 있는지 확인.

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