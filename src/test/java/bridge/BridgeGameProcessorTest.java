package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.controller.BridgeGameProcessor;
import bridge.model.BridgeGame;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


@DisplayName("BridgeGameProcessor 클래스")
@Nested
class BridgeGameProcessorTest {

    @DisplayName("chooseDirection 메소드는")
    @Nested
    class Describe_chooseDirection {

        SoftAssertions softAssertions = new SoftAssertions();

        @DisplayName("방향을 입력받는다.")
        @Test
        void chooseDirectionTest() {
            BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));
            BridgeGameProcessor bridgeGameProcessor = new BridgeGameProcessor(bridgeGame);
            System.setIn(new ByteArrayInputStream("U".getBytes()));
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));

            softAssertions.assertThat(bridgeGameProcessor.chooseDirection()).as("입력 확인")
                    .isEqualTo("U");
            softAssertions.assertThat(out.toString()).as("출력 확인").contains("이동할 칸을 선택해주세요.");
            softAssertions.assertAll();
        }
    }

    @DisplayName("makeMove 메소드는")
    @Nested
    class Describe_makeMove {

        @DisplayName("건너려는 타일이 일치하면")
        @Nested
        class Context_with_correctMove {

            SoftAssertions softAssertions = new SoftAssertions();
            BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));
            BridgeGameProcessor bridgeGameProcessor = new BridgeGameProcessor(bridgeGame);

            @DisplayName("다리를 한 칸 건너고 배열에 업데이트 한다.")
            @Test
            void makeMoveTest() {
                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));

                bridgeGameProcessor.makeMove("U");

                softAssertions.assertThat(out.toString()).as("메시지 확인").contains("[ O ]", "[   ]");
                int upSideIndex = out.toString().indexOf("[ O ]");
                int downSideIndex = out.toString().indexOf("[   ]");
                softAssertions.assertThat(upSideIndex).as("인덱스 위치 확인").isLessThan(downSideIndex);
                softAssertions.assertAll();
            }
        }

        @DisplayName("건너려는 타일이 일치하지 않으면")
        @Nested
        class Context_with_wrongMove {

            SoftAssertions softAssertions = new SoftAssertions();
            BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));
            BridgeGameProcessor bridgeGameProcessor = new BridgeGameProcessor(bridgeGame);

            @DisplayName("재도전 여부를 입력받고, 오답 배열을 출력 한다.")
            @Test
            void makeMoveTest() {
                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));
                System.setIn(new ByteArrayInputStream("Q".getBytes()));

                bridgeGameProcessor.makeMove("D");

                softAssertions.assertThat(out.toString()).as("메시지 확인").contains("[ X ]", "[   ]");
                int upSideIndex = out.toString().indexOf("[   ]");
                int downSideIndex = out.toString().indexOf("[ X ]");
                softAssertions.assertThat(upSideIndex).as("인덱스 위치 확인").isLessThan(downSideIndex);
                softAssertions.assertAll();
            }
        }
    }

    @DisplayName("crossBridge 메소드는")
    @Nested
    class Describe_crossBridge {

        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        BridgeGameProcessor bridgeGameProcessor = new BridgeGameProcessor(bridgeGame);

        @DisplayName("다리가 완성될 때까지 다리를 한 칸 씩 건넌다.")
        @Test
        void makeMoveTest() {
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));

            String input = "D\nR\nU\nD\nU";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            bridgeGameProcessor.crossBridge();
            assertThat(out.toString())
                    .contains("[ X ]",
                            "[ O ]",
                            "[ O |   ]",
                            "[ O |   | O ]",
                            "[   | O |   ]",
                            "게임을 다시 시도");
        }
    }
}


