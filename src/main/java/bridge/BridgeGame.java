package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private InputView inputView;
    private OutputView outputView;
    private List<String> bridge;
    private List<String> inputs;
    private int index;
    private int size;

    public BridgeGame(){
        inputView = new InputView();
        outputView = new OutputView();
        init();
    }

    /**
     * 게임을 처음 시작하거나 재시작할 때 초기화 되어야 하는 값을 초기화해준다.
     */
    public void init(){
        index = 0;
        inputs = new ArrayList<>();
    }

    /**
     * 처음 프로그램이 실행될 때 한번 호출주며 기본 프로그램 세팅을 한다.
     */
    public void start(){
        inputView.printHello();
        size = inputView.readBridgeSize();
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);

        gameLogic();
    }

    /**
     * 게임 플레이 로직을 시작합니다.
     */
    public void gameLogic(){

    }

    /**
     * 게임이 종료 되었는지 확인합니다.
     */
    public void isGameEnd(){

    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
