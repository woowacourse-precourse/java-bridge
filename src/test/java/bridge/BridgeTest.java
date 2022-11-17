package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.Bridge.getSymbol;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeTest {
    @Test
    void getSymbol_테스트() {
        assertThat(getSymbol(1)).isEqualTo("U");
        assertThat(getSymbol(0)).isEqualTo("D");
    }
}
