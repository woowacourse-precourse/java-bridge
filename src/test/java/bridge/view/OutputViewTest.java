package bridge.view;

import bridge.domain.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputViewTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        OutputView.reset();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void after() {
        System.setOut(standardOut);
    }

    @Test
    void 게임_시작_문구_출력() {
        // given
        String message = "다리 건너기 게임을 시작합니다.";

        // when
        OutputView.printGameStart();

        // then
        assertEquals(message, outputStreamCaptor.toString().trim());
    }

    @Test
    void 다리길이_입력_문구_출력() {
        // given
        String message = "다리의 길이를 입력해주세요.";

        // when
        OutputView.printInputBridgeSizeMessage();

        // then
        assertEquals(message, outputStreamCaptor.toString().trim());
    }

    @Test
    void 이동할칸_문구_출력() {
        // given
        String message = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

        // when
        OutputView.printInputMoveMessage();

        // then
        assertEquals(message, outputStreamCaptor.toString().trim());
    }

    @Test
    void 게임_재시작_종료_여부_문구_출력() {
        // given
        String message = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

        // when
        OutputView.printInputGameCommandMessage();

        // then
        assertEquals(message, outputStreamCaptor.toString().trim());
    }

    @Test
    void 플레이어는_위칸을_선택하고_이동결과에_따라_건넌다리의_상태를_출력() {
        // given
        Player player = new Player();
        player.selectPosition("U");

        boolean isPass = true;
        int start = 0;

        String expectedMessage = "[ O ]\n[   ]\n\n";


        // when
        OutputView.printMap(player, isPass, start);

        // then
        assertEquals(expectedMessage, outputStreamCaptor.toString());
        player.removePositions();
    }

    @Test
    void 최종결과_출력() {
        // given
        OutputView.printResult("성공", 1);
        String expectedMessage = "최종 게임 결과\n" +
                "[  ]\n" +
                "[  ]\n" +
                "\n" +
                "게임 성공 여부: 성공\n" +
                "총 시도한 횟수: 1\n";

        // then
        assertEquals(expectedMessage, outputStreamCaptor.toString());
    }
}