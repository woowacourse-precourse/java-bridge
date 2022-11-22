package bridge;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    private final OutputView outputView = new OutputView();
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams(){
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStream(){
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 한방향만_선택시결과_출력이_잘_되는지(){
        List<Result> gameResults = List.of(
                new Result("U",true),
                new Result("U",false));
        outputView.printMap(gameResults);
        assertThat(output.toString()).isEqualTo("[ O | X ]\n[   |   ]\n");
    }

    @Test
    void 두방향_선택시_결과_출력이_잘_되는지(){
        List<Result> gameResults = List.of(
                new Result("U",true),
                new Result("D",true),
                new Result("U",false));
        outputView.printMap(gameResults);
        assertThat(output.toString()).isEqualTo("[ O |   | X ]\n[   | O |   ]\n");
    }
}
