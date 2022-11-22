package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserMoveTest {

         int tryCount = 1;
         int moveCount = 0;
         int userBridgeSize = 0;
         List<String> userLocation = new ArrayList<>();

    @Test
    @DisplayName("시작 시 변수들이 초기화 되었는지 확인")
    void initMove() {

        assertEquals(moveCount, userLocation.size());
    }

    @Test
    void compareMoveCount(){
        assertEquals(moveCount, userLocation.size());
    }
}
