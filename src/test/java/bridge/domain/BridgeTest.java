package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {

    @DisplayName("index로 Bridge값 얻기")
    @Test
    void getBridgeByIndex() {
        // given
        String str = "U";
        List<String> arr = new ArrayList<>();
        arr.add(str);
        Bridge bridge = new Bridge(arr);

        // when

        // then
        assertThat(bridge.getBridgeByIndex(0)).isEqualTo(str);
    }

    @DisplayName("Bridge size 얻기")
    @Test
    void getBridgeSize() {
        // given
        String str = "U";
        List<String> arr = new ArrayList<>();
        arr.add(str);
        Bridge bridge = new Bridge(arr);

        // when

        // then
        assertThat(bridge.getBridgeSize()).isEqualTo(1);
    }
}
