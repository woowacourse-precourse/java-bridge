package bridge;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RestartTest {
    @Test
    void 다리_재시작_입력_예외_테스트() {
        assertThrows(NoSuchElementException.class, () -> new Restart("C"));
    }

    @Test
    void 두번째_예외_테스트() {
            assertThrows(NoSuchElementException.class, () -> new Restart("L"));
        }
}
