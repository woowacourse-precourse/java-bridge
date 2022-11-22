package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.domain.User;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    private static final int BRIDGE_SIZE = 19;
    private static final List<String> USER_MOVING = List.of("U", "D", "D", "U");

    @DisplayName("문자열로 입력한 다리의 크기가 정수 자료형으로 정확히 저장이 되는지 테스트")
    @Test
    void checkUserInputBridgeSize() {
        User.setBridgeSize("19");
        int bridgeSize = User.getBridgeSize();
        assertThat(bridgeSize).isEqualTo(BRIDGE_SIZE);
    }

    @DisplayName("이동할 칸에 대한 입력이 정확히 저장 되는지 테스트")
    @Test
    void checkUserInputMovingCommand() {
        User user = new User();

        User.recordUserMoving("U");
        User.recordUserMoving("D");
        User.recordUserMoving("D");
        User.recordUserMoving("U");

        List<String> userMoving = User.getUserMovingRecord();
        assertThat(userMoving).isEqualTo(USER_MOVING);
    }

}
