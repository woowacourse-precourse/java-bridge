package bridge;

/**
 * 제공된 BridgeGame 클래스를 활용해 구현해야 한다.
 * BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
 * BridgeGame의 패키지는 변경할 수 있다.
 * BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    List<String> bridge = new ArrayList<>();
    List<String> upResult = new ArrayList<>();
    List<String> downResult = new ArrayList<>();
    List<String> result = new ArrayList<>();
    int tryCount = 1;

    public void run() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int size = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(size);

        while (!move()) {
            if (!retry()) {
                break;
            }
        }
        outputView.printResult(successOrFail(result), tryCount, upResult, downResult);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private boolean move() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        initResults();

        System.out.println(bridge);

        for (int i = 0; i < bridge.size(); i++) {
            String userUpDownInput = inputView.readMoving();

            upResult.add(i, " ");
            downResult.add(i, " ");
            result.add(i, "F");

            if (userUpDownInput.equals("U")) {
                if (bridge.get(i).equals("U")) {
                    upResult.set(i, "O");
                    result.set(i, "S");
                } else {
                    upResult.set(i, "X");
                }
            }

            if (userUpDownInput.equals("D")) {
                if (bridge.get(i).equals("D")) {
                    downResult.set(i, "O");
                    result.set(i, "S");
                } else {
                    downResult.set(i, "X");
                }
            }
            outputView.printMap(upResult, downResult);
        }

        return successOrFail(result);
    }

    private boolean successOrFail(List<String> result) {
        if (result.contains("F"))
            return false;
        return true;
    }

    private void initResults() {
        upResult.clear();
        downResult.clear();
        result.clear();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        InputView inputView = new InputView();

        if (inputView.readGameCommand().equals("R")) {
            tryCount++;
            return true;
        } else { // 최종 게임 결과, 성공 여부, 총 시도 횟수
            return false;
        }
    }
}
