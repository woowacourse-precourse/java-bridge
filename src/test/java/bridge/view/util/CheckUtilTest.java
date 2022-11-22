package bridge.view.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static bridge.view.util.CheckUtil.*;

class CheckUtilTest {

    @DisplayName("다리 길이가 3이상 20이하의 숫자인지 테스트")
    @Test
    void 다리_길이가_3이상_20이하의_숫자인지_테스트() {
        assertThatThrownBy(() -> checkInputBridgeSize(1, "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    @DisplayName("숫자를 입력했는지 테스트")
    @Test
    void 숫자를_입력했는지_테스트() {
        assertThatThrownBy(() -> checkIsString("a", "[ERROR] 숫자를 입력해주세요."))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자");
    }

    @DisplayName("사용자가 이동할 칸을 적절히 입력했는지 테스트")
    @Test
    void 사용자가_이동할_칸을_적절히_입력했는지_테스트() {
        assertThatThrownBy(() -> checkInputReadMoving("T", "[ERROR] U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력해야 합니다."))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("ERROR");
    }

    @DisplayName("사용자가_게임을 다시 시도할지 종료할지 여부를 입력했는지 테스트")
    @Test
    void 사용자가_게임을_다시_시도할지_종료할지_여부를_입력했는지_테스트() {
        assertThatThrownBy(() -> checkInputReadGameCommand("C", "[ERROR] R(재시도)와 Q(종료) 중 하나의 문자를 입력해야 합니다."))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("R");
    }
}