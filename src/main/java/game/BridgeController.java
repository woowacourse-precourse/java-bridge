package game;

import bridge.*;

import java.util.List;


public class BridgeController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void settingGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");
        List<String> bridge = getBridge();

        run(bridge);
    }

    private void run(List<String> bridge) {
        int count = 0;
        while (true) {
            count++;

            playGame(bridge);

            String retry = retryCommand();
            if (retry.equals("Q")) break;
            if (retry.equals("R")) playGame(bridge);
        }
        System.out.println("게임 성공 여부: " + "실패");
        System.out.println("총 시도한 횟수: " + count);
    }

    private void playGame(List<String> bridge) {

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
        String command = inputView.readGameCommand();
        return command;
    }
}
