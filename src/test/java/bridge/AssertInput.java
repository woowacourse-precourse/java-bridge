package bridge;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mockStatic;

public class AssertInput {
    private static final Duration INPUT_TEST_TIMEOUT = Duration.ofSeconds(10L);

    public static <T> void assertInputByMockingTest(
            final Executable executable,
            final T value
    ) {
        assertTimeoutPreemptively(INPUT_TEST_TIMEOUT,() -> {
            try (final MockedStatic<Console> mock = mockStatic(Console.class)) {
                mock.when(Console::readLine).thenReturn(value);
                executable.execute();
            }
        });
    }
}
