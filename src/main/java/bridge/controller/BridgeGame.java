/**
 * BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
 */

package bridge.controller;

//Controller
import bridge.View.BridgeView;
import bridge.domain.Computer;

import java.util.List;
import java.util.ArrayList;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    // component
    private int bridgeSize; // 총 다리 개수
    private List<Integer> bridgeNumber = new ArrayList<>(); // 각 다리의 정답
    private String nextStep; // 유저가 선택한 다음 위치

    // domain
    Computer computer = new Computer();

    // Util
    private final BridgeView bridgeView = new BridgeView();

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

    /**
     * 사용자가 게임을 시작할 때, 게임 시작 문구 출력을 위한 메서드
     */
    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    /**
     * 사용자가 다리 개수를 입력할 때 사용하는 메서드
     */
    public void enterNumberOfBridge() {
        this.bridgeSize = bridgeView.readBridgeSize();
    }

    /**
     * 컴퓨터가 랜덤 값을 생성하는 메서드
     */
    public void createRandomNumber() {
        bridgeNumber.add(computer.createRandomNumber());
        System.out.println(bridgeNumber.get(bridgeNumber.size()-1));
    }

    /**
     * 사용자가 이동할 다음 칸을 선택하는 기능
     */
    public void enterNextStep() {
        this.nextStep = bridgeView.readNextStep();
    }

}
