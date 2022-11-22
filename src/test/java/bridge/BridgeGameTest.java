package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BridgeGameTest {

    @DisplayName("move 호출 시 사용자 입력은 userInput 리스트에 추가되어야 한다.")
    @Test
    public void moveTest_userList() {
        //given
        BridgeGame testGame = new BridgeGame();
        testGame.bridge = Arrays.asList("U");
        String movement = "U";
        List<String> expectedList = Arrays.asList("U");

        //when
        testGame.move(movement);
        //then

        Assertions.assertIterableEquals(expectedList, testGame.getUserInput());
    }

    @DisplayName("move 호출 시 userInput과 정답 다리 를 비교하고 일치여부를 반환한다.")
    @Test
    public void moveTest_checkIfSame() {
        //given
        BridgeGame testGame = new BridgeGame();
        testGame.bridge = Arrays.asList("U");
        String movement = "U";
        boolean expectedValue = true;
        //when
        boolean actualValue = testGame.move(movement);

        //then
        Assertions.assertEquals(expectedValue, actualValue);
    }

}
