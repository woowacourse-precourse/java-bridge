package bridge.domain.bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    @DisplayName("다리를 생성할 때, 다리모양숫자들에 맞게 다리가 생성된다.")
    void checkBridgeShapeTest() {
        //given
        List<String> bridgeShapeNumbers = List.of("0", "1");

        //when
        Bridge bridge = new Bridge(bridgeShapeNumbers);

        //then
        List<String> generatedBridge = bridge.getBridge();
        assertThat(generatedBridge.get(0)).isEqualTo("D");
        assertThat(generatedBridge.get(1)).isEqualTo("U");
    }

    @Test
    @DisplayName("플레이어가 선택한 이동칸이 다리모양과 일치하면 건널 수 있다.")
    void isPassableTest1() {
        //given
        Bridge bridge = new Bridge(List.of("0", "1", "1"));
        int uerLocation = 2;
        String userSelection = "U";

        //when
        boolean passableResult = bridge.isPassable(uerLocation, userSelection);

        //then
        assertThat(passableResult).isEqualTo(true);

    }

    @Test
    @DisplayName("플레이어가 선택한 이동칸이 다리모양과 일치하지 않으면 건널 수 없다.")
    void isPassableTest2() {
        //given
        Bridge bridge = new Bridge(List.of("0", "1", "1"));
        int uerLocation = 2;
        String userSelection = "D";

        //when
        boolean passableResult = bridge.isPassable(uerLocation, userSelection);

        //then
        assertThat(passableResult).isEqualTo(false);

    }
}
