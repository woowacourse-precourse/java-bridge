package bridge;

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
        List<String> elements = newArrayList("U");
        bridge = new Bridge(elements);
    }

    @ParameterizedTest
    @CsvSource(value = {"U -> [ O ],[   ]", "D -> [   ],[ X ]"}, delimiterString = " -> ")
    @Test
    void move(String input, String expected) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(
                    expected.split(",")
            );
        });
    }

    @Override
    protected void runMain() {
        bridge.readAndMove(new InputView(new Validation()));
    }
}
