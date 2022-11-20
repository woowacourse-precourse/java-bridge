package bridge;

import java.util.List;

public class Game {
    int SUCCESS = 1;
    int FAILURE = 0;

    public void Start(List<String> bridge, int bridgeSize){
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame();
        InputView inputView = new InputView();
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
        bridgeGame.retry(bridge, bridgeSize);
    }
}
