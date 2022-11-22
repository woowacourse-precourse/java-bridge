package bridge.bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    public void bridgeSizeTest() throws Exception {
        // given
        List<String> state = new ArrayList<>(Arrays.asList("U", "D", "U", "D", "D"));
        Bridge bridge = new Bridge(state);

        // when
        int size = bridge.size();

        // then
        assertThat(size).isEqualTo(5);
    }

    @Test
    public void bridgeGetSuccessTest() throws Exception {
        // given
        List<String> state = new ArrayList<>(Arrays.asList("U", "D", "U", "D", "D"));
        Bridge bridge = new Bridge(state);

        // when
        String s1 = bridge.get(0);
        String s2 = bridge.get(1);
        String s3 = bridge.get(2);
        String s4 = bridge.get(3);
        String s5 = bridge.get(4);

        // then
        assertThat(s1).isEqualTo("U");
        assertThat(s2).isEqualTo("D");
        assertThat(s3).isEqualTo("U");
        assertThat(s4).isEqualTo("D");
        assertThat(s5).isEqualTo("D");
    }

    @Test
    public void bridgeGetFailTest() throws Exception {
        // given
        List<String> state = new ArrayList<>(Arrays.asList("U", "D", "U", "D", "D"));
        Bridge bridge = new Bridge(state);

        // when

        // then
        assertThatThrownBy(() -> bridge.get(5)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void bridgeAddTest() throws Exception {
        // given
        List<String> state = new ArrayList<>(Arrays.asList("U", "D", "U", "D", "D"));
        Bridge bridge = new Bridge(state);

        // when
        bridge.add("U");

        // then
        assertThat(bridge.get(5)).isEqualTo("U");
        assertThat(bridge.size()).isEqualTo(6);
    }

    @Test
    public void clear() throws Exception {
        // given
        List<String> state = new ArrayList<>(Arrays.asList("U", "D", "U", "D", "D"));
        Bridge bridge = new Bridge(state);

        // when
        bridge.clear();

        // then
        assertThat(bridge.size()).isEqualTo(0);
    }
}