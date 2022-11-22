package bridge;

import bridge.view.Continue;
import bridge.view.InputView;
import bridge.view.Move;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int size;

    private OutputView outputView;

    private InputView inputView;

    private int tryCount = 1;

    public BridgeGame() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public int startGame() {
        outputView.printStatGame();
        outputView.printSpaceLine();
        outputView.printInputBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        outputView.printSpaceLine();

        return bridgeSize;
    }

    public List<String> makeBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> bridge) {
        List<String> users = new ArrayList<>();
        for (int index = 0; index < bridge.size(); index++) {
            outputView.printInputMove();
            Move move = inputView.readMoving();
            users.add(move.getMove());

            outputView.printMap(users, bridge);

            if (move.getMove().equals(bridge.get(index))) {
                continue;
            }
            break;
        }

        if ((users.size() == bridge.size()) && compare(users, bridge)) {
            outputView.printResult(users, bridge);
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + tryCount);
            return;
        }
        retry(users, bridge);
    }

    private boolean compare(List<String> users, List<String> bridge) {
        for (int i = 0; i < users.size(); i++) {
            if (!users.get(i).equals(bridge.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> users, List<String> bridge) {
        outputView.printInputContinue();
        Continue command = inputView.readGameCommand();
        if (command.equals(Continue.RESTART)) {
            tryCount++;
            move(bridge);
            return;
        }

        outputView.printResult(users, bridge);
        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + tryCount);
    }
}
