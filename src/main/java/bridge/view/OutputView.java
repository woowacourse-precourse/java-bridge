package bridge.view;

import bridge.controller.BridgeController;
import bridge.model.CompareBridge;
import camp.nextstep.edu.missionutils.Console;


/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String START_GAME = "다리 건너기 게임을 시작합니다";
    public static final String SELECT_BRIDGE_SIZE = "다리 길이를 입력해주세요.";
    public static final String SELECT_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String SELECT_RESTART = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    // 게임 시작 선언
    public static void printGameStart() {
        System.out.println(START_GAME);
        System.out.println();
    }

    // 다리 길이 입력 선언
    public static void printBridgeSize() {
        System.out.println(SELECT_BRIDGE_SIZE);
    }
    public static void printSelectBlock() {
        System.out.println(SELECT_MOVE);
    }

    public static void printGameRestart() {
        System.out.println(SELECT_RESTART);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap() {
        if (CompareBridge.udCount == 1 || BridgeController.compareBridgeNum == 0) {
            CompareBridge.sbUp.deleteCharAt(0);
            CompareBridge.sbDown.deleteCharAt(0);
        }
        System.out.println("[" + CompareBridge.sbUp + "]");
        System.out.println("[" + CompareBridge.sbDown + "]");
        System.out.println();
    }

    

/**
 * 제공된 OutputView 클래스를 활용해 구현 OutputView 패키지 변경 가능 OutputView 메서드 이름은 변경 불가, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다. 값 출력을 위해
 * 필요한 메서드 추가 가능
 */