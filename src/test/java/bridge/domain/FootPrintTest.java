package bridge.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FootPrintTest {

    @Test
    void 정상_생성() {
        FootPrint footPrint = new FootPrint();
        Assertions.assertThat(footPrint.getOrder()).isEqualTo(0);
    }

    @Test
    void 정상_움직이는게_저장() {
        FootPrint footPrint = new FootPrint();
        footPrint.record(FootrestLocation.UP, true);
        Assertions.assertThat(footPrint.getOrder()).isEqualTo(1);
        footPrint.record(FootrestLocation.DOWN, true);
        Assertions.assertThat(footPrint.getOrder()).isEqualTo(2);
        footPrint.record(FootrestLocation.DOWN, true);
        Assertions.assertThat(footPrint.getOrder()).isEqualTo(3);
    }

    @Test
    void 예외_null_입력() {
        FootPrint footPrint = new FootPrint();
        Assertions.assertThatThrownBy(() -> footPrint.record(null, true)).isInstanceOf(IllegalStateException.class);
    }
}