package game;

import bridge.*;

import java.util.ArrayList;
import java.util.List;


public class BridgeController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    private int gameRound = 0;
    private String gameResult = "성공";
    private List<String> commands = new ArrayList<>();

    public void settingGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");
        List<String> bridge = getBridge();
        System.out.println("bridge = " + bridge);

        run(bridge);

        System.out.println(gameResult);
        System.out.println(gameRound);
    }


    public void run(List<String> bridge) {
        gameRound++;
        for (int i = 0; i < bridge.size(); i++) {
            String command = moveCommand();
            commands.add(command);
            if (!(bridge.get(i).equals(command))) break;
        }
        if (!(commands.equals(bridge))) restart(bridge);
        commands.clear();
    }


    public void restart(List<String> bridge) {
        String retry = retryCommand();
        if (retry.equals("R")) run(bridge);
        if (retry.equals("Q")) gameResult = "실패";
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
