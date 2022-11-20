package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static String printGameStart = "다리 건너기 게임을 시작합니다.";
    static List<String> bridge = new ArrayList<>();
    static List<String> currentUpState = new ArrayList<>();
    static List<String> currentDownState = new ArrayList<>();
    static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    static String gameCommand = "";
    public static void main(String[] args) {
        System.out.println(printGameStart);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        BridgeGame bridgeGame = new BridgeGame();
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());

        for(int i=0;i<bridge.size();i++){
            String upDown = inputView.readMoving();

            if(upDown.equals("U")){
                currentUpState.add(bridgeGame.move(bridge,i,upDown));
                currentDownState.add(" ");
            }
            if(upDown.equals("D")){
                currentUpState.add(" ");
                currentDownState.add(bridgeGame.move(bridge,i,upDown));
            }
            outputView.printMap(currentUpState,currentDownState);

            if(bridgeGame.move(bridge,i,upDown).equals("X")){
                gameCommand = inputView.readGameCommand();
            }

            if(gameCommand.equals("R")){
                currentUpState.clear();
                currentDownState.clear();
                i=-1;
            }

            if(gameCommand.equals("Q")){
                outputView.printResult(currentUpState,currentDownState,bridge.size());
            }



        }



    }
}
