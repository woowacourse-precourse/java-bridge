package bridge.controller;

import bridge.BridgeMaker;
import bridge.CompareBridge;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {
    OutputView outputView;
    InputView inputView;
    BridgeMaker bridgeMaker;
    CompareBridge compareBridge;
    public void game() {
        boolean game = true;
        String result = "실패";
        int count = 1;
        while (game) {
            outputView.printStart();
            List<String> com = new ArrayList<>(bridgeMaker.makeBridge(inputView.readBridgeSize()));
            List<String> user = new ArrayList<>();
            List<String> up= new ArrayList<>();
            List<String> down= new ArrayList<>();
            while (true) {
                user.add(inputView.readMoving());
                String userData = user.get(user.size() - 1);
                String comData = com.get(user.size() - 1);
                String ox = compareBridge.validateBridge(userData, comData);
                if (ox.equals("O")) {
                    if (userData.equals("U")) {
                        up.add(ox);
                        down.add(" ");
                    } else if (userData.equals("D")) {
                        down.add(ox);
                        up.add(" ");
                    }
                } else if (ox.equals("X")) {
                    if (userData.equals("U")) {
                        up.add(ox);
                        down.add(" ");
                    } else if (userData.equals("D")) {
                        down.add(ox);
                        up.add(" ");
                    }
                }
                outputView.printMap(up);
                outputView.printMap(down);
                if (user.size() == com.size()) {
                    result = "성공";
                    outputView.printResult(up, down, result, count);
                    game = false;
                    break;
                } else if (ox.equals("X")) {
                    String re = inputView.readGameCommand();
                    if (re.equals("Q")) {
                        outputView.printResult(up, down, result, count);
                    } else if (re.equals("R")) {
                        count++;
                    }
                }
            }
        }
    }
}
