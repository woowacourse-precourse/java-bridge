package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CheckExceptionTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    CheckException checkException = new CheckException();
    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void 다리길이_예외처리() {
        assertSimpleTest(() -> {
            checkException.checkBridgeSize("1");
            assertThat(outputStreamCaptor.toString()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 다리이동_예외처리(){
        assertSimpleTest(() -> {
            checkException.checkInputMoving("ㅇ");
            assertThat(outputStreamCaptor.toString()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 재시작입력_예외처리(){
        assertSimpleTest(() -> {
            checkException.checkInputRetryChoice("ㅇ");
            assertThat(outputStreamCaptor.toString()).contains(ERROR_MESSAGE);
        });
    }
}