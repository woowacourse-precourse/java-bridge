package bridge.enums;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeShapeTest {

    @Test
    void 이동_가능하면_다음_칸_모양_O() {
        boolean canMove = true;
        String nextShape = BridgeShape.getNextShape(canMove);

        assertThat(nextShape).isEqualTo(" O ");
    }

    @Test
    void 이동_불가능하면_다음_칸_모양_X() {
        boolean canMove = false;
        String nextShape = BridgeShape.getNextShape(canMove);

        assertThat(nextShape).isEqualTo(" X ");
    }
}