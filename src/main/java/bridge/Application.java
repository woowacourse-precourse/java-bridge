package bridge;

import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        BridgeGame bridgeGame;

        // 다리 길이 입력 및 생성
        ArrayList<String> answerBridge = new ArrayList<>(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        bridgeGame = new BridgeGame(answerBridge, new User());

        // 이동할 칸 생성
        String retryValue = "R";
        int temp = 0;
        while(temp < 4){
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getUser().getUserBridge());
            temp++;
            // x 가 나온다면 -> 재시작 여부를 물어봄
            // x 가 나온다면, 재시작시 x를 제외한 상태가 필요하므로 그 전 상태를 저장할 필요가 있다.
            // 재시작시 게임 시도 횟수를 증가해야한다.
        }
    }
}
