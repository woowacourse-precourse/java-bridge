package bridge;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class BridgeMakerTest {

    private static final Duration RANDOM_TEST_TIMEOUT = Duration.ofSeconds(10L);


    @Test
    @DisplayName("랜덤으로 다리 만들기")
    void makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        makeRandomBridge(()->{
            List<String> bridge = bridgeMaker.makeBridge(3);
            assertThat(bridge).isEqualTo(List.of("D","D","U"));
        },0,0,1);

    }

    public static void makeRandomBridge(
            final Executable executable,
            final Integer value,
            final Integer... values
    ) {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                executable,
                value,
                values
        );
    }

    private static <T> void assertRandomTest(
            final MockedStatic.Verification verification,
            final Executable executable,
            final T value,
            final T... values
    ) {
        assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT, () -> {
            try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
                mock.when(verification).thenReturn(value, Arrays.stream(values).toArray());
                executable.execute();
            }
        });
    }
}