package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserResultTest {

    @Test
    void recordResult() {
        UserResult userResult = new UserResult(new ArrayList<>(),new ArrayList<>());
        userResult.recordResult("O","U");
        assertThat(userResult.getUpSpace()).isEqualTo(List.of("O"));
    }
}