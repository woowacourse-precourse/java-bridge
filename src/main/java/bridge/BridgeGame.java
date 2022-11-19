package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<Integer> bridge, String moving, boolean isWrong) {
        if (isWrong) {
           moving = setWrongMoving(moving);
        }
        Bridge solution = Bridge.findTop(moving);

        bridge.add(solution.getTop());
        bridge.add(solution.getBottom());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> bridge) {
        String result;
        int count = 0;

        do {
            result = run(bridge);
            count++;
        } while (!isNotFinish(result));

        stop(count, result);
    }

    public String moveUser() {
        InputView input = new InputView();

        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");

        return input.readMoving();
    }

    private boolean isWrongMove(String shape, String moving) {
        boolean isWrong = false;

        if (isNotEqual(shape, moving)) {
            return true;
        }

        return isWrong;
    }

    private String setWrongMoving(String moving) {
        String move = "F";

        if (moving.equals(Bridge.UP.getOrder())) {
            move = "W";
        }

        return move;
    }

    public String run(List<String> bridge) {
        List<Integer> bottomBridge = new ArrayList<>();
        List<Integer> topBridge = new ArrayList<>();

        compareBridge(bridge, topBridge, bottomBridge);

        return saveBridge(topBridge, bottomBridge);
    }

    private String saveBridge(List<Integer> topBridge, List<Integer> bottomBridge) {
       return topBridge + "\n" + bottomBridge;
    }

    private void compareBridge(List<String> bridge, List<Integer> topBridge, List<Integer> bottomBridge) {
        for (String s : bridge) {
            List<Integer> userMove = new ArrayList<>();

            boolean isWrong = checkUserMoving(s, userMove);
            notYetName(userMove, topBridge, bottomBridge);

            if (isWrong) {
                break;
            }
        }
    }

    private void notYetName(List<Integer> userMove, List<Integer> top, List<Integer> bottom) {
        saveBridge(userMove, top, bottom);

        requestPrintMap(saveMap(top), saveMap(bottom));
    }

    private boolean checkUserMoving(String s, List<Integer> userMove) {
        String moving = moveUser();
        boolean isWrong = isWrongMove(s, moving);

        move(userMove, moving, isWrong);

        return isWrong;
    }

    private void saveBridge(List<Integer> userMove, List<Integer> topBridge, List<Integer> bottomBridge) {
        topBridge.add(userMove.get(0));
        bottomBridge.add(userMove.get(1));
    }


    private boolean isNotFinish(String result) {
        boolean isClear = true;
        InputView input = new InputView();

        if (result.contains("X")) {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String gameCommand = input.readGameCommand();

            if (gameCommand.equals("R")) {
                isClear = false;
            }
        }
        return isClear;
    }


    private static void requestPrintMap(String up, String down) {
        OutputView output = new OutputView();

        output.printMap(up);
        output.printMap(down);
    }

    public static String saveMap(List<Integer> bridge) {
        StringBuilder map = new StringBuilder("[ ");

        judgement(map, bridge);
        map.append(" ]");

        return map.toString();
    }

    private static void judgement(StringBuilder map, List<Integer> bridge) {
        for (int i = 0; i < bridge.size(); i++) {
            map.append(Bridge.findOrder(bridge.get(i)).getResult());

            if (i < bridge.size() - 1) {
                map.append(" | ");
            }
        }
    }
    private static boolean isNotEqual(String bridge, String moving) {
        return !bridge.equals(moving);
    }

    public void stop(int count, String result) {
        OutputView output = new OutputView();

        output.printResult(result, count);
    }

    public void start() {
        requestPrint("다리 건너기 게임을 시작합니다.");
        requestPrint("다리의 길이를 입력해주세요.");

        InputView input = new InputView();
        int bridgeSize = input.readBridgeSize();

        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());

        retry(maker.makeBridge(bridgeSize));
    }

    private void requestPrint(String message) {
        OutputView output = new OutputView();

        output.printMap(message);
    }
}
