package bridge;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    static BridgeGame bridgeGame;
    @BeforeAll
    static void init(){
        bridgeGame = new BridgeGame();
    }

    @Test
    void start_기능_테스트() throws NoSuchFieldException, IllegalAccessException {
        //given
        Field field = bridgeGame.getClass().getDeclaredField("bridge");
        field.setAccessible(true);
        int size = 3;
        //when
        bridgeGame.start(size);
        List<String> bridge = (List<String>) field.get(bridgeGame);
        //then
        assertEquals(3, bridge.size());
    }

    @Test
    void move_테스트() throws NoSuchFieldException, IllegalAccessException {
        //given
        Field field = bridgeGame.getClass().getDeclaredField("bridge");
        field.setAccessible(true);
        //when
        bridgeGame.start(3);
        List<String> bridge = (List<String>) field.get(bridgeGame);
        Map<String,List<String>> resultMap =  bridgeGame.move("U");
        //then
        if (bridge.get(0) == "U"){
            assertEquals(List.of("O"),resultMap.get("upperLine"));
        }
        if (bridge.get(0) == "D"){
            assertEquals(List.of("X"),resultMap.get("upperLine"));
        }
    }


}