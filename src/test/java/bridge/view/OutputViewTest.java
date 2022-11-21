package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.data.dto.responseDto.FinalResultResponseDto;
import bridge.data.dto.responseDto.InGameCommandResponseDto;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("다리 건너기 게임 출력에 대해,")
public class OutputViewTest {

    private final OutputView outputView = new OutputViewImpl();
    private OutputStream captor;

    @BeforeEach
    void init() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    private String output() {
        return captor.toString().trim();
    }

    @DisplayName("진행 경과를 출력할 때에는")
    @Nested
    class printMapTest {

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

    @DisplayName("최종 결과를 출력할 때에는")
    @Nested
    class printResultTest {

        @DisplayName("최종 결과에는 결과 안내 메시지, 지도, 성공 여부, 시도 횟수를 모두 출력해야 한다.")
        @Test
        void printSuccessTest() {
            outputView.printResult(new FinalResultResponseDto(
                    new InGameCommandResponseDto(
                            List.of("U", "D", "U", "U", "U", "D"),
                            List.of("U", "D", "U", "U", "U", "D")),
                    3));
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O | O | O |   ]",
                    "[   | O |   |   |   | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1");
        }

        @DisplayName("중도 포기라면, 실패로 표기해야한다.")
        @Test
        void printFailTest() {
            outputView.printResult(new FinalResultResponseDto(
                    new InGameCommandResponseDto(
                            List.of("D", "D", "U"),
                            List.of("D", "D", "D")),
                    1));
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   |   |   ]",
                    "[ O | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1");
        }
    }

}
