package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class PrintMapMethodTest extends NsTest {

    private static final OutputView outputView = new OutputView();

    @DisplayName("완성되지 않은 패스가 맞은 경우")
    @Test
    void printMapMethodTest1() {
        List<String> path = new ArrayList<>(List.of("U", "D"));
        List<String> bridge = new ArrayList<>(List.of("U", "D", "U"));
        assertSimpleTest(() -> {
            outputView.printMap(path, bridge);
            assertThat(output()).contains(
                    "[ O |   ]",
                    "[   | O ]"
            );
        });
        int upSideIndex = output().indexOf("[ O |   ]");
        int downSideIndex = output().indexOf("[   | O ]");
        assertThat(upSideIndex).isLessThan(downSideIndex);
    }

    @DisplayName("path가 틀린 경우")
    @Test
    void printMapMethodTest2() {
        List<String> path = new ArrayList<>(List.of("U"));
        List<String> bridge = new ArrayList<>(List.of("D"));
        assertSimpleTest(() -> {
            outputView.printMap(path, bridge);
            assertThat(output()).contains(
                    "[ X ]",
                    "[   ]"
            );
        });
        int upSideIndex = output().indexOf("[ X ]");
        int downSideIndex = output().indexOf("[   ]");
        assertThat(upSideIndex).isLessThan(downSideIndex);
    }

    @DisplayName("bridge 끝에 도달하지 못했으나 path가 틀린 경우")
    @Test
    void printMapMethodTest3() {
        List<String> path = new ArrayList<>(List.of("U", "D", "U"));
        List<String> bridge = new ArrayList<>(List.of("U", "D", "D", "D"));
        assertSimpleTest(() -> {
            outputView.printMap(path, bridge);
            assertThat(output()).contains(
                    "[ O |   | X ]",
                    "[   | O |   ]"
            );
        });
        int upSideIndex = output().indexOf("[ O |   | X ]");
        int downSideIndex = output().indexOf("[   | O |   ]");
        assertThat(upSideIndex).isLessThan(downSideIndex);
    }

    @DisplayName("path와 bridge가 완전히 일치하는 경우")
    @Test
    void printMapMethodTest4() {
        List<String> path = new ArrayList<>(List.of("U", "D", "U"));
        List<String> bridge = new ArrayList<>(List.of("U", "D", "U"));
        assertSimpleTest(() -> {
            outputView.printMap(path, bridge);
            assertThat(output()).contains(
                    "[ O |   | O ]",
                    "[   | O |   ]"
            );
        });
        int upSideIndex = output().indexOf("[ O |   | O ]");
        int downSideIndex = output().indexOf("[   | O |   ]");
        assertThat(upSideIndex).isLessThan(downSideIndex);
    }

    @DisplayName("복합 테스트")
    @Test
    void printMapMethodTest5() {
        List<String> path = new ArrayList<>(List.of("U", "D", "U", "D", "D", "U", "D"));
        List<String> bridge = new ArrayList<>(List.of("U", "D", "U", "D", "D", "U", "U", "D", "U"));
        assertSimpleTest(() -> {
            outputView.printMap(path, bridge);
            assertThat(output()).contains(
                    "[ O |   | O |   |   | O |   ]",
                    "[   | O |   | O | O |   | X ]"
            );
        });
        int upSideIndex = output().indexOf("[ O |   | O |   |   | O |   ]");
        int downSideIndex = output().indexOf("[   | O |   | O | O |   | X ]");
        assertThat(upSideIndex).isLessThan(downSideIndex);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}