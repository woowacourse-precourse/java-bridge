package bridge.domain;

import bridge.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @DisplayName("유저가 선택한 위치와(U or D) 가능 여부를 입력하면 해당 위치에 저장한다.")
    @Test
    void recordResult() {
        User user = new User(new ArrayList<>(),new ArrayList<>());
        user.recordResult("O","U");
        assertThat(user.getUpSpace()).isEqualTo(List.of("O"));
        assertThat(user.getDownSpace()).isEqualTo(List.of(" "));
    }

    @DisplayName("유저가 이동할 위치가 건널 수 없는 다리이면 'X'를 반환한다.")
    @Test
    void movePositionCase1() {
        User user = UserService.generateUser();
        List<String> bridge = List.of("U","U","D");
        assertThat(user.movePosition(bridge,"D")).isEqualTo("X");
    }

    @DisplayName("유저가 이동할 위치가 건널 수 있는 다리이면 'O'를 반환한다.")
    @Test
    void movePositionCase2() {
        User user = UserService.generateUser();
        List<String> bridge = List.of("U","U","D");
        assertThat(user.movePosition(bridge,"U")).isEqualTo("O");
    }
}