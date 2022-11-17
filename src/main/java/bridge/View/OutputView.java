package bridge.View;

import bridge.Controller.GameManager;
import bridge.Model.BridgeDTO;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private final String BRIDGESIZE = "다리의 길이를 입력해주세요.";
    private final String STARTGAME = "다리 건너기 게임을 시작합니다.";
    private final String PRINTLINE = "\n";
    private final String MOVEPOINT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String OPENMAP = "[ ";
    private final String CLOSEMAP = " ]";
    public final String COLLECT = "O";
    public final String BLANK = " ";
    private final String DIVISION = " | ";
    public final String FAIL = "X";

    GameManager gameManager = new GameManager();
    public void printMap(BridgeDTO bridgeDTO) {
        printFirstLine(bridgeDTO);
        printSecondLine(bridgeDTO);
    }

    public void printFirstLine(BridgeDTO bridgeDTO) {
        System.out.print(OPENMAP);
        for (int i=0;i<bridgeDTO.getMovePoint();i++) {
            System.out.print(bridgeDTO.getSaveFirstLine().get(i));
            if (i < bridgeDTO.getMovePoint() - 1) {
                System.out.print(DIVISION);
            }
        }
        System.out.println(CLOSEMAP);
    }
    public void printSecondLine(BridgeDTO bridgeDTO) {
        System.out.print(OPENMAP);
        for (int i=0;i<bridgeDTO.getMovePoint();i++) {
            System.out.print(bridgeDTO.getSaveSecondLine().get(i));
            if (i < bridgeDTO.getMovePoint() - 1) {
                System.out.print(DIVISION);
            }
        }
        System.out.println(CLOSEMAP);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printMakeBridgeSize() {
        System.out.println(BRIDGESIZE);
    }

    public void printStartGame() {
        System.out.println(STARTGAME + PRINTLINE);
    }

    public void printMovePoint() {
        System.out.println(MOVEPOINT);
    }
}
