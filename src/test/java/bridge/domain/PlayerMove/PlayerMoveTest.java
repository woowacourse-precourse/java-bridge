package bridge.domain.PlayerMove;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

class PlayerMoveTest {
    private static final int END_OF_MOVE = -1;

    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void 이동할_칸을_입력받고_유효성_검사를_한_후_반환한다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String result = PlayerMove.takeMovingPosition();

        assertThat(result).isEqualTo(input);
    }

    @ValueSource(strings = {"X", "^!", "a", "1523", "RRRR", "-1", "가", "ㄴ"})
    @EmptySource
    @ParameterizedTest
    void 이동할_칸을_입력받고_유효성_검사했을_때_이상이_있을_경우_예외처리한다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        try {
            PlayerMove.takeMovingPosition();

            assertThat(outputStream.toString()).contains("[ERROR]");
        } catch (NoSuchElementException ignore) {
        }
    }

    @Test
    void 다리_건너기_시도하는_횟수를_구한다() {
        List<String> bridge = Arrays.asList("U", "D", "D");
        List<String> currentBridge = new ArrayList<>();
        currentBridge.add(" O");
        currentBridge.add("O ");
        currentBridge.add("O ");

        int currentLocation = 3;

        int result = PlayerMove.attemptCrossBridge(bridge, currentBridge, currentLocation);
        int expected = 1;

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 다리_건너기_1회_시도_후_현재_다리를_건넌_상태를_확인한다() {
        List<String> bridge = Arrays.asList("U", "D", "D");
        List<String> currentBridge = new ArrayList<>();
        currentBridge.add(" O");
        currentBridge.add("O ");
        currentBridge.add("O ");

        int currentLocation = 3;

        int result = PlayerMove.handlePlayerMove(currentLocation, bridge, currentBridge);

        int expected = END_OF_MOVE;

        assertThat(result).isEqualTo(expected);
    }

    @ValueSource(strings = {"D", "U"})
    @ParameterizedTest
    void 중도_실패_또는_도착할_때까지_다리를_건넌다(String input) {
        List<String> bridge = Arrays.asList("U", "D", "D");
        List<String> currentBridge = new ArrayList<>();
        currentBridge.add(" O");
        currentBridge.add("O ");

        int currentLocation = 2;

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = PlayerMove.crossBridgeUntilFailOrEnd(currentLocation, bridge, currentBridge);

        int expected = 3;

        assertThat(result).isEqualTo(expected);
    }

    @CsvSource(value = {
            "R : 5",
            "Q : 6"
    }, delimiter = ':')
    @ParameterizedTest
    void 중도_실패_시_재시작_여부_묻고_대응한다(String input, int expected) {
        List<String> bridge = Arrays.asList("U", "D", "D", "D", "U", "U", "D");
        List<String> currentBridge = new ArrayList<>();
        currentBridge.add(" O");
        currentBridge.add("O ");
        currentBridge.add("O ");
        currentBridge.add(" O");
        currentBridge.add(" O");
        currentBridge.add(" X");

        int currentLocation = 6;

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = PlayerMove.handleIntermediateFailure(currentLocation, bridge, currentBridge);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 이동_실패시_처리한다() {
        List<String> bridge = Arrays.asList("U", "D", "D");
        List<String> currentBridge = new ArrayList<>();

        currentBridge.add(" O");
        currentBridge.add(" X");

        int currentLocation = 2;

        int result = PlayerMove.moveFail(currentBridge, bridge, currentLocation);

        int expected = 3;

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 이동_성공시_처리한다() {
        List<String> currentBridge = new ArrayList<>();

        currentBridge.add(" O");
        currentBridge.add("O ");

        int currentLocation = 2;
        String movingPosition = "D";

        int result = PlayerMove.moveSuccess(currentBridge, movingPosition, currentLocation);

        int expected = 3;

        assertThat(result).isEqualTo(expected);
    }

    @CsvSource(value = {
            "Q : 5 : 5",
            "R : 5 : 4"
    }, delimiter = ':')
    @ParameterizedTest
    void 게임_재시도_또는_종료_선택_검토_후_처리한다(String gameRestartQuitCommand, int currentLocation, int expected) {
        List<String> currentBridge = new ArrayList<>();
        currentBridge.add(" O");
        currentBridge.add(" O");
        currentBridge.add("O ");
        currentBridge.add(" O");
        currentBridge.add("X ");

        int result = PlayerMove.checkGameRestartOrQuitCommand(gameRestartQuitCommand, currentLocation, currentBridge);

        assertThat(result).isEqualTo(expected);
    }
}