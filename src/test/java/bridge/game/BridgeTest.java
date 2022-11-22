package bridge.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    void testBasicConstruct() {
        Bridge bridge = new Bridge();

        assertThat(bridge.size()).isEqualTo(0);
    }

    @Test
    void testInitializeConstruct() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));

        assertThat(bridge.size()).isEqualTo(3);
    }

    @Test
    void testInitializeConstructException() {
        assertThatThrownBy(() -> new Bridge(List.of("E", "X", "P")))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void size() {
        Bridge bridge = new Bridge(List.of("U", "D", "D", "D"));
        assertThat(bridge.size()).isEqualTo(4);

        bridge.updateLowerWrong();
        assertThat(bridge.size()).isEqualTo(5);
    }

    @Test
    void getDirectionAt() {
        Bridge bridge = new Bridge(List.of("U", "D", "D", "U"));

        assertThat(bridge.getDirectionAt(0)).isEqualTo("U");
        assertThat(bridge.getDirectionAt(1)).isEqualTo("D");
        assertThat(bridge.getDirectionAt(2)).isEqualTo("D");
        assertThat(bridge.getDirectionAt(3)).isEqualTo("U");
    }

    @Test
    void getDirectionAtException() {
        Bridge bridge = new Bridge(List.of("U", "D", "D", "U"));

        assertThatThrownBy(() -> bridge.getDirectionAt(-1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> bridge.getDirectionAt(5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void updateUpperCorrect() {
        Bridge bridge = new Bridge();
        bridge.updateUpperCorrect();

        assertThat(bridge.size()).isEqualTo(1);
        assertThat(bridge.getDirectionAt(0)).isEqualTo("U");
        assertThat(bridge.getUpper()).isEqualTo(List.of("O"));
        assertThat(bridge.getLower()).isEqualTo(List.of(" "));
    }

    @Test
    void updateUpperWrong() {
        Bridge bridge = new Bridge();
        bridge.updateUpperWrong();

        assertThat(bridge.size()).isEqualTo(1);
        assertThat(bridge.getDirectionAt(0)).isEqualTo("U");
        assertThat(bridge.getUpper()).isEqualTo(List.of("X"));
        assertThat(bridge.getLower()).isEqualTo(List.of(" "));
    }

    @Test
    void updateLowerCorrect() {
        Bridge bridge = new Bridge();
        bridge.updateLowerCorrect();

        assertThat(bridge.size()).isEqualTo(1);
        assertThat(bridge.getDirectionAt(0)).isEqualTo("D");
        assertThat(bridge.getUpper()).isEqualTo(List.of(" "));
        assertThat(bridge.getLower()).isEqualTo(List.of("O"));
    }

    @Test
    void updateLowerWrong() {
        Bridge bridge = new Bridge();
        bridge.updateLowerWrong();

        assertThat(bridge.size()).isEqualTo(1);
        assertThat(bridge.getDirectionAt(0)).isEqualTo("D");
        assertThat(bridge.getUpper()).isEqualTo(List.of(" "));
        assertThat(bridge.getLower()).isEqualTo(List.of("X"));
    }

    @Test
    void getUpper() {
        Bridge bridge = new Bridge(List.of("U", "D", "D", "U"));

        assertThat(bridge.getUpper()).isEqualTo(List.of("O", " ", " ", "O"));
    }

    @Test
    void getLower() {
        Bridge bridge = new Bridge(List.of("U", "D", "D", "U"));

        assertThat(bridge.getLower()).isEqualTo(List.of(" ", "O", "O", " "));
    }

    @Test
    void clear() {
        Bridge bridge = new Bridge(List.of("U", "D", "D", "U"));
        bridge.clear();

        assertThat(bridge.size()).isEqualTo(0);
    }
}