package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.constant.MoveCommand.*;
import static bridge.constant.MoveSign.*;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameResultLineTest {

    @DisplayName("자신이 가진 값과 받아온 MoveCommand가 같으면 moveResults를 리스트에 저장")
    @Test
    void addMoveResults() {
        BridgeGameResultLine upLineResults = new BridgeGameResultLine(MOVE_UP_VALUE);
        upLineResults.addMoveResults(MOVE_UP_VALUE, MOVE_SUCCESS.getMessage());

        assertThat(upLineResults.results()).containsOnly("O");
    }

    @DisplayName("자신이 가진 값과 받아온 MoveCommand가 다르면 공백을 리스트에 저장")
    @Test
    void addBlank() {
        BridgeGameResultLine upLineResults = new BridgeGameResultLine(MOVE_UP_VALUE);
        upLineResults.addMoveResults(MOVE_DOWN_VALUE, MOVE_SUCCESS.getMessage());

        assertThat(upLineResults.results()).containsOnly(BridgeGameResultLine.BLANK);
    }

}