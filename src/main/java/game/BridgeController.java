package game;

import bridge.*;

import java.util.ArrayList;
import java.util.List;


public class BridgeController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    private int gameRound = 1;
    private String gameResult = "";
    private final List<String> commands = new ArrayList<>();

    
    public void settingGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");
        List<String> bridge = getBridge();

        run(bridge);

        printGameResult();
    }

    private void gameManager() {
        gameRound++;
        commands.clear();
        outputView.clearMap();
    }


    private void run(List<String> bridge) {
        for (int i = 0; i < bridge.size(); i++) {
            String command = moveCommand();
            commands.add(command);
            outputView.commandChecker(bridge, commands, i);
            if (!(bridge.get(i).equals(command))) break;
            gameResult = "성공";
        }
        if (!(commands.equals(bridge))) restart(bridge);
    }


    private void restart(List<String> bridge) {
        String retry = retryCommand();

        if (retry.equals("R")) {
            gameManager();
            run(bridge);
        }
        if (retry.equals("Q")) gameResult = "실패";
    }


    private void printGameResult() {
        System.out.println("최종 게임 결과");
        outputView.printResult();
        System.out.println("게임 성공 여부: " + gameResult);
        System.out.println("총 시도한 횟수: " + gameRound);
    }


    private List<String> getBridge() {
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        return bridge;
    }


    private String moveCommand() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String command = inputView.readMoving();
        return command;
    }


    private String retryCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        gameResult = "실패";
        String command = inputView.readGameCommand();
        return command;
    }
}
