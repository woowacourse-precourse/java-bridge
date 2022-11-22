package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    @DisplayName("생성자 테스트")
    @Test
    public void userConstructorAndGetterTest() {
        // given
        int count = 1;
        boolean quit = false;

        // when
        User user = new User();

        // then
        assertThat(user.getPlayCount()).isEqualTo(count);
        assertThat(user.getQuit()).isEqualTo(quit);
    }

    @DisplayName("setQuit 테스트")
    @Test
    public void setQuitTest() {
        // given
        boolean quit = true;
        User user = new User();

        // when
        user.setQuit();

        // then
        assertThat(user.getQuit()).isEqualTo(quit);
    }

    @DisplayName("addPlayCount 테스트")
    @Test
    public void addPlayCountTest() {
        // given
        int count = 2;
        User user = new User();

        // when
        user.addPlayCount();

        // then
        assertThat(user.getPlayCount()).isEqualTo(count);
    }
}

