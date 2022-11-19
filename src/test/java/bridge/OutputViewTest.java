package bridge;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
                .isEqualTo("[" + upBridge + "]\r\n" + "[" + downBridge + "]\r\n");
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
                .isEqualTo("[" + upBridge + "]\r\n" + "[" + downBridge + "]\r\n");
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
                .isEqualTo("[" + upBridge + "]\r\n" + "[" + downBridge + "]\r\n");
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
                .isEqualTo("[" + upBridge + "]\r\n" + "[" + downBridge + "]\r\n");
        }
    }
}
