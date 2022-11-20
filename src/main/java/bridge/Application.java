package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        int SUCCESS = 1;
        int FAILURE = 0;
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
        System.out.println(bridge);
        while (true){
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String readMove = inputView.readMoving(inputView.readline());
            boolean move = bridgeGame.move(bridge, readMove);
            outputView.printMap(readMove, move);
            bridgeGame.index++;
            if (bridgeGame.index == bridgeSize || !move) {
                break ;
            }
        }
        if (bridgeGame.index == bridgeSize){
            outputView.printResult(SUCCESS);
            return ;
        }
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String retry = inputView.readGameCommand(inputView.readline());
        if (retry.equals("Q")){
            outputView.printResult(FAILURE);
            return ;
        }
        bridgeGame.retry();
    }
}
