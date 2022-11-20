package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class MapTest {
    @Test
    void test1Right() {
        Map map = new Map(List.of("U", "D", "U", "D"));

        map.update("U");
        assertThat(map.getPath("U")).isEqualTo("[ O ]");
        assertThat(map.getPath("D")).isEqualTo("[   ]");

        map.update("D");
        assertThat(map.getPath("U")).isEqualTo("[ O |   ]");
        assertThat(map.getPath("D")).isEqualTo("[   | O ]");

        map.update("U");
        assertThat(map.getPath("U")).isEqualTo("[ O |   | O ]");
        assertThat(map.getPath("D")).isEqualTo("[   | O |   ]");

        map.update("D");
        assertThat(map.getPath("U")).isEqualTo("[ O |   | O |   ]");
        assertThat(map.getPath("D")).isEqualTo("[   | O |   | O ]");
    }

    @Test
    void test1Wrong() {
        Map map = new Map(List.of("U", "D", "U", "D"));

        map.update("U");
        assertThat(map.getPath("U")).isEqualTo("[ O ]");
        assertThat(map.getPath("D")).isEqualTo("[   ]");

        map.update("U");
        assertThat(map.getPath("U")).isEqualTo("[ O | X ]");
        assertThat(map.getPath("D")).isEqualTo("[   |   ]");
    }

    @Test
    void test2Right() {
        Map map = new Map(List.of("D", "U", "D", "U"));

        map.update("D");
        assertThat(map.getPath("U")).isEqualTo("[   ]");
        assertThat(map.getPath("D")).isEqualTo("[ O ]");

        map.update("U");
        assertThat(map.getPath("U")).isEqualTo("[   | O ]");
        assertThat(map.getPath("D")).isEqualTo("[ O |   ]");

        map.update("D");
        assertThat(map.getPath("U")).isEqualTo("[   | O |   ]");
        assertThat(map.getPath("D")).isEqualTo("[ O |   | O ]");

        map.update("U");
        assertThat(map.getPath("U")).isEqualTo("[   | O |   | O ]");
        assertThat(map.getPath("D")).isEqualTo("[ O |   | O |   ]");
    }

    @Test
    void test2Wrong() {
        Map map = new Map(List.of("D", "U", "D", "U"));

        map.update("D");
        assertThat(map.getPath("U")).isEqualTo("[   ]");
        assertThat(map.getPath("D")).isEqualTo("[ O ]");

        map.update("U");
        assertThat(map.getPath("U")).isEqualTo("[   | O ]");
        assertThat(map.getPath("D")).isEqualTo("[ O |   ]");

        map.update("U");
        assertThat(map.getPath("U")).isEqualTo("[   | O | X ]");
        assertThat(map.getPath("D")).isEqualTo("[ O |   |   ]");
    }
}