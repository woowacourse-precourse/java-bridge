package bridge.serviceImpl;

import bridge.service.GameService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ExceptionGameServiceImplTest {

    private static final String EXCEPTION_CATCH = "[ERROR] 예외 처리 테스트";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void 예외_처리_메시지_테스트() {
        // given
        String expect = EXCEPTION_CATCH;
        GameService gameService = new ExceptionGameServiceImpl(() -> {
            throw new StackOverflowError(EXCEPTION_CATCH);
        });

        // when
        gameService.startGame();

        // when, then
        assertThat(EXCEPTION_CATCH).isEqualTo(expect);
    }
}
