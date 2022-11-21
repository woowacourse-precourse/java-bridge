package bridge;
import bridge.controller.Controller;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ControllerTest extends NsTest {

    Controller controller=new Controller();
    @Override
    protected void runMain(){}

    @DisplayName("프로그램 시작시 시작문구가 정상적으로 출력되는지 확인")
    @Test
    public void startProgramCommentSuccess(){
        controller.startProgram();
        assertThat(output()).contains("다리 건너기 게임을 시작합니다.");
    }
}
