package bridge.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RefereeTest {

    private Referee referee = new Referee();

    @DisplayName("U를 입력하고 다리건너기가 성공하여 윗다리에 O, 아랫다리에 공백을 표시한다.")
    @Test
    void 사용자_윗다리_입력_게임_성공_매치_테스트(){
        referee.addPlayerChoiceResult(List.of("U","D","U"), "U", 0);
        Assertions.assertEquals(referee.getUpSideBridgeResult().containsAll(List.of("O")), true);
        Assertions.assertEquals(referee.getDownSideBridgeResult().containsAll(List.of(" ")), true);
        Assertions.assertEquals(Referee.succeed, true);
    }

    @DisplayName("U를 입력하고 다리건너기가 실패하여 윗다리에 X, 아랫다리에 공백을 표시한다.")
    @Test
    void 사용자_윗다리_입력_게임_실패_매치_테스트(){
        referee.addPlayerChoiceResult(List.of("D","D","U"), "U", 0);
        Assertions.assertEquals(referee.getUpSideBridgeResult().containsAll(List.of("X")), true);
        Assertions.assertEquals(referee.getDownSideBridgeResult().containsAll(List.of(" ")), true);
        Assertions.assertEquals(Referee.succeed, false);
    }

    @DisplayName("D를 입력하고 다리건너기가 성공하여 윗다리에 공백, 아랫다리에 O를 표시한다.")
    @Test
    void 사용자_아래다리_입력_게임_성공_매치_테스트(){
        referee.addPlayerChoiceResult(List.of("D","D","U"), "D", 0);
        Assertions.assertEquals(referee.getUpSideBridgeResult().containsAll(List.of(" ")), true);
        Assertions.assertEquals(referee.getDownSideBridgeResult().containsAll(List.of("O")), true);
        Assertions.assertEquals(Referee.succeed, true);
    }

    @DisplayName("D를 입력하고 다리건너기가 실패하여 윗다리에 공백, 아랫다리에 X를 표시한다.")
    @Test
    void 사용자_아래다리_입력_게임_실패_매치_테스트(){
        referee.addPlayerChoiceResult(List.of("U","D","U"), "D", 0);
        Assertions.assertEquals(referee.getUpSideBridgeResult().containsAll(List.of(" ")), true);
        Assertions.assertEquals(referee.getDownSideBridgeResult().containsAll(List.of("X")), true);
        Assertions.assertEquals(Referee.succeed, false);
    }
}