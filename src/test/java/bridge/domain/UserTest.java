package bridge.domain;

import bridge.domain.user.MoveType;
import bridge.domain.user.User;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class UserTest {

    User user = new User();

    @Test
    @DisplayName("유저의 입력에 따라 다리 건너기 단위 테스트 (모두 건너기 성공)")
    public void crossBridgeTest() {
        Bridge bridge = Bridge.initBridge(List.of("U", "D", "D"));
        List<MoveType> moveTypes = List.of(MoveType.UP_TYPE, MoveType.DOWN_TYPE, MoveType.DOWN_TYPE);

        for (MoveType moveType : moveTypes) {
            user.cross(bridge, moveType);
        }

        String result = user.getUserPathLog();
        Assertions.assertThat(result).isEqualTo("[ O |   |   ]\n[   | O | O ]\n");
    }

    @Test
    @DisplayName("다리 건너기에 실패 했을 때 경로 초기화 확인")
    public void crossBridgeFailTest() {
        Bridge bridge = Bridge.initBridge(List.of("U", "D", "D", "U"));
        List<MoveType> moveTypes = List.of(MoveType.UP_TYPE, MoveType.DOWN_TYPE, MoveType.DOWN_TYPE, MoveType.DOWN_TYPE);

        for (MoveType moveType : moveTypes) {
            user.cross(bridge, moveType);
        }

        String beforeResult = user.getUserPathLog();
        Assertions.assertThat(beforeResult).isEqualTo("[ O |   |   |   ]\n[   | O | O | X ]\n");

        user.resetUserData();

        String afterResult = user.getUserPathLog();
        Assertions.assertThat(afterResult).isEqualTo("[  ]\n[  ]\n");
    }

}
