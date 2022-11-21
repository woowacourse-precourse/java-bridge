package bridge.view;

import bridge.bridgeGame.BridgeGameResultDto;
import bridge.bridgeGame.StepStatus;
import bridge.constant.Constant;
import bridge.enums.UpDown;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * @param gradingBoard 현재까지 이동한 다리 채점표
     */
    public void printMap(List<StepStatus> gradingBoard) {
        System.out.println(boardStringBuilder(UpDown.UP,gradingBoard));
        System.out.println(boardStringBuilder(UpDown.DOWN,gradingBoard));
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * @param bridgeGameResultDto 게임 결과 Dto
     */
    public void printResult(BridgeGameResultDto bridgeGameResultDto) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGameResultDto.getGradingBoard());

        System.out.println("게임 성공 여부: " + bridgeGameResultDto.getGameStatus().label());
        System.out.println("총 시도한 횟수: " + bridgeGameResultDto.getTotalAttemptNum());
    }

    /**
     * UpDown을 구분하여 다리 상태를 문자열로 보여준다.
     * @param upDown 출력하기 원하는 다리 위치. 위면 UpDown.UP / 아래면 UpDown.DOWN
     * @param gradingBoard 현재까지 이동한 다리 채점표
     * @return 위 아래에 맞는 다리 이동 상태 문자열
     */
    private String boardStringBuilder(UpDown upDown, List<StepStatus> gradingBoard) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (StepStatus stepStatus : gradingBoard) {
            stringBuilder.append(divergeStepStatus(stepStatus,upDown));
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /**
     * UpDown을 구분하여 다리 상태를 문자열로 보여준다.
     * @param stepStatus 칸을 밟은 상태
     * @param upDown 출력하기 원하는 다리 위치. 위면 UpDown.UP / 아래면 UpDown.DOWN
     * @return 밟은 칸에 따른 경과 문자열 출력. (정답:" O |" / 오답:" X |" / 밟지 않음:"   |")
     */
    private String divergeStepStatus(StepStatus stepStatus, UpDown upDown) {
        if (stepStatus.getUpDown().equals(upDown) && stepStatus.isCorrect() == true) {
            return Constant.correctLineOutput;
        }
        if (stepStatus.getUpDown().equals(upDown) && stepStatus.isCorrect() == false) {
            return Constant.incorrectLineOutput;
        }
        return Constant.notChosenLineOutput;
    }

}
