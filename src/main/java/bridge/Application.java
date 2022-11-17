package bridge;

import bridge.control.InputView;
import bridge.control.OutputView;
import bridge.game.BridgeGame;
import java.util.List;

public class Application {
    private static String input_move;
    private static List<List<String>> bridge;
    public static void main(String[] args) {
        // 다리 길이 받기(한번만 받으면 됨) / 출력
        InputView new_input_view = new InputView();
        OutputView new_Output_view = new OutputView();
        int input_bridge_length = new_input_view.readBridgeSize();
        // 무빙, 재시도, 종료 / 초기화 다리 길이
        BridgeGame new_bridge_game = new bridge.game.BridgeGame(input_bridge_length);
        // 메인 게임
        while(new_bridge_game.go_stop){
            input_move = new_input_view.readMoving();
            bridge = new_bridge_game.move(input_move, bridge);
            new_Output_view.printMap(bridge);
        }
        new_Output_view.printResult(bridge);
    }
}
