package bridge;

import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class CustomNsTest {
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    /**
     * 스트림을 초기화 한 후 부터 출력된 문자를 반환하는 메소드
     */
    protected final String output() {
        String tmpCaptor = captor.toString().trim();
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        return tmpCaptor;
    }

    /**
     * 테스트에 사용될 사용자가 입력할 임의의 값을 입력 스트림 넣는 메소드
     */
    protected void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
