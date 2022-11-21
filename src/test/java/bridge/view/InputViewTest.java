package bridge;

import static bridge.constant.GameCommand.R;
import static bridge.constant.MovingDirection.U;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constant.GameCommand;
import bridge.constant.MovingDirection;
import bridge.view.ClientConsole;
import bridge.view.InputView;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    InputView inputView;
    ClientConsole clientConsole;

    private void initMockClientConsole(String output) {
        this.inputView = new InputView(() -> output);
    }

    @Test
    void 다리_길이를_입력받는다() throws Exception {
        initMockClientConsole("3");
        int bridgeLength = inputView.readBridgeSize();
        assertThat(bridgeLength).isEqualTo(3);
    }

    @Test
    void 다리_길이는_3이상_20이하가_아닐경우_예외발생() throws Exception {
        initMockClientConsole("2");
        assertThatThrownBy(() -> {
            inputView.readBridgeSize();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리_길이_입력에_문자가_들어온경우_예외발생() throws Exception {
        initMockClientConsole("a");
        assertThatThrownBy(() -> {
            inputView.readBridgeSize();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동할_칸_입력받는다() throws Exception {
        initMockClientConsole("U");
        MovingDirection movingDirection = inputView.readMoving();

        assertThat(movingDirection).isEqualTo(U);
    }

    @Test
    void 위_아래_방향외_입력시_예외발생() throws Exception {
        initMockClientConsole("A");
        assertThatThrownBy(() -> {
            inputView.readMoving();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_종료여부를_입력받는다() throws Exception {
        initMockClientConsole("R");
        GameCommand gameCommand = inputView.readGameCommand();
        assertThat(gameCommand).isEqualTo(R);
    }

    @Test
    void R_Q를_제외한_게임_커맨드_입력시_예외발생() throws Exception {
        initMockClientConsole("P");
        assertThatThrownBy(() -> {
            inputView.readGameCommand();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}