package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    static BridgeGame bridgeGame;

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @DisplayName("BridgeGame 클래스 종합 테스트1")
    @Test
    void bridgeGameTest1() {
        List<String> bridge = List.of("U", "D", "U");
        bridgeGame = new BridgeGame(bridge);

        assertSimpleTest(() -> {
            command("D");
            bridgeGame.move();
            bridgeGame.printMap();

            System.out.printf("isEnd 반환값: %b\n", bridgeGame.isEnd());
            System.out.printf("isMoveWrong 반환값: %b\n", bridgeGame.isMoveWrong());

            assertThat(output()).doesNotContain(ERROR_MESSAGE).contains(
                    "[   ]",
                    "[ X ]",
                    "isEnd 반환값: false",
                    "isMoveWrong 반환값: true"
            );

            int upSideIndex = output().indexOf("[   ]");
            int downSideIndex = output().indexOf("[ X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        });
    }

    @DisplayName("BridgeGame 클래스 종합 테스트2")
    @Test
    void bridgeGameTest2() {
        List<String> bridge = List.of("U", "D", "U");
        bridgeGame = new BridgeGame(bridge);

        assertSimpleTest(() -> {
            command("U", "D");
            bridgeGame.move();
            bridgeGame.move();
            bridgeGame.printMap();

            System.out.printf("isEnd 반환값: %b\n", bridgeGame.isEnd());
            System.out.printf("isMoveWrong 반환값: %b\n", bridgeGame.isMoveWrong());

            assertThat(output()).doesNotContain(ERROR_MESSAGE).contains(
                    "[ O |   ]",
                    "[   | O ]",
                    "isEnd 반환값: false",
                    "isMoveWrong 반환값: false"
            );

            int upSideIndex = output().indexOf("[ O |   ]");
            int downSideIndex = output().indexOf("[   | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        });
    }

    @DisplayName("BridgeGame 클래스 종합 테스트3")
    @Test
    void bridgeGameTest3() {
        List<String> bridge = List.of("U", "D", "U");
        bridgeGame = new BridgeGame(bridge);

        assertSimpleTest(() -> {
            command("U", "D", "D");
            bridgeGame.move();
            bridgeGame.move();
            bridgeGame.move();
            bridgeGame.printMap();

            System.out.printf("isEnd 반환값: %b\n", bridgeGame.isEnd());
            System.out.printf("isMoveWrong 반환값: %b\n", bridgeGame.isMoveWrong());

            assertThat(output()).doesNotContain(ERROR_MESSAGE).contains(
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "isEnd 반환값: false",
                    "isMoveWrong 반환값: true"
            );

            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        });
    }

    @DisplayName("BridgeGame 클래스 종합 테스트4")
    @Test
    void bridgeGameTest4() {
        List<String> bridge = List.of("U", "D", "U");
        bridgeGame = new BridgeGame(bridge);

        assertSimpleTest(() -> {
            command("U", "D", "D", "U");
            bridgeGame.move();
            bridgeGame.move();
            bridgeGame.move();
            bridgeGame.retry();
            bridgeGame.printMap();

            System.out.printf("isEnd 반환값: %b\n", bridgeGame.isEnd());
            System.out.printf("isMoveWrong 반환값: %b\n", bridgeGame.isMoveWrong());

            assertThat(output()).doesNotContain(ERROR_MESSAGE).contains(
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "isEnd 반환값: true",
                    "isMoveWrong 반환값: false"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        });
    }

    @Override
    protected void runMain() {}
}