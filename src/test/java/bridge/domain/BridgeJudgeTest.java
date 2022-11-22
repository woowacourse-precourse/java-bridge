package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeJudgeTest {

    private BridgeJudge bridgeJudge;

    @BeforeEach
    void init() {
        bridgeJudge = new BridgeJudge();
    }

    @DisplayName("bridge가 정상적으로 BridgeJudge 객체에 인스턴스 변수로 저장된다.")
    @Test
    void addBridgeTest() {
        //given
        List<String> bridge = List.of("U", "D", "U");
        //when
        bridgeJudge.addBridge(bridge);
        List<String> findBridge = bridgeJudge.getBridge();
        //then
        assertThat(findBridge).containsExactly("U", "D", "U");
    }

    @DisplayName("getter로 찾은 bridge를 변경하면 예외가 발생한다.")
    @Test
    void getBridgeTest() {
        //given
        List<String> bridge = new ArrayList<>();
        bridgeJudge.addBridge(bridge);
        List<String> findBridge = bridgeJudge.getBridge();
        //when, then
        assertThatThrownBy(() -> findBridge.add("U"))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("플레이어의 이동경로와 Brige가 다르면 ture를, 같으면 false를 리턴한다..")
    @Test
    void isFailToMoveTest() {
        //given
        List<String> bridge = Arrays.asList("U", "U", "D");
        bridgeJudge.addBridge(bridge);
        List<String> moveHistory1 = Arrays.asList("U", "D");
        List<String> moveHistory2 = Arrays.asList("U","U","D");
        //when
        boolean result1 = bridgeJudge.isFailToMove(moveHistory1);
        boolean reulst2 = bridgeJudge.isFailToMove(moveHistory2);
        //then
        assertThat(result1).isEqualTo(true);
        assertThat(reulst2).isEqualTo(false);
    }

    @DisplayName("플레이어가 Bridge 이동을 성공적으로 완료하면 true를 그렇지 않으면 false를 리턴한다")
    @Test
    void isCompleteToMove() {
        //given
        List<String> bridge = Arrays.asList("U", "U", "D");
        bridgeJudge.addBridge(bridge);
        List<String> moveHistory1 = Arrays.asList("U", "U");
        List<String> moveHistory2 = Arrays.asList("U","U","U");
        List<String> moveHistory3 = Arrays.asList("U","U","D");
        //when
        boolean result1 = bridgeJudge.isCompleteToMove(moveHistory1);
        boolean result2 = bridgeJudge.isCompleteToMove(moveHistory2);
        boolean result3 = bridgeJudge.isCompleteToMove(moveHistory3);
        //then
        assertThat(result1).isEqualTo(false);
        assertThat(result2).isEqualTo(false);
        assertThat(result3).isEqualTo(true);
    }
}
