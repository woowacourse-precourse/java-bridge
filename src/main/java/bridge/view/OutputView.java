package bridge.view;

import bridge.Route;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private StringBuilder sb;
    private List<String> up;
    private List<String> down;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Route route) {
        init(route);

        createInfo(up, sb);
        sb.append('\n');
        createInfo(down, sb);

        System.out.println(sb);
    }

    private void init(Route route) {
        sb = new StringBuilder();
        up = route.getUp();
        down = route.getDown();
    }


    private String createInfo(List<String> target, StringBuilder sb) {
        sb.append('[').append(' ');
        for(String block : target) {
            sb.append(block).append(' ');
        }
        sb.append(']');
        return sb.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result, int tryCount) {
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + tryCount);
    }

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printBridgeLengthInputRequestMessage() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printMoveSpaceInputRequestMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래:D)");
    }

    public void printChoseRetryInputRequestMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요.(재시도: R, 종료:Q)");
    }
}
