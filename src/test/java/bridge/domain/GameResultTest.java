package bridge.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest extends NsTest{
    GameResult result;

    @BeforeEach
    void setup(){
        GameBoard topGameBoard = new GameBoard(List.of("O"," ","O"));
        GameBoard bottomGameBoard = new GameBoard(List.of(" ","O"," "));
        List<GameBoard> gameBoards = List.of(topGameBoard, bottomGameBoard);
        boolean isGameLose = false;
        int tryCount = 1;

        result = new GameResult(gameBoards, isGameLose, tryCount);
    }

    @DisplayName("맵 생성 테스트")
    @Test
    void showGameResultTest() {
        assertSimpleTest(() -> {
            run();
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        });
    }

    @Override
    protected void runMain() {
        result.show();
    }
}