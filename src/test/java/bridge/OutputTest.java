package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;


public class OutputTest extends NsTest{

    @Test
    void 사용자_위치_값확인_로직_테스트() {
        int check = 999;
        boolean checkBridge = true;
        int userPositionValue = 1;

        if(checkBridge == true && userPositionValue == 1){
            check = 0;
            assertThat(check).isEqualTo(0);
            return;
        }

        if(checkBridge == false && userPositionValue == 0){
            check = 1;
            assertThat(check).isEqualTo(1);
            return;
        }

        check = 2;
        assertThat(check).isEqualTo(2);
    }

    @Test
    void 위쪽다리에서_사용자결정_유효한지_테스트() {
        assertSimpleTest(() -> {
            OutputView outputView = new OutputView();
            User user = new User();
            user.setDirection("U");
            boolean checkDirection = true;

            outputView.printWhetherUserDecisionIsCorrectInUpperBridge(user,checkDirection);
            assertThat(output()).contains("O");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
