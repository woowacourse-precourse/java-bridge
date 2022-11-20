package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class Application {
    public static InputView inputView = new InputView();
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
        for(int i = 0; i < inputView.getSize(); i++){
            inputView.readMoving();
            System.out.println(inputView.getMove());
            bridgeGame.resultBridge(inputView.getMove());
            if(checkAnswerLength(inputView.getMove().size(), bridgeGame.getBridgeAnswer().size()))
                InputView.readGameCommand();
        }

    }

    public static Boolean checkAnswerLength(int a, int b){
        return a==b;
    }



}
