package bridge.model;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
public class PlayerTest {
    static Player player;
    @BeforeAll
    static void setPlayer() {
        player = new Player();
    }


    @Test
    void playerMoveTest() {
        List<String> currentMove = new ArrayList<>(Arrays.asList("U", "D", "U", "U"));
        List<String> move = new ArrayList<>(Arrays.asList("O", "X", "O", "O"));
        for (int moveIndex = 0; moveIndex < move.size(); moveIndex++) {
            player.setCurrentMove(currentMove.get(moveIndex));
            player.addPlayerMove(move.get(moveIndex));
        }

        List<List> testResult = Arrays.asList(
                List.of("U", "O"),
                List.of("D", "X"),
                List.of("U", "O"),
                List.of("U", "O")
        );
        assertThat(player.getPlayerMoved()).isEqualTo(testResult);
    }
}
