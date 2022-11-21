package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Test
    void Up_을_선택한_경우_출력_테스트() {
        List<String> bridge = new ArrayList<>(List.of("U","U","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        OutputView outputView = new OutputView();
        bridgeGame.move("U");
        List<String> upBoardCheckList = bridgeGame.getUpBoardCheckList();
        List<String> downBoardCheckList = bridgeGame.getDownBoardCheckList();
        String result = outputView.printMap(upBoardCheckList, downBoardCheckList);
        Assertions.assertThat(result).isEqualTo("[ O ]\n[   ]\n");
    }

    @Test
    void Down_을_선택한_경우_출력_테스트() {
        List<String> bridge = new ArrayList<>(List.of("D","U","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        OutputView outputView = new OutputView();
        bridgeGame.move("D");
        List<String> upBoardCheckList = bridgeGame.getUpBoardCheckList();
        List<String> downBoardCheckList = bridgeGame.getDownBoardCheckList();
        String result = outputView.printMap(upBoardCheckList, downBoardCheckList);
        Assertions.assertThat(result).isEqualTo("[   ]\n[ O ]\n");
    }

    @Test
    void 틀린_경우_Up_출력_테스트() {
        List<String> bridge = new ArrayList<>(List.of("D","U","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        OutputView outputView = new OutputView();
        bridgeGame.move("U");
        List<String> upBoardCheckList = bridgeGame.getUpBoardCheckList();
        List<String> downBoardCheckList = bridgeGame.getDownBoardCheckList();
        String result = outputView.printMap(upBoardCheckList, downBoardCheckList);
        Assertions.assertThat(result).isEqualTo("[ X ]\n[   ]\n");
    }

    @Test
    void 틀린_경우_Down_출력_테스트() {
        List<String> bridge = new ArrayList<>(List.of("U","U","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        OutputView outputView = new OutputView();
        bridgeGame.move("D");
        List<String> upBoardCheckList = bridgeGame.getUpBoardCheckList();
        List<String> downBoardCheckList = bridgeGame.getDownBoardCheckList();
        String result = outputView.printMap(upBoardCheckList, downBoardCheckList);
        Assertions.assertThat(result).isEqualTo("[   ]\n[ X ]\n");
    }
}