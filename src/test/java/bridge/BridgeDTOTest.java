package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeDTOTest {

    List<String> bridge = new ArrayList<>(List.of("U", "D", "U"));
    BridgeDTO bridgeDTO = new BridgeDTO(bridge);
    @DisplayName("유저의 입력값을 담을 베열을 초기화하고, 현재 정답 시도를 초기화하는 test")
    @Test
    void initBridge() {
        bridgeDTO.initBridge();
        assertThat(bridgeDTO.getUpCase()).containsExactly(BridgeCase.NOTHING, BridgeCase.NOTHING, BridgeCase.NOTHING);
        assertThat(bridgeDTO.getDownCase()).containsExactly(BridgeCase.NOTHING, BridgeCase.NOTHING, BridgeCase.NOTHING);
        assertThat(bridgeDTO.getLength()).isEqualTo(1);
    }
    @DisplayName("정답 다리의 인덱스를 하나한 비교한 후 정답이면, 그에 맞는 O를 대입하는 test")
    @Test
    void move() {
        bridgeDTO.move(0);
        bridgeDTO.move(1);
        bridgeDTO.move(2);
        assertThat(bridgeDTO.getUpCase()).containsExactly(BridgeCase.ANSWER, BridgeCase.NOTHING, BridgeCase.ANSWER);
        assertThat(bridgeDTO.getDownCase()).containsExactly(BridgeCase.NOTHING, BridgeCase.ANSWER, BridgeCase.NOTHING);
    }

    @DisplayName("정답이 아닐때 X를 대입하는 test")
    @Test
    void doNotMove() {
       bridgeDTO.doNotMove("D", 0);
       bridgeDTO.doNotMove("U", 1);
       bridgeDTO.doNotMove("D", 2);
       assertThat(bridgeDTO.getUpCase()).containsExactly(BridgeCase.NOTHING, BridgeCase.WRONG, BridgeCase.NOTHING);
       assertThat(bridgeDTO.getDownCase()).containsExactly(BridgeCase.WRONG, BridgeCase.NOTHING, BridgeCase.WRONG);
    }

    @DisplayName("정답을 맞추고 다음 정답을 맞출때 늘어나는 유저 길이를 get하는 것이 맞는지 확인")
    @Test
    void addLength() {
        bridgeDTO.addLength(1);
        assertThat(bridgeDTO.getLength()).isEqualTo(2);
    }

    @DisplayName("게임 시도 횟수가 늘어난 것을 확인 하는 test")
    @Test
    void increaseCount() {
        bridgeDTO.increaseCount();
        assertThat(bridgeDTO.getCount()).isEqualTo(2);
    }

    @DisplayName("유저의 시도 getter가 잘 되었는지 test")
    @Test
    void getLength() {
        assertThat(bridgeDTO.getLength()).isEqualTo(1);
    }

    @DisplayName("게임횟수 getter가 잘 되었는지 test")
    @Test
    void getCount() {
        assertThat(bridgeDTO.getCount()).isEqualTo(1);
    }

    @DisplayName("정답 bridge getter가 잘 되었는지 test")
    @Test
    void getBridge() {
        assertThat(bridgeDTO.getBridge()).isEqualTo(bridge);
    }

    @Test
    void getUpCase() {
    }

    @Test
    void getDownCase() {
    }

    @Test
    void setLength() {
    }
}