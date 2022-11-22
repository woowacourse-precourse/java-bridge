package bridge;

import java.util.ArrayList;
import java.util.List;

public class PlayBridgeGame {
    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;
    private List<String> bridge;
    private InputView inputView;
    private OutputView outputView;
    private List<String> upResult;
    private List<String> downResult;
    private List<String> result;
    private int index;

    public PlayBridgeGame() {
        bridgeGame = new BridgeGame();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        inputView = new InputView();
        outputView = new OutputView();
        upResult = new ArrayList<>();
        downResult = new ArrayList<>();
        result = new ArrayList<>();
        index = 0;
    }

    public void printStartScreen() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printCrossBridge() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void makeBridge() {
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    public void continueGame() {
        String command = inputView.readMoving();

        boolean check = true;
        while(check) {
            check = calculateResult(command);
        }

        outputView.printMap(command, result, upResult, downResult);
    }

    public boolean calculateResult(String command) {
        setResult(command);
        result.add(command);

        return isSuccess();
    }

    public boolean isSuccess() {
        if(upResult.get(index).equals("X")) {
            reset();
            return false;
        }
        index++;
        return true;
    }

    public void setResult(String command) {
        if(command.equals(bridge.get(index))) {
            upResult.add("O");
            downResult.add("X");
        }
        upResult.add("X");
        downResult.add("O");
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public void reset() {
        index = 0;

        upResult.clear();
        downResult.clear();
        result.clear();
    }

    public boolean askGame() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q");
        String command = inputView.readGameCommand();

        if(command.equals("R")) {
            return true;
        }
        return false;
    }
}
