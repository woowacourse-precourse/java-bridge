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
        String upMap = outputView.getUpMap(upBoardCheckList);
        Assertions.assertThat(upMap).isEqualTo("[ O ]\n");
    }

    @Test
    void Down_을_선택한_경우_출력_테스트() {
        List<String> bridge = new ArrayList<>(List.of("U","U","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        OutputView outputView = new OutputView();
        bridgeGame.move("U");
        List<String> downBoardCheckList = bridgeGame.getDownBoardCheckList();
        String upMap = outputView.getUpMap(downBoardCheckList);
        Assertions.assertThat(upMap).isEqualTo("[   ]\n");
    }

    @Test
    void 틀린_경우_Up_출력_테스트() {
        List<String> bridge = new ArrayList<>(List.of("U","U","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        OutputView outputView = new OutputView();
        bridgeGame.move("D");
        List<String> upBoardCheckList = bridgeGame.getUpBoardCheckList();
        String upMap = outputView.getUpMap(upBoardCheckList);
        Assertions.assertThat(upMap).isEqualTo("[   ]\n");
    }

    @Test
    void 틀린_경우_Down_출력_테스트() {
        List<String> bridge = new ArrayList<>(List.of("U","U","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        OutputView outputView = new OutputView();
        bridgeGame.move("D");
        List<String> downBoardCheckList = bridgeGame.getDownBoardCheckList();
        String upMap = outputView.getUpMap(downBoardCheckList);
        Assertions.assertThat(upMap).isEqualTo("[ X ]\n");
    }
}