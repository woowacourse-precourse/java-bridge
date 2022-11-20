package bridge;

import java.util.List;

public class Application {

    private static InputView input;
    private static OutputView output;
    private static BridgeGame game;

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

    public static void main(String[] args) {
        start();
        while (!game.isDone()){
            choice();
        }
    }
}
