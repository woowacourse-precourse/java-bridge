package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class Application {
    public static InputView inputView = new InputView();
    public static OutputView outputView = new OutputView();
    final static BridgeGame bridgeGame = new BridgeGame();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        initState();
        System.out.println("다리 건너기 게임을 시작합니다.");
        createBridge();


    }

    public static void initState(){
        OutputView.now_size = 0;
        InputView.size = 0;
    }

    public static void createBridge(){
        InputView inputView = new InputView();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        inputView.readBridgeSize();
        bridgeMaker.makeBridge(inputView.getSize());
        System.out.println(BridgeGame.bridge_answer);
        playBridgeGame();
    }

    public static void playBridgeGame(){
        String a = "";
        outputView.initNowSize();
        inputView.clearMove();
        for(OutputView.now_size = 0; OutputView.now_size < BridgeGame.bridge_answer.size(); OutputView.now_size++){
            inputView.readMoving();
            System.out.println(inputView.getMove());
            bridgeGame.resultBridge(inputView.getMove());
            outputView.printResult();
            if(checkAnswerLength(inputView.getMove().size(), bridgeGame.getBridgeAnswer().size())) {
                a = InputView.readGameCommand();
                inputView.checkGameCommand(a);
                break;
            }
        }

    }

    public static Boolean checkAnswerLength(int a, int b){
        return a==b;
    }



}
