package bridge;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class MoveBridgeTest {
    @Test
    void 다리_이동할_칸_입력_예외_테스트() {
        assertThrows(NoSuchElementException.class, () -> new MoveBridge("A"));
    }
}
