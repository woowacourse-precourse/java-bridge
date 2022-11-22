package bridge;


import java.util.List;

public class BridgeGameController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        // 시작메시지 출력
        outputView.printStartMessage();
        // 다리길이 입력메시지
        outputView.printBridgeSizeInputMessage();
        // 다리길이 입력받기
        int size = inputView.readBridgeSize();
        outputView.printEmptyLine();
        // 사이즈에 맞는 다리생성
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        // 다리게임 생성
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(size));

        MapDTO map;

        while(true){
            // 이동할 칸 선택 메시지
            outputView.printMoveSelectMessage();
            // 이동할 칸 입력받기
            String selectedSpace = inputView.readMoving();
            // 이동할 칸 이동 가능여부 확인
            boolean movable = bridgeGame.checkMovable(selectedSpace);
            map = bridgeGame.transferProgressMap(movable, selectedSpace);
            outputView.printMap(map);

            // 틀렸을 때
            if (!movable) {
                // 재도전할 것인지 다시 물어본다.
                outputView.printRetrySelectMessage();
                String selectedRetry = inputView.readGameCommand();
                if(selectedRetry.equals("Q")){
                    break;
                }
                bridgeGame.retry();
            }
            // 맞았을 때
            if (movable) {
                // 한칸 움직인다.
                bridgeGame.move();
            }
            // 다리를 건넜다면
            if (bridgeGame.checkEnd()) {
                bridgeGame.winning();
                break;
            }
        }
        int totalTry = bridgeGame.getPlayerTry();
        boolean winning = bridgeGame.getWinning();
        outputView.printResult(map, winning, totalTry);


    }

}
