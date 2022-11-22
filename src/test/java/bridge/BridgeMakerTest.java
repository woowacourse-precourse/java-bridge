package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {

    @DisplayName("다리의 길이로 입력받은 값이 정수형인지 확인한다.")
    @ValueSource(strings = {"문자","🍖"})
    @Test
    void validate_Is_Number(BridgeNumberGenerator input) {
        assertThatThrownBy(()-> new BridgeMaker(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("다리의 길이로 입력받은 값이 \"(int)48~ (int)57\"과 같은 형식인지 확인한다.")
    @ValueSource(ints = {(int)51,(int)57})
    @Test
    void validate_unintentional_Way_Of_Input(BridgeNumberGenerator input) {
        assertThatThrownBy(()-> new BridgeMaker(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("다리의 길이로 입력받은 값이 정수형으로 3 이상 20 이하인지 확인한다.")
    @ValueSource(ints = {2,-3, 0, 21,})
    @Test
    void validate_Is_Number_In_Range(BridgeNumberGenerator input) {
        assertThatThrownBy(()-> new BridgeMaker(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("다리의 길이로 입력받은 값이 없거나 공백인지 확인한다.")
    @ValueSource(strings = {""," "})
    @Test
    void validate_Is_Number_Blank(BridgeNumberGenerator input) {
        assertThatThrownBy(()-> new BridgeMaker(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
    @DisplayName("다리의 길이로 입력받은 값에 공백값이 섞였을 시 자동으로 트리밍하여 예외처리하지 않는다.")
    @ValueSource(strings = {"3 "," 5"," 20 ","              19    "})
    @Test
    void validate_Is_Blank_Acceptable(BridgeNumberGenerator input) {
        assertThatThrownBy(()-> new BridgeMaker(input))
                .isNotInstanceOf(IllegalArgumentException.class)
                .hasMessageNotContaining("[ERROR]");
    }

    @DisplayName("건널 수 있는 칸에 0과 1 이외에 다른 값이 넘어오는지 확인한다.")
    @ValueSource(strings = {"2","-1","-0"})
    @Test
    void validate_Is_One_Or_Zero() {
        assertThatThrownBy(()-> BridgeMaker.validateGetOneOrZero())
                .isNotInstanceOf(IllegalArgumentException.class)
                .hasMessageNotContaining("[ERROR]");
    }

    @DisplayName("0과 1을 무작위로 얻어낼 확률이 50:50 인지 확인한다.")
    @Test
    void check_Even_Chance() {
        double trials=0;
        double Zero=0;
        while(trials!=100000000){
            if(BridgeMaker.getOneOrZero()==0){
                Zero++;
            }
            trials++;
        }

        assertThat(Math.round(Zero/trials)*2).isEqualTo(1);
    }

    @DisplayName("값이 0인 경우 아래칸 1인 경우 위칸이 건널 수 있는 칸이 되는지 확인한다.")
    @ValueSource(ints = {0,1})
    @Test
    void validate_Is_Zero_Down_And_One_Up(int input) {
        assertThatThrownBy(()-> BridgeMaker.validateIsZeroDownAndOneUp(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D로 나타내는지 확인한다.")
    @ValueSource(ints = {0,1})
    @Test
    void validate_Is_D_Down_And_U_Up(int input) {
        assertThatThrownBy(()-> BridgeMaker.validateIsZeroDownAndOneUp(input))
                .isEqualTo('D', 'U');
    }

}