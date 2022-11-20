package bridge.Controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Model.Bridge;
import bridge.Model.BridgeJudge;
import bridge.Model.BridgeMaker;
import bridge.Model.InputView;
import bridge.View.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int size;
    private int index = 0;
    private int count = 1;
    private int tried = 1;
    String gameResult = "성공";
    List<String> madeBridge = new ArrayList<>();
    String userDirection = "";
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void startGame() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        System.out.println("다리 건너기 게임을 시작합니다.\n");
        while (true) {
            System.out.println("다리의 길이를 입력해주세요.");
            try {
                size = InputView.getInstance.readBridgeSize(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        madeBridge = bridgeMaker.makeBridge(size);
    }
    public void move() {
        while (count <= size) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            try {
                userDirection = InputView.getInstance.readMoving(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            BridgeJudge.getInstance.judgeInput(userDirection, madeBridge.get(index), Bridge.bridge);
            OutputView.getInstance.printMap(Bridge.bridge, count);
            index++;
            count++;

            if(!retry()) {
                break;
            }
        }


    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        if(!Bridge.bridge.isRightAnswer()) {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String cont = InputView.getInstance.readGameCommand(Console.readLine());
            if (cont.equals("R")) {
                this.retryInit();
                return true;
            }
            gameResult = "실패";
            return false;
        }
        return true;
    }

    public void end() {
        System.out.println("최종 게임 결과");
        OutputView.getInstance.printResult();

        System.out.println("\n게임 성공 여부: " + gameResult);
        System.out.println("총 시도한 횟수: " + tried);
    }

    private void retryInit() {
        index = 0;
        count = 1;
        Bridge.bridge.init();
        OutputView.getInstance.init();
        tried++;
    }
}
