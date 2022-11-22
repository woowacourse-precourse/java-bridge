package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UsersRouteTest {
    @Test
    void putTest() {
        UsersRoute usersRoute = new UsersRoute();
        usersRoute.put("U");
        usersRoute.put("D");
        Assertions.assertThat(usersRoute.getRoute()).isEqualTo(List.of("U", "D"));
    }
}
