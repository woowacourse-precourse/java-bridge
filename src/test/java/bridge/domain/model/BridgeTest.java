package bridge.domain.model;

import static org.assertj.core.api.Assertions.assertThat;


import bridge.domain.enums.Move;
import bridge.domain.model.Bridge;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    @DisplayName("입력값이 맞는길인지 확인하는 테스트")
    void isCorrectWay() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        assertThat(bridge.isCorrectWay(Move.U,0)).isEqualTo(true);
    }


}