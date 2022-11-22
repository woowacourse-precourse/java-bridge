package bridge.domain.bridge_game;

import static bridge.domain.constants.MoveCommands.MOVE_DOWN_COMMAND;
import static bridge.domain.constants.MoveCommands.MOVE_UP_COMMAND;
import static bridge.domain.constants.MoveResultsSign.MOVE_SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveResultsPerLineTest {

    @DisplayName("받아온 MoveCommands가 자신이 가진 값과 같으면 moveResults를 리스트에 저장한다.")
    @Test
    void addMoveResults() {
        MoveResultsPerLine upLineResults = new MoveResultsPerLine(MOVE_UP_COMMAND);
        upLineResults.addMoveResults(MOVE_UP_COMMAND, MOVE_SUCCESS);

        assertThat(upLineResults.results()).containsOnly("O");
    }

    @DisplayName("받아온 MoveCommands가 자신이 가진 값과 다르면 공백을 리스트에 저장한다.")
    @Test
    void addBlank() {
        MoveResultsPerLine upLineResults = new MoveResultsPerLine(MOVE_UP_COMMAND);
        upLineResults.addMoveResults(MOVE_DOWN_COMMAND, MOVE_SUCCESS);

        assertThat(upLineResults.results()).containsOnly(MoveResultsPerLine.BLANK);
    }
}