package bridge.View;

import bridge.Model.BridgeDTO;

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
    private final String FINAL = "최종 게임 결과";
    private final String RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final String RESULTFAIL = "실패";
    private final String SUCCESSFUL = "게임 성공 여부: ";
    private final String SUCCESS = "성공";
    private final String TOTALTRY = "총 시도한 횟수: ";

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
        System.out.println(CLOSEMAP + "\n");
    }

    public void printResult() {
        System.out.println(FINAL);
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

    public void printRetry() {
        System.out.println(RETRY);
    }

    public void printFail() {
        System.out.println(SUCCESSFUL + RESULTFAIL);
    }

    public void printSuccess() {
        System.out.println(SUCCESSFUL + SUCCESS);
    }

    public void printTotalTry(BridgeDTO bridgeDTO) {
        System.out.println(TOTALTRY + bridgeDTO.getRetry());
    }
}
