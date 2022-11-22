package bridge.domain;

import bridge.constant.GameConstant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTest {

    private User user;

    @BeforeEach
    @DisplayName("user 객체 생성")
    void userInit() {
        user = new User();
    }

    @Test
    @DisplayName("움직인 칸 만큼 시도 횟수가 증가하는지 확인")
    void checkCountMove() {
        List<String> source = List.of("U", "D", "D");
        for (String move : source) {
            user.inputMoveDirection(move);
        }
        Assertions.assertEquals(user.getCountInputMoveDirection() ,source.size());
    }

    @Test
    @DisplayName("움직인 방향에 맞는 숫자가 나오는지 확인")
    void changeMoveDirectionToMoveDirectionNumber(){
        String move = "U";
        user.inputMoveDirection(move);
        Assertions.assertEquals(user.getMoveDirectionNumber(),BridgeDirection.getDirectionNumber(move));
    }

    @Test
    @DisplayName("재시작하면 시도 횟수가 증가하는 확인")
    void checkRetrialCount(){
        int retryCount = 3;
        for(int retry =0 ; retry<retryCount; retry++){
            user.retry();
        }
        Assertions.assertEquals(user.getTrialCount(), GameConstant.START_TRY_COUNT+retryCount);
    }



}