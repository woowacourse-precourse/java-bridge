package bridge;

import java.util.List;

public class Application {

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static int bridgesize;
    private static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    private static BridgeGame bridgeGame = new BridgeGame();
    private static int idx;
    private static boolean flag;
    private static int count;

    public static void main(String[] args) {
        startGame();
        do {
            doGame();
        } while(flag && idx < bridgesize);
        printResult();
    }

    private static void startGame() {
        bridgeGame.init();
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
        bridgesize = inputView.readBridgeSize();
        bridgeGame.setRandomMap(bridgeMaker.makeBridge(bridgesize));
        flag = true;
        idx = 0;
        count = 0;
    }

    private static void doGame() {
        count++;
        callMove();
        if(!flag){
            retry();
        }
    }

    private static void callMove() {
        while(flag && idx < bridgesize) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            flag = bridgeGame.move(inputView.readMoving());
            outputView.printMap(List.of(bridgeGame.getUpMap(), bridgeGame.getDownMap()));
            idx++;
        }
    }

    public static void retry() {
        boolean re;
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        re = inputView.readGameCommand();
        if(re) {
            bridgeGame.retry();
            idx = 0;
            flag = true;
        }
    }
    private static void printResult() {
            outputView.printResult(flag, List.of(bridgeGame.getUpMap(), bridgeGame.getDownMap()), count);
    }
}
