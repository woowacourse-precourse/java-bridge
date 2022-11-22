package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserPathTest {

    @DisplayName("사용자 이동 경로에 이동한 경로가 추가되는지 검증한다.")
    @Test
    void move() {
        UserPath userPath = new UserPath();
        userPath.move("U");
        userPath.move("D");

        int size = userPath.size();

        assertThat(size).isEqualTo(2);
    }

    @DisplayName("초기화 메서드를 검증한다.")
    @Test
    void initialize() {
        UserPath userPath = new UserPath();
        userPath.move("U");
        userPath.move("D");

        userPath.initialize();
        int size = userPath.size();

        assertThat(size).isEqualTo(0);
    }

    @DisplayName("find 메서드가 해당 위치의 문자를 반환하는지 검증한다.")
    @Test
    void find() {
        UserPath userPath = new UserPath();
        userPath.move("U");
        userPath.move("D");

        String up = userPath.find(0);
        String down = userPath.find(1);

        assertThat(up).isEqualTo("U");
        assertThat(down).isEqualTo("D");
    }

}