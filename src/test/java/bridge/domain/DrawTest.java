package bridge.domain;

import bridge.type.DrawType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DrawTest {

    @Test
    void 다리_이동_결과_표시하기_PASS() {
        // given
        Draw draw = new Draw();
        String symbol = DrawType.PASS.getSymbol();
        String blank = " ";

        // when
        draw.drawDownBridges(symbol);

        // then
        assertThat(draw.getDownBridges().get(0)).isEqualTo(symbol);
        assertThat(draw.getUpBridges().get(0)).isEqualTo(blank);
        assertThat(draw.countPassSymbol()).isEqualTo(1);
    }

    @Test
    void 다리_이동_결과_표시하기_MISS() {
        // given
        Draw draw = new Draw();
        String symbol = DrawType.MISS.getSymbol();
        String blank = " ";

        // when
        draw.drawDownBridges(symbol);

        // then
        assertThat(draw.getDownBridges().get(0)).isEqualTo(symbol);
        assertThat(draw.getUpBridges().get(0)).isEqualTo(blank);
        assertThat(draw.countPassSymbol()).isEqualTo(0);
    }
}