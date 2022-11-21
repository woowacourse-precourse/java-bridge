package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Map;
import java.util.List;
import org.junit.jupiter.api.Test;

class MapTest {
    @Test
    void test1Right() {
        Map map = new Map();

        map.update("U", "U");
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[ O ]",
                        "[   ]"));

        map.update("D", "D");
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[ O |   ]",
                        "[   | O ]"));

        map.update("U", "U");
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[ O |   | O ]",
                        "[   | O |   ]"));

        map.update("D", "D");
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[ O |   | O |   ]",
                        "[   | O |   | O ]"));
    }

    @Test
    void test1Wrong() {
        Map map = new Map();

        map.update("U", "U");
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[ O ]",
                        "[   ]"));

        map.update("U", "D");
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[ O | X ]",
                        "[   |   ]"));
    }

    @Test
    void test2Right() {
        Map map = new Map();

        map.update("D", "D");
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[   ]",
                        "[ O ]"));

        map.update("U", "U");
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[   | O ]",
                        "[ O |   ]"));

        map.update("D", "D");
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[   | O |   ]",
                        "[ O |   | O ]"));

        map.update("U", "U");
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[   | O |   | O ]",
                        "[ O |   | O |   ]"));
    }

    @Test
    void test2Wrong() {
        Map map = new Map();

        map.update("D", "D");
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[   ]",
                        "[ O ]"));

        map.update("U", "U");
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[   | O ]",
                        "[ O |   ]"));

        map.update("U", "D");
        assertThat(map.getCurrentMap())
                .isEqualTo(List.of(
                        "[   | O | X ]",
                        "[ O |   |   ]"));
    }
}