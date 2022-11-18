package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("발판")
public class FloorTest {

    @Test
    void 이동가능_여부를_알_수_있다() {
        Floor floor = new Floor(true);

        assertThat(floor.isFirm()).isTrue();
    }
}
