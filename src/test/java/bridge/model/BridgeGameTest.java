package bridge.model;

import bridge.utils.Mark;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    private final BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("이동할 수 있는 칸을 맞추면 해당 칸에 'O'가 누적된 리스트를 반환한다.")
    @Test
    void rightMove() {
        //given
        List<String> upMapper = List.of(" ");
        List<String> downMapper = List.of("O");
        List<List<String>> expected = List.of(upMapper, downMapper);
        Mark mark = Mark.DOWN_MATCH;

        //when
        List<List<String>> result = bridgeGame.move(mark);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("이동할 수 있는 칸을 틀리면 해당 칸에 'X'가 누적된 리스트를 반환한다.")
    @Test
    void wrongMove() {
        //given
        List<String> upMapper = List.of(" ");
        List<String> downMapper = List.of("X");
        List<List<String>> expected = List.of(upMapper, downMapper);
        Mark mark = Mark.DOWN_WRONG;

        //when
        List<List<String>> result = bridgeGame.move(mark);

        //then
        assertThat(result).isEqualTo(expected);
    }
}
