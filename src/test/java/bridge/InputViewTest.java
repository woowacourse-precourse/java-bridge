package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName("사이즈 벗어난 예외테스트")
    @Test
    void sizeError_test() {
        InputView inputView = new InputView();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputView.checkError("2");
        });
    }

    @DisplayName("숫자가 아닌 예외테스트")
    @Test
    void numberError_test() {
        InputView inputView = new InputView();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputView.checkError("a");
        });
    }

    @DisplayName("이동할 칸 ud아닌입력 예외테스트")
    @Test
    void udError_test() {
        InputView inputView = new InputView();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputView.isUD("a");
        });
    }
}