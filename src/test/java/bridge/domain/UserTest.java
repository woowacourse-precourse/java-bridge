package bridge.domain;

import bridge.domain.user.MoveType;
import bridge.domain.user.User;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    User user;

    @BeforeEach
    void setUp() {
        user = new User();
        Assertions.assertThat(user).isNotNull();
    }

    @Test
    @DisplayName("유저의 입력에 따라 다리 건너기 단위 테스트 (모두 건너기 성공)")
    public void crossBridgeTest() {
        Bridge bridge = Bridge.initBridge(List.of("U", "D", "D"));
        List<MoveType> moveTypes = List.of(MoveType.UP_TYPE, MoveType.DOWN_TYPE, MoveType.DOWN_TYPE);

        for (MoveType moveType : moveTypes) {
            user.cross(bridge, moveType);
        }

        String result = user.getUserPathLog();
        Assertions.assertThat(result).isEqualTo("[ O |   |   ]\n[   | O | O ]\n\n");
    }

    @Test
    @DisplayName("다리 건너기에 실패 했을 때 경로 초기화 확인")
    public void crossBridgeFailTest() {
        Bridge bridge = Bridge.initBridge(List.of("U", "D", "D", "U"));
        List<MoveType> moveTypes = List.of(MoveType.UP_TYPE, MoveType.DOWN_TYPE, MoveType.DOWN_TYPE,
            MoveType.DOWN_TYPE);

        for (MoveType moveType : moveTypes) {
            user.cross(bridge, moveType);
        }

        String beforeResult = user.getUserPathLog();
        Assertions.assertThat(beforeResult).isEqualTo("[ O |   |   |   ]\n[   | O | O | X ]\n\n");

        user.resetUserData();

        String afterResult = user.getUserPathLog();
        Assertions.assertThat(afterResult).isEqualTo("[  ]\n[  ]\n\n");
    }

    @Test
    @DisplayName("유저 위치 증가 테스트")
    public void increasePositionTest() {
        Bridge bridge = Bridge.initBridge(List.of("U", "D", "D", "U"));
        List<MoveType> moveTypes = List.of(MoveType.UP_TYPE, MoveType.DOWN_TYPE, MoveType.DOWN_TYPE);

        for (MoveType moveType : moveTypes) {
            user.cross(bridge, moveType);
        }

        Assertions.assertThat(user).extracting("nextLocation").isEqualTo(3);
    }

    @Test
    @DisplayName("시도 횟수 증가 테스트")
    public void increaseTryCountTest() {

        for (int i = 0; i < 9; i++) {
            user.resetUserData();
            Assertions.assertThat(user).extracting("tryCount").isEqualTo(i + 2);
        }
    }

    @Test
    @DisplayName("다리 건너기 성공 테스트")
    public void isCrossSuccessTest() {
        Bridge bridge = Bridge.initBridge(List.of("U", "D", "D", "U"));
        List<MoveType> moveTypes = List.of(MoveType.UP_TYPE, MoveType.DOWN_TYPE, MoveType.DOWN_TYPE, MoveType.UP_TYPE);

        for (MoveType moveType : moveTypes) {
            user.cross(bridge, moveType);
        }

        Assertions.assertThat(user.isFinish(bridge.getBridgeEnd())).isTrue();
    }

}
