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
     *
     * @return
     */
    public List<Integer> move(List<Integer> bridge, String moving) {
        Bridge solution = Bridge.findTop(moving);

        bridge.add(solution.getTop());
        bridge.add(solution.getBottom());

        return bridge;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> bridge) {
        boolean isWrong = false;
        String result = "";
        int count = 0;
        String gameCommand = "R";
        InputView input = new InputView();

        while (gameCommand.equals("R")) {
            isWrong = false;

            List<Integer> bottomBridge = new ArrayList<>();
            List<Integer> topBridge = new ArrayList<>();

            for (int i = 0; i < bridge.size(); i++) {
                List<Integer> userMove = new ArrayList<>();
                if (isWrong) {
                    break;
                }
                System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
                String moving = input.readMoving();

                if (isNotEqual(bridge.get(i), moving)) {
                    if (moving.equals(Bridge.UP.getOrder())) {
                        moving = "W";
                    }
                    if (moving.equals(Bridge.DOWN.getOrder())) {
                        moving = "F";
                    }
                    isWrong = true;
                }

                move(userMove, moving);
                topBridge.add(userMove.get(0));
                bottomBridge.add(userMove.get(1));

                System.out.println(topBridge);
                System.out.println(bottomBridge);

                result = requestPrintMap(saveMap(topBridge), saveMap(bottomBridge));
            }
            // 다 맞춤
            if (!(topBridge.contains(Bridge.WRONG.getTop()) || topBridge.contains(Bridge.UNKNOWN.getTop()))) {
                count++;
                break;
            }
            // X 있음
            if (isWrong) {
                count++;
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                gameCommand = input.readGameCommand();
            }

        }
        stop(count, result, isWrong);
    }

    private static String requestPrintMap(String up, String down) {
        OutputView output = new OutputView();

        output.printMap(up);
        output.printMap(down);

        return up + "\n" +  down;
    }

    public static String saveMap(List<Integer> bridge) {
        String map = "[ ";

        for (int i = 0; i < bridge.size(); i++) {
            map += Bridge.findOrder(bridge.get(i)).getResult();

            if (i < bridge.size() - 1) {
                map += " | ";
            }
        }
        map += " ]";

        return map;
    }

    private static boolean isNotEqual(String bridge, String moving) {
        if (!bridge.equals(moving))
            return true;
        return false;
    }

    public void stop(int count, String result, boolean isClear) {
        OutputView output = new OutputView();

        output.printResult(result, !isClear, count);
    }

    public void start() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");

        InputView input = new InputView();
        int bridgeSize = input.readBridgeSize();

        // 다리를 생성하기
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = maker.makeBridge(bridgeSize);

        System.out.println("다리 : " + bridge);
        retry(bridge);
    }

}
