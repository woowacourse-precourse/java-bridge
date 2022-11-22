package bridge.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HistoryTest {

    private static History history;

    @BeforeAll
    static void setup() {
        history = new History();
    }

    @Test
    void MoveCommand_입력시_상태_저장() {
        //given
        //when
        history.appendMove(MoveCommand.UP);
        history.appendMove(MoveCommand.DOWN);
        boolean equals = history.getBridgeChars().equals(List.of("U", "D"));

        //then
        assertThat(equals).isEqualTo(true);
    }
}