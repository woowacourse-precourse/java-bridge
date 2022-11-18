package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeTest {

    @DisplayName("사용자가 이동한 칸이 건너갈 수 있는지 테스트")
    @ParameterizedTest
    @CsvSource({"U,0,true", "U,1,false"})
    void 다리를_건널_수_있는지_테스트(String user, int bridgePosition, Boolean expected) {
        Movement userMovement = Movement.valueOf(user);
        Bridge bridge = new Bridge(new ArrayList<>(Arrays.asList("U", "D", "D")));
        assertThat(bridge.isMoveable(userMovement, bridgePosition)).isEqualTo(expected);
    }
}