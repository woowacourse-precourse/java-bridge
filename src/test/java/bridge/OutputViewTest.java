package bridge;

import static org.assertj.core.api.Assertions.*;

import bridge.model.Result;
import bridge.view.OutputView;
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
        assertThat(output.toString()).isEqualTo("[ O | X ]\n[   |   ]\n\n");
    }

    @Test
    void 두방향_선택시_결과_출력이_잘_되는지(){
        List<Result> gameResults = List.of(
                new Result("U",true),
                new Result("D",true),
                new Result("U",false));
        outputView.printMap(gameResults);
        assertThat(output.toString()).isEqualTo("[ O |   | X ]\n[   | O |   ]\n\n");
    }

    @Test
    void 두번쨰_단계에서_실패하고_재시작없이_게임이_종료되는_경우_결과_출력이_잘_되는지(){
        List<Result> gameResults = List.of(
                new Result("U",true),
                new Result("U",false));
        outputView.printResult(gameResults,false, 1);

        String print = "최종 게임 결과\n[ O | X ]\n[   |   ]\n\n게임 성공 여부: 실패\n총 시도한 횟수: 1\n";
        assertThat(output.toString()).isEqualTo(print);
    }

    @Test
    void 첫번째_단계에서_실패하고_재시작하여_두번째단계에서_다시_실패하여_재시작없이_게임이_종료되는_경우_결과_출력이_잘_되는지(){
        List<Result> gameResults = List.of(
                new Result("U",true),
                new Result("D",false));
        outputView.printResult(gameResults,false, 2);

        String print = "최종 게임 결과\n[ O |   ]\n[   | X ]\n\n게임 성공 여부: 실패\n총 시도한 횟수: 2\n";
        assertThat(output.toString()).isEqualTo(print);
    }

    @Test
    void 재시도없이_전부_성공하여_게임이_종료되는_경우_결과_출력이_잘_되는지(){
        List<Result> gameResults = List.of(
                new Result("U",true),
                new Result("D",true),
                new Result("U", true));
        outputView.printResult(gameResults,true, 1);

        String print = "최종 게임 결과\n[ O |   | O ]\n[   | O |   ]\n\n게임 성공 여부: 성공\n총 시도한 횟수: 1\n";
        assertThat(output.toString()).isEqualTo(print);
    }
}
