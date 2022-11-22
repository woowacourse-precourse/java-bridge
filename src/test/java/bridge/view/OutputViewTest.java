package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.object.Bridge;
import bridge.domain.object.Player;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private static ByteArrayOutputStream outputMessage;
    private static OutputView outputView;

    @BeforeAll
    static void setOutputView() {
        outputView = new OutputView();
    }

    @BeforeEach
    void setUp() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStream() {
        System.setOut(System.out);
    }

    @DisplayName("이동할 칸을 입력받는 안내 문구가 출력된다.")
    @Test
    void guideInputMoving() {
        outputView.guideInputMoving();

        assertThat(outputMessage.toString()).isEqualTo("이동할 칸을 선택해주세요. (위: U, 아래: D)\r\n");
    }

    @DisplayName("다리 맵을 출력한다.")
    @Test
    void printMap() {
        Player player = new Player();
        Bridge bridge = new Bridge(List.of("U", "D", "U", "U", "D", "U"));
        BridgeGame bridgeGame = new BridgeGame(player, bridge);
        player.addMove("U");
        player.addMove("D");
        player.addMove("U");
        player.addMove("U");
        player.addMove("U");

        outputView.printMap(bridgeGame);

        assertThat(outputMessage.toString()).isEqualTo(
                "[ O |   | O | O | X ]\r\n" +
                        "[   | O |   |   |   ]\r\n");
    }

    @DisplayName("게임 실패 안내 문구를 출력한다.")
    @Test
    void guideInputGameOver() {
        outputView.guideInputGameOver();

        assertThat(outputMessage.toString()).isEqualTo("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\r\n");
    }

    @DisplayName("게임 종료 문구를 출력한다")
    @Test
    void printResult() {
        Player player = new Player();
        Bridge bridge = new Bridge(List.of("U", "D", "U", "U", "D", "U"));
        BridgeGame bridgeGame = new BridgeGame(player, bridge);
        player.addMove("U");
        player.addMove("D");
        player.addMove("U");
        player.addMove("U");
        player.addMove("U");

        outputView.printResult("실패", bridgeGame);

        assertThat(outputMessage.toString()).isEqualTo(
                "최종 게임 결과\r\n" +
                        "[ O |   | O | O | X ]\r\n" +
                        "[   | O |   |   |   ]\r\n" +
                        "게임 성공 여부: 실패\r\n" +
                        "총 시도한 횟수: 1\r\n");
    }
}