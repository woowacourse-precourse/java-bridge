package bridge;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/*
 * [WARNING]
 * 윈도우 환경에서 테스트를 진행하기 때문에 LF("\n") 가 아닌 CRLF("\r\n") 로 개행 문자로 작성
 * */
class OutputViewTest {

    private static ByteArrayOutputStream outputMessage;

    private static final String NEXT = BridgeResultString.NEXT.getString();
    private static final String SUCCESS = BridgeResultString.SUCCESS.getString();
    private static final String FAILURE = BridgeResultString.FAILURE.getString();
    private static final String PASS = BridgeResultString.PASS.getString();

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @Nested
    @DisplayName("printMap 테스트")
    class PrintMapTest {

        @Test
        @DisplayName("출력 확인 1")
        void printMapTest1() {
            // given
            OutputView outputView = new OutputView();

            String upBridge = SUCCESS;
            String downBridge = PASS;

            // when
            outputView.printMap(upBridge, downBridge);

            // then
            Assertions.assertThat(outputMessage.toString())
                .isEqualTo("[" + upBridge + "]\r\n" + "[" + downBridge + "]\r\n\r\n");
        }

        @Test
        @DisplayName("출력 확인 2")
        void printMapTest2() {
            // given
            OutputView outputView = new OutputView();

            String upBridge = SUCCESS + NEXT + FAILURE;
            String downBridge = PASS + NEXT + PASS;

            // when
            outputView.printMap(upBridge, downBridge);

            // then
            Assertions.assertThat(outputMessage.toString())
                .isEqualTo("[" + upBridge + "]\r\n" + "[" + downBridge + "]\r\n\r\n");
        }

        @Test
        @DisplayName("출력 확인 3")
        void printMapTest3() {
            // given
            OutputView outputView = new OutputView();

            String upBridge = SUCCESS + NEXT + PASS;
            String downBridge = PASS + NEXT + SUCCESS;

            // when
            outputView.printMap(upBridge, downBridge);

            // then
            Assertions.assertThat(outputMessage.toString())
                .isEqualTo("[" + upBridge + "]\r\n" + "[" + downBridge + "]\r\n\r\n");
        }

        @Test
        @DisplayName("출력 확인 4")
        void printMapTest4() {
            // given
            OutputView outputView = new OutputView();

            String upBridge = SUCCESS + NEXT + PASS + NEXT + PASS;
            String downBridge = PASS + NEXT + SUCCESS + NEXT + SUCCESS;

            // when
            outputView.printMap(upBridge, downBridge);

            // then
            Assertions.assertThat(outputMessage.toString())
                .isEqualTo("[" + upBridge + "]\r\n" + "[" + downBridge + "]\r\n\r\n");
        }
    }

    @Nested
    @DisplayName("printResult 테스트")
    class PrintResultTest {

        @Test
        @DisplayName("게임 성공 여부: 실패 출력")
        void printResultTest1() {
            // given
            BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
            OutputView outputView = new OutputView();

            // when
            bridgeGame.move("U");
            bridgeGame.move("U");

            // then
            outputView.printResult(bridgeGame.getUpBridgeToString(),
                bridgeGame.getDownBridgeToString(), bridgeGame.isClear(),
                bridgeGame.getCountOfTry());

            String upBridge = SUCCESS + NEXT + FAILURE;
            String downBridge = PASS + NEXT + PASS;

            Assertions.assertThat(outputMessage.toString()).isEqualTo(
                "최종 게임 결과\r\n" + "[" + upBridge + "]\r\n" + "[" + downBridge + "]\r\n\r\n"
                    + "게임 성공 여부: " + "실패\r\n" + "총 시도한 횟수: " + "1\r\n");
        }

        @Test
        @DisplayName("게임 성공 여부: 성공 출력")
        void printResultTest2() {
            // given
            BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
            OutputView outputView = new OutputView();

            // when
            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("D");

            // then
            outputView.printResult(bridgeGame.getUpBridgeToString(),
                bridgeGame.getDownBridgeToString(), bridgeGame.isClear(),
                bridgeGame.getCountOfTry());

            String upBridge = SUCCESS + NEXT + PASS + NEXT + PASS;
            String downBridge = PASS + NEXT + SUCCESS + NEXT + SUCCESS;

            Assertions.assertThat(outputMessage.toString()).isEqualTo(
                "최종 게임 결과\r\n" + "[" + upBridge + "]\r\n" + "[" + downBridge + "]\r\n\r\n"
                    + "게임 성공 여부: " + "성공\r\n" + "총 시도한 횟수: " + "1\r\n");
        }

        @Test
        @DisplayName("재시도 후 성공 및 총 재시도 횟수 2 출력")
        void printResultTest3() {
            // given
            BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
            OutputView outputView = new OutputView();

            // when
            bridgeGame.move("U");
            bridgeGame.move("U");

            bridgeGame.retry();

            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("D");

            // then
            outputView.printResult(bridgeGame.getUpBridgeToString(),
                bridgeGame.getDownBridgeToString(), bridgeGame.isClear(),
                bridgeGame.getCountOfTry());

            String upBridge = SUCCESS + NEXT + PASS + NEXT + PASS;
            String downBridge = PASS + NEXT + SUCCESS + NEXT + SUCCESS;

            Assertions.assertThat(outputMessage.toString()).isEqualTo(
                "최종 게임 결과\r\n" + "[" + upBridge + "]\r\n" + "[" + downBridge + "]\r\n\r\n"
                    + "게임 성공 여부: " + "성공\r\n" + "총 시도한 횟수: " + "2\r\n");
        }
    }
}
