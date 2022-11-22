package bridge;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputViewTest {
    @Test
    void 다리_길이를_정수로_입력받았을_때(){
        // given
        InputView iv = new InputView();
        String str = "5";

        // when
        boolean num = iv.isNumber(str);

        // then
        assertThat(num).isEqualTo(true);
    }

    @Test
    void 다리_길이를_문자로_입력받았을_때(){
        // given
        InputView iv = new InputView();
        String str = "a";

        // when
        boolean num = iv.isNumber(str);

        // then
        assertThat(num).isEqualTo(false);
    }
}