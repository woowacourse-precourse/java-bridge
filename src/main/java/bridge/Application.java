package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        List<List<String>> userMap = new ArrayList<>();
        List<String> up = new ArrayList<>();
        List<String> down = new ArrayList<>();
        userMap.add(up);
        userMap.add(down);
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame(inputView.readBridgeSize());
        System.out.println();
        bridgeGame.playGame(userMap);
    }
}
