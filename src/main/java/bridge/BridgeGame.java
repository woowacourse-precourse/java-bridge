package bridge;

import static bridge.InputView.readGameCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> BRIDGEANSWER;
    private Integer tryCount = 0;
    private Integer count = 0;

    public BridgeGame(List<String> BRIDGEANSWER) {
        this.BRIDGEANSWER = BRIDGEANSWER;
        this.tryCount = tryCount;

        Boolean keepPlay = true;
        while (keepPlay) {
            keepPlay = Play();
        }

    }

    private Boolean Play() {
        count = 0;
        List<String> playerList = new ArrayList<>();
        Boolean repeat = true;

        while (repeat) {
            repeat = Proceed(playerList);
        }
        tryCount ++;
        return retry();
    }

    private Boolean Proceed(List<String> playerList) {
        try {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String playerInput = InputView.readMoving();
            if (BRIDGEANSWER.get(count).equals(playerList.get(count))) {
                move(playerInput, playerList);
                count ++;
                return true;
            }
            if (!BRIDGEANSWER.get(count).equals(playerList.get(count))) {
                move(playerInput, playerList);
                return false;
            }
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String playerInput, List<String> playerList) {
        playerList.add(playerInput);
        System.out.println(playerInput);
        OutputView.printMap(playerList, BRIDGEANSWER);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Boolean retry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return readGameCommand();
    }
}
