package bridge;


import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class OutViewTest extends NsTest{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private final OutputView outputView = new OutputView();

    @Test
    public void printResultTest(){
        Bridge bridge = new Bridge();
        Bridge userBridge = new Bridge();
        bridge.addBridge("U"); bridge.addBridge("D"); bridge.addBridge("U");
        userBridge.addBridge("U"); userBridge.addBridge("U");

        assertSimpleTest(() -> {
            outputView.printResult(false, 2, bridge, userBridge);
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );
        });

    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
