package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import java.util.List;

public class UserMapTest {
    @Test
    void 유저맵_생성_테스트() {
        UserMap userMap = new UserMap();
        userMap.buildUserMap(List.of("U", "D", "D"));
        assertThat(userMap.getUserMap()).
                isEqualTo(List.of(
                        List.of("O", " "),
                        List.of(" ", "O"),
                        List.of(" ", "O")
                ));
    }

    @Test
    void 유저맵_업데이트_테스트() {
        UserMap userMap = new UserMap();
        userMap.buildUserMap(List.of("U", "D", "D"));
        userMap.updateUserMap(1, false);
        assertThat(userMap.getUserMap()).
                isEqualTo(List.of(
                        List.of("O", " "),
                        List.of(" ", "X"),
                        List.of(" ", "O")
                ));
    }
}