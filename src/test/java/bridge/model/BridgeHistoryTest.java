package bridge.model;


import bridge.commom.constant.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeHistoryTest {

    private static BridgeHistory sut;

    @BeforeEach
    void setup() {
        sut = new BridgeHistory(new HashMap<>(), 6);
    }

    @DisplayName("기록을 업데이트할 떄마다 스테이지가 잘 오르는지 검증한다.")
    @Test
    void whenUpdateHistoryThenStageCountWillBeIncreased() {
        for (int expected = 0; expected < 7; expected++) {
            int actual = sut.getNowStage();
            sut.updateGameState("U", true);
            assertThat(actual).isEqualTo(expected);
        }
    }

    @DisplayName("기록을 초기화할 떄마다 retry 카운트가 잘 오르는지 검증한다.")
    @Test
    void whenResetHistoryThenRetryCountWillBeIncreased() {
        for (int expected = 1; expected < 10; expected++) {
            int actual = sut.getRetry();
            sut.resetHistory();
            assertThat(actual).isEqualTo(expected);
        }
    }

    @DisplayName("다리를 끝까지 건넌다면, 게임 상태를 성공으로 바꾸는지 검증한다.")
    @Test
    void ifCrossedBridgeThenGameStateIsSuccess() {
        for (int expected = 0; expected < 6; expected++) {
            sut.updateGameState("U", true);
        }
        GameState actual = sut.getProgress();
        assertThat(actual).isEqualTo(GameState.SUCCESS);
    }

    @DisplayName("다리를 건너다 실패하면, 게임 상태를 실패로 바꾸는지 검증한다.")
    @Test
    void ifFailToCrossBridgeThenGameStateIsFail() {
        for (int expected = 0; expected < 5; expected++) {
            sut.updateGameState("U", true);
        }
        sut.updateGameState("U", false);
        GameState actual = sut.getProgress();
        assertThat(actual).isEqualTo(GameState.FAIL);
    }

    @DisplayName("다리를 건너는 중이라면, 게임 상태가 실행중인지 검증한다.")
    @Test
    void ifCrossingBridgeThenGameStateIsRunning() {
        for (int expected = 0; expected < 3; expected++) {
            sut.updateGameState("U", true);
        }
        GameState actual = sut.getProgress();
        assertThat(actual).isEqualTo(GameState.RUNNING);
    }

    @DisplayName("기록이 초기화되면, 상태가 실행중으로 바뀌는지 검증한다.")
    @Test
    void ifResetHistoryThenGameStateIsRunning() {
        for (int expected = 0; expected < 6; expected++) {
            sut.updateGameState("U", true);
        }
        sut.resetHistory();
        GameState actual = sut.getProgress();
        assertThat(actual).isEqualTo(GameState.RUNNING);
    }

    @DisplayName("기록이 초기화되면, 기록의 모든 페이지가 초기화되는 지 검증한다.")
    @Test
    void ifResetHistoryThenAllHistoryPagesResetTo() {
        for (int expected = 0; expected < 6; expected++) {
            sut.updateGameState("U", true);
        }
        sut.resetHistory();
        int actual = sut.getHistory().getOrDefault("U", new ArrayList<>()).size();
        assertThat(actual).isEqualTo(0);
    }

    @DisplayName("성공 기록이 생기면, 적절한 위치에 O이 표시된 페이지가 생기는지 검증한다.")
    @Test
    void ifUpdateSuccessPageThenMarkOWhereProperlyLocation() {
        for (int expected = 0; expected < 3; expected++) {
            sut.updateGameState("U", true);
        }
        String actual = sut.getHistory().get("U").get(2);
        assertThat(actual).isEqualTo("O");
    }

    @DisplayName("실패 기록이 생기면, 적절한 위치에 X이 표시된 페이지가 생기는지 검증한다.")
    @Test
    void ifUpdateFailPageThenMarkXWhereProperlyLocation() {
        for (int expected = 0; expected < 3; expected++) {
            sut.updateGameState("U", true);
        }
        sut.updateGameState("D", false);

        String actual = sut.getHistory().get("D").get(3);
        assertThat(actual).isEqualTo("X");
    }

    @DisplayName("상태(O,X)가 표시된 페이지가 생기면, 반대 페이지는 공백이 표시된 페이지가 생기는지 검증한다.")
    @Test
    void AlterPageWillBeMarkedWithWhiteSpace() {
        for (int expected = 0; expected < 3; expected++) {
            sut.updateGameState("U", true);
        }
        String actual = sut.getHistory().get("D").get(2);
        assertThat(actual).isEqualTo(" ");
    }

}