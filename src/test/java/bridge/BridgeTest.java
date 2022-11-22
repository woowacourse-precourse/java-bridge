package bridge;

import model.Bridge;
import model.Moving;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BridgeTest {

    @ParameterizedTest
    @CsvSource({"0,U,O", "0,D,X", "1,D,O", "1,U,X"})
    void 이동할_칸과_다리의_값을_비교(int index, String input, String result) {
        Bridge bridge = new Bridge(List.of("U", "D"));
        assertThat(bridge.compareTo(index, new Moving(input))).isEqualTo(result);
    }

    @Test
    void 다리_추가() {
        List<String> status = new ArrayList<>();
        status.add("O");
        Bridge bridge = new Bridge(status);
        bridge.addBridge("X");
        assertEquals(2, bridge.getSize());
    }

    @Test
    void 다리_마지막_부분_삭제() {
        List<String> status = new ArrayList<>();
        status.add("O");
        Bridge bridge = new Bridge(status);
        bridge.deleteBridge();
        assertEquals(0, bridge.getSize());
    }
}
