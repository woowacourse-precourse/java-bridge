package bridge;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.Validation;
import view.InputView;

class BridgeTest extends NsTest {
    private Bridge bridge;
    @BeforeEach
    void setUp() {
        List<String> elements = newArrayList("U", "D", "U");
        bridge = new Bridge(elements);
    }

    @ParameterizedTest
    @CsvSource(value = {"U -> [ O ],[   ]", "D -> [   ],[ X ]"}, delimiterString = " -> ")
    @Test
    void 한개의_입력값에따른_결과출력_테스트(String input, String expected) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(
                    expected.split(",")
            );
        });
    }

    @Test
    void 끝까지_건널때까지_입력받고_이동한결과를_출력하는지_테스트() {
        assertSimpleTest(() -> {
            run("U", "D", "U");
            assertThat(output()).contains(
                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | O ]",
                    "[ O |   | O ]",
                    "[   | O |   ]"
            );
        });
    }

    @Test
    void 건널수없는칸을_입력받을때까지_입력받고_이동한결과를_출력하는지_테스트() {
        assertSimpleTest(() -> {
            run("U", "U");
            assertThat(output()).contains(
                    "[ O ]",
                    "[   ]",
                    "[ O | X ]",
                    "[   |   ]"
            );
        });
    }

    @Override
    protected void runMain() {
        bridge.readAndMove(new InputView(new Validation()));
    }
}
