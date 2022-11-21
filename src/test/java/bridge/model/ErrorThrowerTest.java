package bridge.model;

import static bridge.model.ErrorThrower.ERROR_BRIDGE_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class ErrorThrowerTest {

    @Test
    void throwError() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThatCode(() -> ErrorThrower.throwError(ERROR_BRIDGE_SIZE)).doesNotThrowAnyException();
        assertThat(out.toString()).contains(ERROR_BRIDGE_SIZE);
    }
}
