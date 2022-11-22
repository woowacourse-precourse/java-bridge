package bridge;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputViewTest {
    @Test
    void 다리_길이를_정수로_입력받았을_때() {
        // given
        InputView iv = new InputView();
        String str = "5";

        // when
        boolean bool = iv.isNumber(str);

        // then
        assertThat(bool).isEqualTo(true);
    }

    @Test
    void 다리_길이를_문자로_입력받았을_때() {
        // given
        InputView iv = new InputView();
        String str = "a";

        // when
        boolean bool = iv.isNumber(str);

        // then
        assertThat(bool).isEqualTo(false);
    }

    @Test
    void 다리_길이를_범위에_입력받았을_때() {
        // given
        InputView iv = new InputView();
        int num = 10;

        // when
        boolean bool = iv.isBetween3To20(num);

        // then
        assertThat(bool).isEqualTo(true);
    }

    @Test
    void 다리_길이를_범위에_맞지_않게_입력받았을_때() {
        // given
        InputView iv = new InputView();
        int num = 33;

        // when
        boolean bool = iv.isBetween3To20(num);

        // then
        assertThat(bool).isEqualTo(false);
    }

    @Test
    void 이동할_칸을_올바르게_입력했을_때() {
        InputView iv = new InputView();
        String moving = "U";

        boolean bool = iv.isValidMoving(moving);

        assertThat(bool).isEqualTo(true);
    }

    @Test
    void 이동할_칸을_올바르지_않게_입력했을_때() {
        InputView iv = new InputView();
        String moving = "A";

        boolean bool = iv.isValidMoving(moving);

        assertThat(bool).isEqualTo(false);
    }
}