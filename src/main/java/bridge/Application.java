package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static InputView input = new InputView();
    private static OutputView output = new OutputView();
    private static BridgeGame game = new BridgeGame();

    /**
     * 게임 시작 화면 구성 후 다리 길이를 입력받아 랜덤 다리를 생성한다.
     */
    private static void start(){
        output.printStart();
        game.makeBridgeGame(input.readBridgeSize());
    }

    /**
     * 사용자에게 칸을 입력받아 다리에서 이동한 결과를 반환한다.
     */
    private static List<String> choice(){
        output.printMoving();
        return game.move(input.readMoving());
    }

    /**
     * 다리에서 이동한 결과를 출력 후 사용자가 다리를 건너는 데 실패한 경우 재시도, 종료를 선택하도록 한다.
     */
    private static boolean result(List<String> curMove){
        output.printMap(curMove);
        if (game.isOver()){
            output.printGameCommand();
            if (input.readGameCommand().equals("Q")){
                return true;
            }
            game.retry();
        }
        return false;
    }

    /**
     * 게임이 완전히 종료된 경우 결과를 출력한다.
     */
    private static void finish(List<String> curMove, boolean isSuccess, int count){
        output.printResult(curMove, isSuccess, count);
    }

    public static void main(String[] args) {
        List<String> curMove = new ArrayList<>();
        start();
        while (!game.isDone()){
            curMove = choice();
            if (result(curMove)){
                finish(curMove, false, game.getCount());
                return;
            }
        }
        finish(curMove, true, game.getCount());
    }
}
