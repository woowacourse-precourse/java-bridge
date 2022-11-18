package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    OutputView printMessage = new OutputView();
    InputView inputView = new InputView();
    private int bridgeLength = 1;
    private int gameCount = 1;

    public static void main(String[] args) {
        BridgeGame test = new BridgeGame();
        test.play();
    }
    public void play(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        printMessage.printStart();
        printMessage.printAskBridgeLength();
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize(Console.readLine()));
        System.out.println(bridge);
        gameLogic(bridge);
    }
    public boolean move(int [] upCase, int [] downCase, String answerBridge, String moveCommand, int i) {
        if(answerBridge.equals(moveCommand)){
            if(answerBridge.equals("U")){
                upCase[i] += 1;
            }
            if(answerBridge.equals("D")){
                downCase[i] += 1;
            }
            return true;
        }
        return false;
    }
    public void dontMove(int [] upCase, int [] downCase, List<String> bridge, String input, int i){
        if(input.equals("U")) {
            upCase[i] += 2;
        }
        if(input.equals("D")) {
            downCase[i] += 2;
        }
        printMessage.printMap(upCase, downCase, bridgeLength);
        printMessage.printAskGameRestart();
        retry(upCase, downCase, bridge);
    }
    public void retry(int [] upCase, int [] downCase, List<String> bridge) {
        if(inputView.readGameCommand(Console.readLine()).equals("R")) {
            gameCount += 1;
            gameLogic(bridge);
            return ;
        }
        printMessage.printFailedResult(upCase, downCase, gameCount, bridgeLength);
    }
    public void gameLogic(List<String> bridge){
        int [] upCase = new int[bridge.size()];
        int [] downCase = new int[bridge.size()];
        bridgeLength = 1;
        bridgeMatch(upCase, downCase, bridge);
    }
    public void bridgeMatch(int [] upCase, int [] downCase, List<String> bridge){
        for (int i = 0; i < bridge.size(); i++) {
            printMessage.printAskMovingButton();
            String input = inputView.readMoving(Console.readLine());
            if(!move(upCase, downCase, bridge.get(i), input, i)){
                dontMove(upCase, downCase, bridge, input, i);
                return;
            }
            printMessage.printMap(upCase, downCase, bridgeLength);
            bridgeLength += 1;
        }
        printMessage.printSuccessedResult(upCase, downCase, gameCount);
    }
}
