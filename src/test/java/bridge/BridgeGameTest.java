package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.Move.IMPOSSIBLE;
import static bridge.Move.POSSIBLE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest {

    @DisplayName("다리 개수 입력에 3~20이 아닐 시 에러")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 21})
    public void inputSizeError(int number) {
        InputValidate inputValidate = new InputValidate();

        assertThatThrownBy(() -> inputValidate.validateBridgeSize(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U/D가 아닌 문자가 들어올 시 에러")
    @Test
    public void inputUDError() {
        InputValidate inputValidate = new InputValidate();

        assertThatThrownBy(() -> inputValidate.validateMove("W"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("R/Q가 아닌 문자가 들어올 시 에러")
    @Test
    public void inputRQError() {
        InputValidate inputValidate = new InputValidate();

        assertThatThrownBy(() -> inputValidate.validateRetry("U"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전진할 수 있는 다리인지 확인")
    @Test
    public void checkAvailableBridge() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));

        Bridge bridge = new Bridge(numberGenerator, 3);
        assertThat(bridge.canGo(1, "D")).isEqualTo(true);
    }

    @DisplayName("Branch클래스가 이동한 기록을 잘 기록하는 지 확인")
    @Test
    public void checkBranchMake() {
        Branch branch = new Branch();

        branch.set(1, POSSIBLE.getNumber());
        branch.set(3, IMPOSSIBLE.getNumber());
        assertThat(branch.getString()).isEqualTo("  | O |   | X");
    }

    @DisplayName("UP/DOWN을 나누어 이동 기록을 잘 기록하는 지 확인")
    @Test
    public void checkMoveRecord() {
        MoveRecord moveRecord = new MoveRecord();

        moveRecord.moveUP(0, true);
        moveRecord.moveDOWN(1, false);
        moveRecord.moveUP(1, true);
        moveRecord.moveUP(2, true);
        assertThat(moveRecord.getString())
                .isEqualTo("[ O | O | O ]\n[   | X |   ]");
    }
}
