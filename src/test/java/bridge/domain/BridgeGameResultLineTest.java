package bridge.domain;

import bridge.constant.MoveCommand;
import bridge.constant.MoveSign;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.constant.MoveCommand.*;
import static bridge.constant.MoveSign.MOVE_SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameResultLineTest {

    @DisplayName("받아온 MoveCommands가 자신이 가진 값과 같으면 moveResults를 리스트에 저장한다.")
    @Test
    void addMoveResults() {
        BridgeGameResultLine upLineResults = new BridgeGameResultLine(MOVE_UP_VALUE);
        upLineResults.addMoveResults(MOVE_UP_VALUE, MOVE_SUCCESS.getMessage());

        assertThat(upLineResults.results()).containsOnly("O");
    }

    @DisplayName("받아온 MoveCommands가 자신이 가진 값과 다르면 공백을 리스트에 저장한다.")
    @Test
    void addBlank() {
        BridgeGameResultLine upLineResults = new BridgeGameResultLine(MOVE_UP_VALUE);
        upLineResults.addMoveResults(MOVE_DOWN_VALUE, MOVE_SUCCESS.getMessage());

        assertThat(upLineResults.results()).containsOnly(BridgeGameResultLine.BLANK);
    }

}