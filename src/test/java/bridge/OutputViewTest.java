package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class OutputViewTest extends NsTest {

    private static String ox;
    private static int order;
    private static String upDown;


    @Test
    void 맵_생성_테스트_첫번째(){
        this.ox = "O";
        this.order = 0;
        this.upDown = "U";
        run();
        assertThat(output()).contains(
                "[ O ]\n[   ]"
        );
    }

    @Test
    void 맵_생성_테스트_두번째(){
        this.ox = "O";
        this.order = 0;
        this.upDown = "U";
        run();

        this.order++;
        this.upDown = "D";
        run();
        assertThat(output()).contains(
                "[ O |   ]\n[   | O ]"
        );
    }


    @Override
    protected void runMain() {
        OutputView outputView = new OutputView();
        outputView.printMap(this.ox);


    }
}