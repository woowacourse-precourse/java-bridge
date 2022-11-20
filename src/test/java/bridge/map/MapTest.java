package bridge.map;

import bridge.input.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MapTest {

    private Map map;
    private String up;
    private String down;

    @BeforeEach
    void setUp() {
        map = new Map();
        up = Command.UP.getLetter();
        down = Command.DOWN.getLetter();
    }

    @Test
    void 위로_건넜을때_테스트() {
        map.addCrossing(up);
        String expected = "[ O ]\n[   ]";
        assertThat(map.toString()).isEqualTo(expected);
    }

    @Test
    void 아래로_건넜을때_테스트() {
        map.addCrossing(down);
        String expected = "[   ]\n[ O ]";
        assertThat(map.toString()).isEqualTo(expected);
    }

    @Test
    void 위로_건너지_못했을때_테스트() {
        map.addNoCrossing(up);
        String expected = "[ X ]\n[   ]";
        assertThat(map.toString()).isEqualTo(expected);
    }

    @Test
    void 아래로_건너지_못했을때_테스트() {
        map.addNoCrossing(down);
        String expected = "[   ]\n[ X ]";
        assertThat(map.toString()).isEqualTo(expected);
    }

    @Test
    void 포맷_2개_테스트() {
        map.addCrossing(up);
        map.addNoCrossing(up);
        String expected = "[ O | X ]\n[   |   ]";
        assertThat(map.toString()).isEqualTo(expected);
    }

    @Test
    void 포맷_3개_테스트() {
        map.addCrossing(up);
        map.addCrossing(down);
        map.addCrossing(down);
        String expected = "[ O |   |   ]\n[   | O | O ]";
        assertThat(map.toString()).isEqualTo(expected);
    }
}