package bridge;

import bridge.domain.Game;
import bridge.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    OutputStream outputStream;

    OutputView outputView;
    Game game;
    @BeforeEach
    void init(){
        game = new Game();
        outputView = new OutputView();
        List<List<String>> map = new ArrayList<>();
        List<String> up = List.of("O", " ", "O");
        List<String> down = List.of(" ", "O", " ");
        map.add(up);
        map.add(down);
        game.setPlaying(map);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }
    @Test
    void printMap(){
        outputView.printMap(game);
        assertThat(outputStream.toString().trim()).contains(
                "[ O |   | O ]",
                "[   | O |   ]"
        );
    }

    @Test
    void printResultTest(){
        outputView.printResult(game,2);
        assertThat(outputStream.toString().trim()).contains(
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 2"
        );
    }

}