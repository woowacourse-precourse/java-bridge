package bridge;

import exception.BridgeException;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

public class BridgeExceptionTest {
    @Test
    void 입력_받은_값이_숫자가_아닌_경우() {
        assertThatThrownBy(() -> new BridgeException("abc"))
                .isInstanceOf(NoSuchElementException.class );
    }

    @Test
    void 입력_받은_값이_범위에_해당하지_않는_경우() {
        assertThatThrownBy(() -> new BridgeException("2"))
                .isInstanceOf(IllegalArgumentException.class );

        assertThatThrownBy(() -> new BridgeException("123"))
                .isInstanceOf(IllegalArgumentException.class );
    }
}
