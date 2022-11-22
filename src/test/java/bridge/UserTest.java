package bridge;

import bridge.domain.Bridge;
import bridge.domain.User;
import bridge.util.BridgeBlock;
import bridge.util.BridgePosition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @DisplayName("이동에 성공했으면 true를 반환한다")
    @Test
    void moveSuccess() {
        User user = new User(new Bridge(List.of("D", "U", "D")));

        boolean move = user.move("D");

        assertThat(move).isEqualTo(true);
    }

    @DisplayName("이동에 실패했으면 false를 반환한다")
    @Test
    void moveFail() {
        User user = new User(new Bridge(List.of("D", "U", "D")));

        boolean move = user.move("U");

        assertThat(move).isEqualTo(false);
    }

    @DisplayName("이동에 성공하면 이동 위치가 올라간다")
    @Test
    void getUserPointByMoveSuccess() {
        User user = new User(new Bridge(List.of("D", "U", "D")));

        user.move("D");

        assertThat(user.getUserPoint()).isEqualTo(1);
    }

    @DisplayName("재시작을 하면 이동이 초기화된다")
    @Test
    void retry() {
        User user = new User(new Bridge(List.of("D", "U", "D")));

        user.move("U");
        user.retry();

        assertThat(user.getUserPoint()).isEqualTo(0);
    }

    @DisplayName("다리 위치와 순서를 입력하면 해당 블록 결과를 가져온다")
    @Test
    void getMovementInUpBridge() {
        User user = new User(new Bridge(List.of("D", "U", "D")));

        user.move("U");
        user.move("U");

        assertThat(user.getBlockResult(BridgePosition.UP, 1)).isEqualTo(BridgeBlock.SUCCESS_MOVED.getBlock());
    }

    @DisplayName("유저가 다리의 마지막 위치면 true를 반환한다.")
    @Test
    void isFinished() {
        User user = new User(new Bridge(List.of("D", "U", "D")));;

        user.move("D");
        user.move("U");
        user.move("D");

        assertThat(user.isEndPoint()).isEqualTo(true);
    }

    @DisplayName("유저가 다리의 마지막 위치가 아니면 false를 반환한다")
    @Test
    void isNotFinished() {
        User user = new User(new Bridge(List.of("D", "U", "D")));

        user.move("D");
        user.move("U");

        assertThat(user.isEndPoint()).isEqualTo(false);
    }
}
