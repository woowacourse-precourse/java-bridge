package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    private static InputView inputView;
    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeAll
    static void init(){
        inputView = new InputView();
    }


    @Test
    @DisplayName("숫자가 아닌 값을 예외처리한다.")
    void 숫자가_아닌_값_예외처리() {
        InputStream is = new ByteArrayInputStream("adsf".getBytes());
        System.setIn(is);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("3~20 사이가 아닌 수 예외처리한다.")
    void 유효한_범위가_아닌_값_예외처리() {
        InputStream is = new ByteArrayInputStream("1515125".getBytes());
        System.setIn(is);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

    }

}