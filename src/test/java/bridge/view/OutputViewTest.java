package bridge.view;

import bridge.view.dto.PrintMapDto;
import bridge.view.proxy.OutputViewProxy;
import bridge.view.proxy.OutputViewProxyImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private static OutputViewProxy outputView;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @BeforeAll
    public static void init() {
        outputView = new OutputViewProxyImpl(new OutputView());
    }

    @Test
    void 크기_1_성공_출력_테스트() {
        // given
        String expect = "[ O ]"
                + System.lineSeparator()
                + "[   ]"
                + System.lineSeparator();

        // when
        outputView.printMap(new PrintMapDto(0, "U", List.of("U")));

        // then

        assertThat(outContent.toString()).isEqualTo(expect);
    }

    @Test
    void 크기_1_실패_출력_테스트() {
        // given
        String expect = "[ X ]"
                + System.lineSeparator()
                + "[   ]"
                + System.lineSeparator();

        // when
        outputView.printMap(new PrintMapDto(0, "U", List.of("D")));

        // then

        assertThat(outContent.toString()).isEqualTo(expect);
    }

    @Test
    void 크기_2_성공_출력_테스트() {
        // given
        String expect = "[ O |   ]"
                + System.lineSeparator()
                + "[   | O ]"
                + System.lineSeparator();

        // when
        outputView.printMap(new PrintMapDto(1, "D", List.of("U", "D")));

        // then
        assertThat(outContent.toString()).isEqualTo(expect);
    }

    @Test
    void 크기_2_실패_출력_테스트() {
        // given
        String expect = "[ O | X ]"
                + System.lineSeparator()
                + "[   |   ]"
                + System.lineSeparator();

        // when
        outputView.printMap(new PrintMapDto(1, "U", List.of("U", "D")));

        // then
        assertThat(outContent.toString()).isEqualTo(expect);
    }
}
