package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize = inputView.readBridgeSize(inputView.readline());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        while (true){
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String readMove = inputView.readMoving(inputView.readline());
            boolean move = bridgeGame.move(bridge, readMove);
            outputView.printMap(readMove, move);
            bridgeGame.index++;
            if (!move) {
                break ;
            }
        }
        if (bridgeGame.index == bridgeSize){
            outputView.printResult();
            return ;
        }
        String retry = inputView.readGameCommand(inputView.readline());
        if (retry.equals("Q")){
            outputView.printResult();
            return ;
        }
        bridgeGame.retry();
    }
}
