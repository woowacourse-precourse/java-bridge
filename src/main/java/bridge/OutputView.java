package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class OutputView {
    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("\n다리의 길이를 입력해주세요.");
    }
    public void printRequestToInputMoveCommand() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
    public void printRequestToInputRetryCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) { // 리팩토링 고민 좀 해봐.
        List<String> bridge = bridgeGame.getBridge();
        int currentPosition = bridgeGame.getCurrentPosition();
        //if(currentPosition==0)
        String firstLine = "[";
        String secondLine = "[";

        for(int i = 0; i < currentPosition; i++) {
            if(i!=0) {
                firstLine += "|";
                secondLine += "|";
            }
            if(bridge.get(i).equals("1")) {
                firstLine += " O ";
                secondLine += "   ";
            }
            if(bridge.get(i).equals("0")) {
                firstLine += "   ";
                secondLine += " O ";
            }
        }
        if(bridge.get(currentPosition).equals("1") && bridgeGame.isSuccess()) {
            firstLine += "| O ]";
            secondLine += "|   ]";
        }
        if(bridge.get(currentPosition).equals("1") && !bridgeGame.isSuccess()) {
            firstLine += "| X ]";
            secondLine += "|   ]";
        }
        if(bridge.get(currentPosition).equals("0") && bridgeGame.isSuccess()) {
            firstLine += "|   ]";
            secondLine += "| O ]";
        }
        if(bridge.get(currentPosition).equals("0") && !bridgeGame.isSuccess()) {
            firstLine += "|   ]";
            secondLine += "| X ]";
        }
        System.out.println(firstLine);
        System.out.println(secondLine);
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("\n최종 게임 결과");
        printMap(bridgeGame);
        System.out.print("\n게임 성공 여부: ");
        if(bridgeGame.isSuccess()) {
            System.out.println("성공");
        }
        if(!bridgeGame.isSuccess()) {
            System.out.println("실패");
        }
        System.out.println("총 시도한 횟수: " + bridgeGame.getTotalTryCount());
    }
}
