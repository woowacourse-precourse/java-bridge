package bridge.domain.result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeResultTest {

    @DisplayName("다리의 위칸을 올바르게 건넜다면 위칸에서 O를 반환한다.")
    @Test
    void goToNextUpBlockReturnCorrect() {
        //given
        BridgeResult resultBridge = new BridgeResult();
        //when
        resultBridge.addBlock("U", "O");
        //then
        assertThat(resultBridge.toString()).isEqualTo("[ O ]\n[   ]\n");
    }

    @DisplayName("다리의 아래칸을 올바르게 건넜다면 아래칸에서 O를 반환한다.")
    @Test
    void goToNextDownBlockReturnCorrect() {
        //given
        BridgeResult resultBridge = new BridgeResult();
        //when
        resultBridge.addBlock("D", "O");
        //then
        assertThat(resultBridge.toString()).isEqualTo("[   ]\n[ O ]\n");
    }

    @DisplayName("다리의 위칸을 건너는 것을 실패했다면 위칸에서 X를 반환한다.")
    @Test
    void failToGoNextUpBlockReturnWrong() {
        //given
        BridgeResult resultBridge = new BridgeResult();
        //when
        resultBridge.addBlock("U", "X");
        //then
        assertThat(resultBridge.toString()).isEqualTo("[ X ]\n[   ]\n");
    }

    @DisplayName("다리의 아래칸을 건너는 것을 실패했다면 아래칸에서 X를 반환한다.")
    @Test
    void failToGoNextDownBlockReturnWrong() {
        //given
        BridgeResult resultBridge = new BridgeResult();
        //when
        resultBridge.addBlock("D", "X");
        //then
        assertThat(resultBridge.toString()).isEqualTo("[   ]\n[ X ]\n");
    }

    @DisplayName("현재까지 3개의 다리를 올바르게 건넜다면 올바르게 건넌 개수인 3을 반환한다.")
    @Test
    void crossThreeCorrectBlockCount() {
        //given
        BridgeResult resultBridge = new BridgeResult();

        resultBridge.addBlock("D", "O");
        resultBridge.addBlock("D", "O");
        resultBridge.addBlock("U", "O");
        //when
        int correctCount = resultBridge.countCorrectCrossing();
        //then
        assertThat(correctCount).isEqualTo(3);
    }

    @DisplayName("현재까지 2개의 다리를 올바르게 건너고 1개의 다리를 올바르게 건너지 못했다면 올바르게 건넌 개수인 2를 반환한다.")
    @Test
    void crossTwoCorrectBlockCount() {
        //given
        BridgeResult resultBridge = new BridgeResult();

        resultBridge.addBlock("U", "O");
        resultBridge.addBlock("D", "O");
        resultBridge.addBlock("U", "X");
        //when
        int correctCount = resultBridge.countCorrectCrossing();
        //then
        assertThat(correctCount).isEqualTo(2);
    }

    @DisplayName("현재 건넌 다리가 초기화 되는지 확인한다.")
    @Test
    void clearBridgeResult() {
        //given
        BridgeResult resultBridge = new BridgeResult();

        resultBridge.addBlock("U", "O");
        resultBridge.addBlock("D", "X");
        //when
        resultBridge.clear();
        //then
        assertThatThrownBy(resultBridge::toString)
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}