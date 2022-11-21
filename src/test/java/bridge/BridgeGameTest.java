package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    //이동 입력값에 따라 적적한 결과가 반환되는지 테스트
    @DisplayName("사용자 이동 입력 결과에 따른 반환값 테스트")
    @Test
    void checkMoveReturnValue() {
        final BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.bridge = new ArrayList<>(List.of("U", "D", "U"));

    }

    //이동 입력값에 따라 적절한 결과가 출력되는지 테스트


    //게임을 재시작 할 때, outputView 필드를 제대로 초기화 하는지 테스트

    //게임을 끝낼때 성공, 실패 여부에 따른 결과를 잘 출력하는지 테스트


    //play메서드에서 2번째 턴 부터 ]대신 |로 잘 바꿔서 출력 되는지 테스트

    //play메서드에서 게임 결과에 따라 적절한 값이 반환되는지 테스트
}

