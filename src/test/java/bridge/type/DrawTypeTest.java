package bridge.type;

import bridge.domain.Draw;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DrawTypeTest {

    @Test
    void 위칸_다리를_건넜을때_통과된다면_O을_표시하라() {
        // given
        Draw draw = new Draw();
        PositionType up = PositionType.UP;
        String blank = " ";
        boolean isPass = true;

        // when
        DrawType.PASS.draw(up, isPass, draw);

        // then
        assertThat(draw.getUpBridges().get(0)).isEqualTo(DrawType.PASS.getSymbol());
        assertThat(draw.getDownBridges().get(0)).isEqualTo(blank);
    }

    @Test
    void 위칸_다리를_건넜을때_통과되지_않는다면_X을_표시하라() {
        // given
        Draw draw = new Draw();
        PositionType up = PositionType.UP;
        String blank = " ";
        boolean isPass = false;

        // when
        DrawType.MISS.draw(up, isPass, draw);

        // then
        assertThat(draw.getUpBridges().get(0)).isEqualTo(DrawType.MISS.getSymbol());
        assertThat(draw.getDownBridges().get(0)).isEqualTo(blank);
    }
}