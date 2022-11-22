package bridge;

import camp.nextstep.edu.missionutils.Randoms;
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

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class PlayerTest {

    private static final Duration RANDOM_TEST_TIMEOUT = Duration.ofSeconds(10L);

    @Test
    @DisplayName("플레이어의 다리 생성")
    void makeNewPlayerBridge() {
        Player player = new Player();
        player.makeNewPlayerBridge();
        assertThat(player.findPlayerBridge()).isNotNull();
    }


    @Test
    @DisplayName("")
    void makeRightBridge() {
    }


    @Test
    @DisplayName("코인 사용")
    void useCoin() {
        Player player = new Player();
        player.useCoin();
        assertThat(player.findCoinUsed()).isEqualTo(1);
    }

    @Test
    @DisplayName("올바른 경로가 UUD 일 경우 입력은 UUU 했을 때")
    void moving() {
        Player player = new Player();
        String root= "U\nU\nU";
        System.setIn(new ByteArrayInputStream(root.getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        makeRandomBridge(()-> {
            player.makeRightBridge(3);
            player.makeNewPlayerBridge();
            player.moving();
            assertThat(out.toString()).contains("[ O | O | X ]");
        }, 1,1,0);
    }

    @Test
    @DisplayName("플레이어가 갖고 있는 다리가 실패했을 경우")
    void fail() {
        Player player = new Player();
        String root= "U\nU\nU";
        System.setIn(new ByteArrayInputStream(root.getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        makeRandomBridge(()-> {
            player.makeRightBridge(3);
            player.makeNewPlayerBridge();
            player.moving();
            assertThat(player.fail()).isTrue();
        }, 1,1,0);
    }

    @Test
    @DisplayName("플레이어가 갖고 있는 다리가 성공했을 경우")
    void success() {
        Player player = new Player();
        String root= "U\nU\nU";
        System.setIn(new ByteArrayInputStream(root.getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        makeRandomBridge(()-> {
            player.makeRightBridge(3);
            player.makeNewPlayerBridge();
            player.moving();
            assertThat(player.success()).isTrue();
        }, 1,1,1);
    }

    @Test
    @DisplayName("플레이어가 갖고 있는 이동한 다리를 가져온다.")
    void getPlayerBridge() {
        Player player = new Player();
        assertThat(player.findPlayerBridge()).isInstanceOf(PlayerBridge.class);
    }

    @Test
    @DisplayName("플레이어가 사용한 코인을 가져온다.")
    void getCoinUsed() {
        Player player = new Player();
        assertThat(player.findCoinUsed()).isInstanceOf(int.class);
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