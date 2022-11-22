package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(()->0);
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        CompareBridge compareBridge = new CompareBridge();

        boolean game = true;
        String result = "실패";
        int count = 1;

        // TODO: 프로그램 구현
        try {
            while (game) {
                outputView.printStart();
                List<String> com = new ArrayList<>(bridgeMaker.makeBridge(inputView.readBridgeSize()));
                System.out.println(com);
                List<String> user = new ArrayList<>();
                List<String> up = new ArrayList<>();
                List<String> down = new ArrayList<>();
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
                            game = false;
                            break;
                        } else if (re.equals("R")) {
                            count++;
                            break;
                        }
                    }
                }
            }
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
