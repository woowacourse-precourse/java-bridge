package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    static BridgeGame bridgeGame;

    @DisplayName("BridgeGame 클래스 종합 테스트")
    @Test
    void bridgeGameTest() {
        assertSimpleTest(() -> {
            run("U", "D", "D", "U");
            assertThat(output()).doesNotContain(ERROR_MESSAGE).contains(
                    "[ O ]",
                    "[   ]",
                    "#1 isEnd 반환값: false",
                    "#1 isMoveWrong 반환값: false",
                    "[ O |   ]",
                    "[   | O ]",
                    "#2 isEnd 반환값: false",
                    "#2 isMoveWrong 반환값: false",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "#3 isEnd 반환값: false",
                    "#3 isMoveWrong 반환값: true",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "#4 isEnd 반환값: true",
                    "#4 isMoveWrong 반환값: false",
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1000000"
            );
        });
    }

    @Override
    protected void runMain() {
        List<String> bridge = List.of("U", "D", "U");
        bridgeGame = new BridgeGame(bridge);

        int numberOfMove = 1;
        int numberOfTry = 1_000_000;

        bridgeGame.move();
        bridgeGame.printMap();
        System.out.printf("#%d isEnd 반환값: %b\n", numberOfMove, bridgeGame.isEnd());
        System.out.printf("#%d isMoveWrong 반환값: %b\n", numberOfMove, bridgeGame.isMoveWrong());
        System.out.println();

        numberOfMove++;
        bridgeGame.move();
        bridgeGame.printMap();
        System.out.printf("#%d isEnd 반환값: %b\n", numberOfMove, bridgeGame.isEnd());
        System.out.printf("#%d isMoveWrong 반환값: %b\n", numberOfMove, bridgeGame.isMoveWrong());
        System.out.println();

        numberOfMove++;
        bridgeGame.move();
        bridgeGame.printMap();
        System.out.printf("#%d isEnd 반환값: %b\n", numberOfMove, bridgeGame.isEnd());
        System.out.printf("#%d isMoveWrong 반환값: %b\n", numberOfMove, bridgeGame.isMoveWrong());
        System.out.println();

        numberOfMove++;
        bridgeGame.retry();
        bridgeGame.printMap();
        System.out.printf("#%d isEnd 반환값: %b\n", numberOfMove, bridgeGame.isEnd());
        System.out.printf("#%d isMoveWrong 반환값: %b\n", numberOfMove, bridgeGame.isMoveWrong());

        bridgeGame.printResult(numberOfTry);
    }
}