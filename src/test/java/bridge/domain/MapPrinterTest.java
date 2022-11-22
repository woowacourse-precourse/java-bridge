package bridge.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MapPrinterTest {

    @Test
    void printMap() {
        String result = "[ O |   ]\n[   | X ]";

        MapPrinter mp = new MapPrinter();
        mp.move(Position.UP, true);
        mp.move(Position.DOWN, false);

        assertThat(mp.printMap()).isEqualTo(result);
    }
}