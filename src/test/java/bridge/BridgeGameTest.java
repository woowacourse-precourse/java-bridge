package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @DisplayName("사용자가 'U'나 'D'가 아닌 값을 입력했는지 확인한다.")
    @ValueSource(strings = {"u","🍖","d"})
    @Test
    void validate_Is_There_Only_Up_And_Down(InputView input) {
        assertThatThrownBy(()-> new BridgeGame(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("사용자가 (char)85, (char)68로 U, D를 입력하는지 확인한다.")
    @ValueSource(chars = {(char)85,(char)68})
    @Test
    void validate_Is_Unintentional_Character_Input(InputView input) {
        assertThatThrownBy(()-> new BridgeGame(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("사용자가 U, D를 입력할 때 공백을 넣으면 자동으로 트리밍하여 예외처리가 발생하지 않도록 한다.")
    @ValueSource(strings = {" U","D "," U "})
    @Test
    void validate_Is_Acceptable_Blank_Input_Of_Character(InputView input) {
        assertThatThrownBy(()-> new BridgeGame(input))
                .isNotInstanceOf(IllegalArgumentException.class)
                .hasMessageNotContaining("[ERROR]");
    }

    // 가구현
    @DisplayName("캐릭터의 이동 방향이 항상 왼쪽에서 오른쪽인지 확인한다.")
    @Test
    void validate_Is_Direction_From_Left_To_Right() {
        assertThatThrownBy(()-> new BridgeGame())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("캐릭터가 위 아래 둘 중 하나의 칸만 이동하는지 확인한다.")
    @Test
    void validate_Is_One_Step_At_Once() {
        assertThatThrownBy(()-> new BridgeGame())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("사용자가 재시도를 할 때 'R'나 'Q'가 아닌 값을 입력했는지 확인한다.")
    @ValueSource(strings = {"r","🍖","q"})
    @Test
    void validate_Is_There_Only_R_And_Q() {
        assertThatThrownBy(()-> BridgeGame.retry())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("사용자가 재시도를 할 때 'R'나 'Q'가 아닌 값을 입력했는지 확인한다.")
    @ValueSource(chars = {(char) 82, (char)81})
    @Test
    void validate_Is_Unintentional_Retry_Input() {
        assertThatThrownBy(()-> BridgeGame.retry())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("사용자가 재시도를 할 때 ' R'나 ' Q '등 공백값을 넣을 시 자동으로 트리밍하는지 확인한다.")
    @ValueSource(strings = {" R", " Q"})
    @Test
    void validate_Is_Acceptable_Blank_Input_Of_Retry() {
        assertThatThrownBy(()-> BridgeGame.retry())
                .isNotInstanceOf(IllegalArgumentException.class)
                .hasMessageNotContaining("[ERROR]");
    }

    @DisplayName("사용자가 재시도를 할 때 재시도가 정상적으가 이루어지는지 확인한다.")
    @ValueSource(strings = {"R"})
    @Test
    void validate_Is_Retry_Available() {
        assertThatThrownBy(()-> BridgeGame.retry())
                .hasMessageStartingWith("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    @DisplayName("사용자가 재시도를 할 때 이전에 만들어둔 다리를 사용하는지 확인한다.")
    @ValueSource(strings = {/*게임 시작 후 다리 선택, 실패 발생,*/"R"})
    @Test
    void validate_Is_Bridge_Reusable(String input) {
        assertThatThrownBy(()-> //게임 시작 메서드(input), 10 번째 다리까지 성공, 11차 시도 실패 입력
                BridgeGame.retry())
                //재시작 후 10 번째 다리 성공, 11차 시도 이전과 다른 값으로 입력 후 성공
                //이후 성공 확인 메세지 확인
                //다리에 값을 저장하는 객체가 있다면 확인
                .hasMessageStartingWith(/*성공메세지 확인*/"이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    @DisplayName("사용자가 다리 끝에 도달하면 게임이 정상적으로 종료되는지 확인한다.")
    @ValueSource(strings = {/*게임 시작 후 다리 선택, 다리 끝 도달,*/})
    @Test
    void validate_Is_Game_Finished_As_Intended(String input) {
        assertThatThrownBy(()-> //게임 시작 메서드(input), 10 번째 다리까지 성공,끝
                BridgeGame.start())
                //재시작 후 10 번째 다리 성공, 11차 시도 이전과 다른 값으로 입력 후 성공
                //이후 성공 확인 메세지 확인
                //다리에 값을 저장하는 객체가 있다면 확인
                .hasMessageStartingWith("최종 게임 결과");
    }

    @DisplayName("게임 결과에서 총 시도한 횟수가 올바른지 확인한다.")
    @ValueSource(ints = {/*게임 시작 후 2차례 실패 뒤 3차례에 성공*/})
    @Test
    void validate_Are_Trials_Alright(int input) {
        assertThatThrownBy(()-> //게임 시작 메서드(input), 재시도, 재시도, 3 번째에 성공,끝
                BridgeGame.start())
                //재시작 후 3번째 성공
                //이후 성공 확인 메세지 확인
                //다리에 값을 저장하는 객체가 있다면 확인
                .hasMessageContainingWith("최종 게임 결과", "총 시도한 횟수: 3");
    }
}