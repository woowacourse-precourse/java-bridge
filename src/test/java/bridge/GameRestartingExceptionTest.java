package bridge;

import exception.MovingException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameRestartingExceptionTest {
    @Test
    void 입력_받은_값이_RQ가_아닌_경우() {
        assertThatThrownBy(() -> new MovingException("T"))
                .isInstanceOf(IllegalArgumentException.class );
    }
}
