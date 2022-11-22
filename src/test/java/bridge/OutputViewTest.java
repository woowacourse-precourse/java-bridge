package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class OutputViewTest {
    OutputView outputView = new OutputView();

    @Test
    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest
    void printMap_동작_테스트(int input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        outputView.printMap(List.of("U", "D", "U", "D"), getPrintMapInput(input));
        Assertions.assertThat(out.toString()).isEqualTo(getPrintMapOutput(input));
    }
    List<String> getPrintMapInput(int i) {
        List<List<String>> inputs = new ArrayList<>(
                List.of(
                        List.of("U")
                        , List.of("U", "D")
                        , List.of("U", "D", "D")
                        , List.of("U", "D", "U", "U")
                )
        );
        return inputs.get(i);
    }
    String getPrintMapOutput(int i){
        List<String> outputs = new ArrayList<>(
                List.of(
                        "[ O ]\n[   ]\n",
                        "[ O |   ]\n[   | O ]\n",
                        "[ O |   |   ]\n[   | O | X ]\n",
                        "[ O |   | O | X ]\n[   | O |   |   ]\n"
                )
        );
        return outputs.get(i);
    }

    @Test
    void printResult_동작_테스트(){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        outputView.printResult(true, 3);
        Assertions.assertThat(out.toString()).isEqualTo("게임 성공 여부: 성공\n총 시도한 횟수: 3\n");
    }
}
