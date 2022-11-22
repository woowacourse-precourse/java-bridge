package bridge.service;

import bridge.constant.GameConstant;
import bridge.domain.Map;
import bridge.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameServiceTest {
    private GameService gameService;

    @BeforeEach
    @DisplayName("길이가 3인 다리 생성 후 게임 생성")
    void makeBridge(){
        List<String> bridge = new ArrayList<>(List.of("U","U","U"));
        gameService = new GameService(bridge,new User(),new Map());
    }

    @Test
    @DisplayName("이동에 따른 Map 결과 확인")
    void checkMoveFromMap(){
        List<String> move = new ArrayList<>(List.of("U", "U", "D"));
        for (int i = 0; i < 3; i++) {
            gameService.move(move.get(i));
        }
        List<String> up = List.of("O", "O"," ");
        List<String> down = List.of(" ", " ","X");
        List<List<String>> inputMap = new ArrayList<>(List.of(down, up));
        Assertions.assertEquals(gameService.getMap(),inputMap);

    }

    @Test
    @DisplayName("다리 통과 확인")
    void checkClearGame(){
        List<String> move = new ArrayList<>(List.of("U", "U", "U"));
        for (int i = 0; i < 3; i++) {
            gameService.move(move.get(i));
            if(!gameService.canKeepGoingGame()){
                break;
            }
        }
        Assertions.assertEquals(gameService.getGameResult(), GameConstant.CLEAR);
    }

    @Test
    @DisplayName("다리 불통과 확인")
    void checkFailGame(){
        List<String> move = new ArrayList<>(List.of("U", "D", "U"));
        for (int i = 0; i < 3; i++) {
            gameService.move(move.get(i));
            if(!gameService.canKeepGoingGame()){
                break;
            }
        }
        Assertions.assertEquals(gameService.getGameResult(), GameConstant.FAIL);
    }




}
