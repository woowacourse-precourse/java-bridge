package bridge;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class BridgeGameTest {

    private static final Duration RANDOM_TEST_TIMEOUT = Duration.ofSeconds(10L);

    @Test
    @DisplayName("play")
    void play() {
        BridgeGame bridgeGame = new BridgeGame();
        Player player = new Player();
        String root= "U\nU\nU";
        System.setIn(new ByteArrayInputStream(root.getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        makeRandomBridge(()-> {
            player.makeRightBridge(3);
            bridgeGame.play(player);
        }, 1,1,1);
    }

    @Test
    @DisplayName("PlayerTest.moving 성공하면 성공")
    void move() {
        PlayerTest playerTest = new PlayerTest();
        playerTest.moving();
    }

    @Test
    @DisplayName("실패한 경우 R 입력")
    void retry() {
        BridgeGame bridgeGame = new BridgeGame();
        Player player = new Player();
        String root= "U\nU\nU\nR";
        System.setIn(new ByteArrayInputStream(root.getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        makeRandomBridge(()-> {
            player.makeRightBridge(3);
            player.makeNewPlayerBridge();
            player.moving();
            assertThat(bridgeGame.retry(player)).isTrue();
        }, 1,1,0);
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