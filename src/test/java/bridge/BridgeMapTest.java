package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMapTest {
    @Test
    @DisplayName("초기 설정 후 String 변환값 비교")
    void initAndToString() throws Exception {
        //given
        BridgeMap bridgeMap = new BridgeMap();
        String expect = "[  ]\n" +
                        "[  ]\n";
        //when
        String result = bridgeMap.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }
    @Test
    @DisplayName("위 아래로 번갈아가며 3번 씩 이동 성공시")
    void upDownRepeat3times() throws Exception {
        //given
        BridgeMap bridgeMap = new BridgeMap();
        String expect = "[ O |   | O |   | O |   ]\n" +
                        "[   | O |   | O |   | O ]\n";
        //when
        bridgeMap.moveSuccess(Command.UP);
        bridgeMap.moveSuccess(Command.DOWN);
        bridgeMap.moveSuccess(Command.UP);
        bridgeMap.moveSuccess(Command.DOWN);
        bridgeMap.moveSuccess(Command.UP);
        bridgeMap.moveSuccess(Command.DOWN);
        String result = bridgeMap.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("위 아래로 번갈아가며 2번 씩 이동 후 마지막 위로 이동 실패시")
    void upDownRepeat2timeAndFailMoveUp() throws Exception {
        //given
        BridgeMap bridgeMap = new BridgeMap();
        String expect = "[ O |   | O |   | X ]\n" +
                        "[   | O |   | O |   ]\n";
        //when
        bridgeMap.moveSuccess(Command.UP);
        bridgeMap.moveSuccess(Command.DOWN);
        bridgeMap.moveSuccess(Command.UP);
        bridgeMap.moveSuccess(Command.DOWN);
        bridgeMap.moveFail(Command.UP);
        String result = bridgeMap.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("위 아래로 번갈아가며 2번 씩 이동 후 마지막 아래로 이동 실패시")
    void upDownRepeat2timeAndFailMoveDown() throws Exception {
        //given
        BridgeMap bridgeMap = new BridgeMap();
        String expect = "[ O |   | O |   |   ]\n" +
                        "[   | O |   | O | X ]\n";
        //when
        bridgeMap.moveSuccess(Command.UP);
        bridgeMap.moveSuccess(Command.DOWN);
        bridgeMap.moveSuccess(Command.UP);
        bridgeMap.moveSuccess(Command.DOWN);
        bridgeMap.moveFail(Command.DOWN);
        String result = bridgeMap.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }
}