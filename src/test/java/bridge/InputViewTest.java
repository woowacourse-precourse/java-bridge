package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static bridge.ErrorMessage.IS_NOT_NUMBER;
import static bridge.ErrorMessage.OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    private static InputView inputView;

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
                .hasMessage(IS_NOT_NUMBER.returnMessage());
    }

    @Test
    @DisplayName("3~20 사이가 아닌 수 예외처리한다.")
    void 유효한_범위가_아닌_값_예외처리() {
        InputStream is = new ByteArrayInputStream("1515".getBytes());
        System.setIn(is);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_RANGE.returnMessage());

    }

}