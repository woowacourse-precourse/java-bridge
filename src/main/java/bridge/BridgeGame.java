package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;
    private List<List<String>> userMap;
    private List<String> randomMap;
    private int bridgesize;
    private boolean flag;
    private String move;

    public BridgeGame(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
        this.bridgesize = 0;
        flag = false;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        while(flag)
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            move = inputView.readMoving();

        }
    }

    public

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public void init() {
        System.out.println("다리의 길이를 입력해주세요.");
        bridgesize = inputView.readBridgeSize();
        randomMap = bridgeMaker.makeBridge(bridgesize);
        userMap = new ArrayList<>();
        flag = true;
    }
}
