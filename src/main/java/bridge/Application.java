package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
    }

    public static void gameStart() {
        printStartMessage();
        InputView inputView = new InputView();
        BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> answer_list = bm.makeBridge(inputView.readBridgeSize());

        System.out.println(answer_list);

        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(inputView, answer_list);


    }

    public static void printStartMessage(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요.");
    }
}
