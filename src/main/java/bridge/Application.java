package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<String> moving = new ArrayList<>();
        moving.add("U");
        moving.add("D");
        moving.add("D");
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println(InputView.readBridgeSize());
        System.out.println(InputView.readMoving());
        System.out.println(InputView.readGameCommand());
        OutputView.printMap(moving);
        OutputView.printResult(1,4);
    }
}
