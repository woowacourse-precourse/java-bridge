package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final List<String> commands = new ArrayList<>();

    private String gameResult = "";
    private int gameRound = 1;

    public void settingGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        run(bridge);
        printGameResult();
    }

    public void run(List<String> bridge) {
        for(int i = 0; i < bridge.size(); i++) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String command = inputView.readMoving();
            commands.add(command);
            if (!(bridge.get(i).equals(command))) break;
            gameResult = "성공";
        }
        if (!(commands.equals(bridge))) restart(bridge);
    }

    public void restart(List<String> bridge) {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String retry = inputView.readGameCommand();
        if(retry.equals("R")) {
            gameRound++;
            commands.clear();
            outputView.clearMap();
            run(bridge);
        }
        if(retry.equals("Q")) gameResult = "실패";
    }

    public void printGameResult() {
        System.out.println("최종 게임 결과");
        outputView.printResult();
        System.out.println("게임 성공 여부: " + gameResult);
        System.out.println("총 시도한 횟수: " + gameRound);
    }

}
