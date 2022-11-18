package bridge;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BridgeGameTest {
    private Bridge bridge;
    private List<Boolean> gameState;
    private User user;


    @Test
    void 다리길이_설정_기능_테스트() {
        int bridgeSize = 3;
        bridge = new Bridge(bridgeSize);
        assertEquals(3, bridge.getBrideState().size());
    }

    @Test
    void 사용자_이동_기능_테스트(){
        int bridgeSize = 3;
        user = new User(bridgeSize);
        user.move("U");
        assertEquals(0, user.getUserCurrentLocation());
        user.move("D");
        assertEquals(1, user.getUserCurrentLocation());
    }

    void updateGameState(String direction){
        if(bridge.getBrideState().get(user.getUserCurrentLocation()).equals(direction)){
            gameState.add(true);
            return;
        }
        gameState.add(false);
    }
    @Test
    void 게임_상태_업데이트_기능(){
        int bridgeSize = 3;
        bridge = new Bridge(bridgeSize);
        user = new User(bridgeSize);
        gameState = new ArrayList<>(bridgeSize);

        String answer = bridge.getBrideState().get(0);
        user.move(answer);
        updateGameState(answer);
        assertTrue(gameState.get(gameState.size() - 1));

        answer = "U";
        if(bridge.getBrideState().get(1) == "U")
            answer = "D";
        user.move(answer);
        updateGameState(answer);
        assertFalse(gameState.get(gameState.size() - 1));
    }

    boolean gameFailState(){
        if(!gameState.isEmpty() && !gameState.get(gameState.size() - 1)){
            return true;
        }
        return false;
    }

    boolean gameSuccessState(){
        if(gameState.size() == bridge.getBrideSize() && gameState.get(gameState.size() - 1))
            return true;
        return false;
    }
    boolean gameExit(){
        if(gameFailState() || gameSuccessState()){
            return true;
        }
        return false;
    }
    @Test
    void 게임_종료_상태_확인_기능(){
        int bridgeSize = 3;
        bridge = new Bridge(bridgeSize);
        user = new User(bridgeSize);
        gameState = new ArrayList<>(bridgeSize);

        String answer = bridge.getBrideState().get(0);
        user.move(answer);
        updateGameState(answer);
        assertTrue(gameState.get(gameState.size() - 1));
        assertFalse(gameExit());

        answer = "U";
        if(bridge.getBrideState().get(1) == "U")
            answer = "D";
        user.move(answer);
        updateGameState(answer);
        assertFalse(gameState.get(gameState.size() - 1));
        assertTrue(gameExit());
    }
}
