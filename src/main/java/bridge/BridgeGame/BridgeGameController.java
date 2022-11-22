package bridge.BridgeGame;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.UI.Input.InputView;
import bridge.UI.Output.OutputView;

import java.util.List;

public class BridgeGameController {
    InputView inputView;
    OutputView outputView;
    BridgeRandomNumberGenerator generator;
    BridgeGame bridgeGame;
    BridgeMaker bridgeMaker;
    List<String> bridge;
    int currentLocation;
    int count;
    boolean tryFlag;
    boolean retryFlag;

    public BridgeGameController() {
        this.generator = new BridgeRandomNumberGenerator();
        this.inputView = new InputView();
        this.bridgeMaker = new BridgeMaker(this.generator);
        initializeBridge();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame(this.bridge);
        initializeAttribute();
        this.count = 1;
    }

    private void initializeBridge(){
        System.out.println("다리 건너기 게임을 시작 합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize = inputView.readBridgeSize();
        this.bridge = this.bridgeMaker.makeBridge(bridgeSize);
    }

    private void initializeAttribute(){
        this.currentLocation = 0;
        this.tryFlag = true;
        this.retryFlag = false;
        this.bridgeGame.clear();
    }

    private String enterMove() {
        String move = inputView.readMoving();
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return move;
    }

    private boolean moveFail(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String reply = inputView.readGameCommand();
        return bridgeGame.retry(reply);
    }

    private void moveSuccess(){
        outputView.printMap(bridgeGame.getBridgeFair());
        currentLocation++;
    }

    private void judgeMove(String move){
        if(!bridgeGame.move(currentLocation, move)) {
            outputView.printMap(bridgeGame.getBridgeFair());
            tryFlag = false;
            retryFlag = moveFail();
        }
    }

    private void retry(){
        initializeAttribute();
        count++;
    }



    public void run(){
        while(currentLocation < bridgeGame.getBridgeSize() && tryFlag){
            /*
                사용자에게 입력을 받아서, 건널 수 있는 다리인지를 판단.
                건널 수 없다면, 재도전 여부를 묻는다.
             */
            judgeMove(enterMove());

            // 재도전을 수락한 경우
            if(retryFlag) {
                retry();
                continue;
            }

            // 재도전 절차가 동작하지 않으면, 성공으로 간주한다.
            moveSuccess();
        }

        outputView.printResult(tryFlag, count, bridgeGame.getBridgeFair());
    }
}
