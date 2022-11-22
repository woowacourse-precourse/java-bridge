package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private boolean isPass = true;
    private int round = 0, total_round = 1;
    private List<String> computer = new ArrayList<>();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public BridgeGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        computer = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    public void run() {
        for (int i = 0; i < computer.size(); i++) {
            move();
            if (!isPass)
                break;
        }
        if (!isPass && inputView.readGameCommand().equals("R")) {
            retry();
            run();
        }
        outputView.printResult(total_round, success());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        outputView.updateMap(check(round++, inputView.readMoving()));
        outputView.printMap();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        total_round++;
        round = 0;
        outputView.reMap();
    }

    /**
     * 사용자가 입력한 값과 컴퓨터의 값을 비교하는 메서드
     *
     * @param round 사용자가 이동한 횟수 - 1
     * @param user  사용자가 입력한 이동할 값 : U or D
     * @return {" ","O","X"} - updateMap()에서 각 map에 입력할 정보
     */
    public String[] check(int round, String user) {
        if (computer.get(round).equals(user)) {
            isPass = true;
            if (user.equals("D")) return new String[]{" ", "O"};
            return new String[]{"O", " "};
        }
        isPass = false;
        if (user.equals("D")) return new String[]{" ", "X"};
        return new String[]{"X", " "};
    }

    private String success() {
        if (isPass) return "성공";
        return "실패";
    }
}
