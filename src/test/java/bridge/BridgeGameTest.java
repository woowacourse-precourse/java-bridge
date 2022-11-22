package bridge;

import bridge.constant.GameResult;
import bridge.data.FinalResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    @Test
    @DisplayName("칸별 이동 성공 여부 테스트: 모든 칸을 성공적으로 통과한다")
    void runAttemptTest_1() {
        String input = makeConsoleInput("UDUDUD");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(BridgeGame.getBridgeGame().runAttempt(getBridge(), new ArrayList<>())).isEqualTo(6);
    }

    @Test
    @DisplayName("칸별 이동 성공 여부 테스트: 두 개 칸을 통과하고 세 번째 칸에서 실패한다")
    void runAttemptTest_2() {
        String input = makeConsoleInput("UDDDDD");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(BridgeGame.getBridgeGame().runAttempt(getBridge(), new ArrayList<>())).isEqualTo(2);
    }

    @Test
    @DisplayName("칸별 이동 성공 여부 테스트: 다섯 개 칸을 통과하고 여섯 번째 칸에서 실패한다")
    void runAttemptTest_3() {
        String input = makeConsoleInput("UDUDUU");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(BridgeGame.getBridgeGame().runAttempt(getBridge(), new ArrayList<>())).isEqualTo(5);
    }

    @Test
    @DisplayName("칸별 이동 성공 여부 테스트: 아무 칸도 통과하지 못 하고 첫 번째 칸에서 실패한다")
    void runAttemptTest_4() {
        String input = makeConsoleInput("DDUDUD");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(BridgeGame.getBridgeGame().runAttempt(getBridge(), new ArrayList<>())).isEqualTo(0);
    }

    @Test
    @DisplayName("다리 건너기 게임 최종 결과 계산 테스트: 한 번 시도하고, 다리 통과에 성공하는 경우")
    void runGameWithBridgeTest_1() {
        String input = makeConsoleInput("UDUDUD");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        FinalResult finalResult = BridgeGame.getBridgeGame().runGameWithBridge(getBridge(), new ArrayList<>(), 1);

        assertThat(finalResult.getGameResult()).isEqualTo(GameResult.SUCCESS);
        assertThat(finalResult.getNumAttempts()).isEqualTo(1);
    }

    @Test
    @DisplayName("다리 건너기 게임 최종 결과 계산 테스트: 두 번 시도하고, 두 번째 시도에서 다리 통과에 성공하는 경우")
    void runGameWithBridgeTest_2() {
        String input = makeConsoleInput("DRUDUDUD");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        FinalResult finalResult = BridgeGame.getBridgeGame().runGameWithBridge(getBridge(), new ArrayList<>(), 1);

        assertThat(finalResult.getGameResult()).isEqualTo(GameResult.SUCCESS);
        assertThat(finalResult.getNumAttempts()).isEqualTo(2);
    }

    @Test
    @DisplayName("다리 건너기 게임 최종 결과 계산 테스트: 다섯 번 시도하고, 다섯 번째 시도에서 다리 통과에 성공하는 경우")
    void runGameWithBridgeTest_3() {
        String input = makeConsoleInput("DRDRDRDRUDUDUD");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        FinalResult finalResult = BridgeGame.getBridgeGame().runGameWithBridge(getBridge(), new ArrayList<>(), 1);

        assertThat(finalResult.getGameResult()).isEqualTo(GameResult.SUCCESS);
        assertThat(finalResult.getNumAttempts()).isEqualTo(5);
    }

    @Test
    @DisplayName("다리 건너기 게임 최종 결과 계산 테스트: 한 번 시도하고, 두 번째 시도를 하지 않고 포기(실패)한 경우")
    void runGameWithBridgeTest_4() {
        String input = makeConsoleInput("DQ");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        FinalResult finalResult = BridgeGame.getBridgeGame().runGameWithBridge(getBridge(), new ArrayList<>(), 1);

        assertThat(finalResult.getGameResult()).isEqualTo(GameResult.FAILURE);
        assertThat(finalResult.getNumAttempts()).isEqualTo(1);
    }

    @Test
    @DisplayName("다리 건너기 게임 최종 결과 계산 테스트: 세 번째까지 시도하고, 네 번째 시도를 하지 않고 포기(실패)한 경우")
    void runGameWithBridgeTest_5() {
        String input = makeConsoleInput("UDUU" + "R" + "UDUDD" + "R" + "UDUDUU" + "Q");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        FinalResult finalResult = BridgeGame.getBridgeGame().runGameWithBridge(getBridge(), new ArrayList<>(), 1);

        assertThat(finalResult.getGameResult()).isEqualTo(GameResult.FAILURE);
        assertThat(finalResult.getNumAttempts()).isEqualTo(3);
    }

    @Test
    @DisplayName("다리 길이 입력 받아오기 테스트: 세 번의 시도 끝에 올바른 입력을 받아오는지 테스트")
    void bridgeSizeTest() {
        String input = makeConsoleInput("005");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(BridgeGame.getBridgeGame().bridgeSize()).isEqualTo(5);
    }

    @Test
    @DisplayName("이동할 칸 입력 받아오기 테스트: 네 번의 시도 끝에 올바른 입력을 받아오는지 테스트")
    void moveTest() {
        String input = makeConsoleInput("FFFU");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(BridgeGame.getBridgeGame().move()).isEqualTo("U");
    }

    @Test
    @DisplayName("다리 길이 입력 받아오기 테스트: 세 번의 시도 끝에 올바른 입력을 받아오는지 테스트")
    void retryTest() {
        String input = makeConsoleInput("rasQ");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(BridgeGame.getBridgeGame().retry()).isEqualTo("Q");
    }

    @AfterEach
    void clearInputStream() {
        boolean isConsoleExhausted = false;
        while (!isConsoleExhausted) {
            try {
                readLine();
            } catch (NoSuchElementException exception) {
                isConsoleExhausted = true;
            }
        }
    }

    private List<String> getBridge() {
        List<String> bridge = new ArrayList<>();
        String[] correctMoves = new String[]{"U", "D", "U", "D", "U", "D"};
        Collections.addAll(bridge, correctMoves);
        return bridge;
    }

    private String makeConsoleInput(String bareInput) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bareInput.length(); i++) {
            stringBuilder.append(bareInput.charAt(i)).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
