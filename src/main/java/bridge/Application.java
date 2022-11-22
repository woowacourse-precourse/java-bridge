package bridge;

import java.util.ArrayList;
import java.util.List;
public class Application {

    private static List<String> bridgeNumberList = new ArrayList<>();
    static InputView userInput = new InputView();
    static OutputView display = new OutputView();
    static BridgeGame Game = new BridgeGame();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        run();
    }

    private static void run() {
        gameSetting();

        while (!gameRun()) {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            if (userInput.readGameCommand().equals("Q")) {
                break;
            }
            Game.retry();
        }
        printTotalResult(Game.getCount());
    }
    private static void gameSetting() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리 길이를 입력해주세요.");
        BridgeRandomNumberGenerator gameRandomNumber = new BridgeRandomNumberGenerator();
        BridgeMaker makeBridge = new BridgeMaker(gameRandomNumber);

        int bridgeSize = userInput.readBridgeSize();

        bridgeNumberList = makeBridge.makeBridge(bridgeSize);
    }

    private static boolean gameRun() {
        for (int i = 0; i < bridgeNumberList.size(); i++) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String moveUpOrDown = userInput.readMoving();
            boolean state = Game.move(bridgeNumberList.get(i), moveUpOrDown);
            display.printMap(Game.getBridgeLineOne(), Game.getBridgeLineTwo());
            if (state == false) {
                return false;
            }
        }
        return true;
    }

    private static void printTotalResult(int count) {
        System.out.println("최종 게임 결과");
        display.printMap(Game.getBridgeLineOne(), Game.getBridgeLineTwo());
        display.printResult(Game.getNowState(), count);
    }

}
