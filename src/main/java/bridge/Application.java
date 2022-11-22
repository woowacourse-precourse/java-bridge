package bridge;

import bridge.domain.BridgeGame;

import java.util.List;

import static bridge.view.InputView.*;
import static bridge.view.OutputView.*;

public class Application {

    public static void main(String[] args) {
        try {
            printGameStart();
            boolean run = true;
            int count = 0;

            while(run) {
                int size = readBridgeSize();

                // 다리 생성
                BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
                BridgeMaker maker = new BridgeMaker(generator);
                List<String> bridge = maker.makeBridge(size);

                BridgeGame game = new BridgeGame();
                game.clear();

                String status = "성공";
                int idx = 0;
                while(idx < size) {
                    String input = readMoving();
                    game.move(bridge, idx, input);
                    printMap(game.getUpBridge(), game.getDownBridge());

                    // 일치하지 않는 경우
                    if(game.isGameOver(bridge, idx, input)) {
                        status = "실패";
                        break;
                    }
                    idx++;
                }
                count++;

                // 다리 건너기에 성공했으면 결과 리턴
                if(status.equals("성공")) {
                    printResult(game.getUpBridge(), game.getDownBridge(), status, count);
                    break;
                }

                // 게임 종료 여부에 대해 입력 받기 (Quit - false, Retry - true)
                run = BridgeGame.retry(readGameCommand());

                // 종료 (Q) 옵션을 선택했을 경우에 결과 리턴 후 프로그램 종료
                if(!run) {
                    printResult(game.getUpBridge(), game.getDownBridge(), status, count);
                }
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
