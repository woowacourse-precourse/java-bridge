package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void recordResult() {
        User user = new User(new ArrayList<>(),new ArrayList<>());
        user.recordResult("O","U");
        assertThat(user.getUpSpace()).isEqualTo(List.of("O"));
    }
}