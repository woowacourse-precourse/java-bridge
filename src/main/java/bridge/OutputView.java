package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final BridgeGame bridgeGame;
    private final List<String> buff;

    public OutputView(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        buff = new ArrayList<>();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void printMap() {
        buff.clear();
        System.out.println(checking(UserResponse.UP.stateInfo));
        buff.clear();
        System.out.println(checking(UserResponse.DOWN.stateInfo));
    }

    private String checking(String stateInfo) {
        for (int i = 0; i < bridgeGame.getUserList().size(); i++) {
            if (bridgeGame.getUserList().get(i).equals(stateInfo)) {
                if (bridgeGame.getUserList().get(i).equals(bridgeGame.getBridge().get(i))) buff.add("O");
                if (!bridgeGame.getUserList().get(i).equals(bridgeGame.getBridge().get(i))) buff.add("X");
                continue;
            }
            buff.add(" ");
        }
        StringBuilder sb = new StringBuilder(buff.toString().replaceAll(",", " |")).insert(1, " ");
        return sb.insert(sb.length() - 1, " ").toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int retryCount, boolean isEnd) {
        String result = "실패";
        if (isEnd) result = "성공";
        System.out.println("최종 게임 결과");
        printMap();
        System.out.println();
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + retryCount);
    }
}
