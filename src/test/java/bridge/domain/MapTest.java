package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class MapTest {
    @Test
    void test1Right() {
        Map map = new Map();

        map.update("U", true);
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[ O ]",
                        "[   ]"));

        map.update("D", true);
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[ O |   ]",
                        "[   | O ]"));

        map.update("U", true);
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[ O |   | O ]",
                        "[   | O |   ]"));

        map.update("D", true);
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[ O |   | O |   ]",
                        "[   | O |   | O ]"));
    }

    @Test
    void test1Wrong() {
        Map map = new Map();

        map.update("U", true);
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[ O ]",
                        "[   ]"));

        map.update("U", false);
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[ O | X ]",
                        "[   |   ]"));
    }

    @Test
    void test2Right() {
        Map map = new Map();

        map.update("D", true);
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[   ]",
                        "[ O ]"));

        map.update("U", true);
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[   | O ]",
                        "[ O |   ]"));

        map.update("D", true);
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[   | O |   ]",
                        "[ O |   | O ]"));

        map.update("U", true);
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[   | O |   | O ]",
                        "[ O |   | O |   ]"));
    }

    @Test
    void test2Wrong() {
        Map map = new Map();

        map.update("D", true);
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[   ]",
                        "[ O ]"));

        map.update("U", true);
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[   | O ]",
                        "[ O |   ]"));

        map.update("U", false);
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[   | O | X ]",
                        "[ O |   |   ]"));
    }
}