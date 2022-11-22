package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {

    @DisplayName("이동한 칸들을 리스트에 저장하는 기능 성공")
    @Test
    void saveMovingResultToBridgeList() {
        Bridge bridge = new Bridge();
        bridge.setMovingBridge("U", "O");
        List<String> result = bridge.getUpBridge();
        List<String> expect = new ArrayList<>();
        expect.add(" " + "O" + " ");

        assertThat(result).isEqualTo(expect);
    }
}