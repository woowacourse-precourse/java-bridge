package bridge.view.outputView;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.data.dto.responseDto.InGameCommandResponseDto;
import bridge.view.OutputView;
import bridge.view.OutputViewImpl;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("최종 결과를 출력할 때에는")
public class OutputViewPrintResultTest extends OutputViewTest{

    private final OutputView outputView = new OutputViewImpl();

    @DisplayName("정답에 대한 입력엔 O를 출력해야 한다.")
    @Test
    void printPassTest() {
        outputView.printMap(new InGameCommandResponseDto(
                List.of("D", "U", "D", "U"),
                List.of("D", "U")));
        assertThat(output()).contains(
                "[   | O ]",
                "[ O |   ]");
    }

    @DisplayName("오답에 대한 입력엔 X를 출력해야 한다.")
    @Test
    void printFallTest() {
        outputView.printMap(new InGameCommandResponseDto(
                List.of("D", "D", "U"),
                List.of("D", "D", "D")));
        assertThat(output()).contains(
                "[   |   |   ]",
                "[ O | O | X ]");
    }
}
