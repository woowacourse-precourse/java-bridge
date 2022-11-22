package bridge.domain.bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    private static final Bridge bridge = new Bridge(List.of("D", "U", "U"));
    private static final int USER_LOCATION = 2;

    @Test
    @DisplayName("플레이어가 선택한 이동칸이 다리모양과 일치하면 건널 수 있다.")
    void isPassableTest1() {
        //given
        String userSelection = "U";

        //when
        boolean passableResult = bridge.isPassable(USER_LOCATION, userSelection);

        //then
        assertThat(passableResult).isEqualTo(true);

    }

    @Test
    @DisplayName("플레이어가 선택한 이동칸이 다리모양과 일치하지 않으면 건널 수 없다.")
    void isPassableTest2() {
        //given
        String userSelection = "D";

        //when
        boolean passableResult = bridge.isPassable(USER_LOCATION, userSelection);

        //then
        assertThat(passableResult).isEqualTo(false);

    }
}
