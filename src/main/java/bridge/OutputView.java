package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    BridgeMaker bridgeMaker = BridgeMaker.getInstance();
    String[] answer = new String[]{"[ ]", "[O]", "[X]"};

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int count, boolean dingdong) {
        for (int i = 0; i <= count; i++) {
            if (i == count) {
                updingdong(dingdong, count);
                break;
            }
            if (bridgeMaker.bridge.get(i).equals("U")) {
                System.out.print(answer[1]);
            }
            if (bridgeMaker.bridge.get(i).equals("D")) {
                System.out.print(answer[0]);
            }
        }
        System.out.println();
        for (int i = 0; i <= count; i++) {
            if (i == count) {
                downdingdong(dingdong, count);
                break;
            }
            if (bridgeMaker.bridge.get(i).equals("D")) {
                System.out.print(answer[1]);
            }
            if (bridgeMaker.bridge.get(i).equals("U")) {
                System.out.print(answer[0]);
            }
        }
    }

    private void downdingdong(boolean dingdong, int count) {
        if (dingdong && bridgeMaker.bridge.get(count).equals("D")) {
            System.out.print(answer[1]);
        }
        if (!dingdong && bridgeMaker.bridge.get(count).equals("D")) {
            System.out.print(answer[2]);
        }
        if (bridgeMaker.bridge.get(count).equals("U")) {
            System.out.print(answer[0]);
        }
    }

    private void updingdong(boolean dingdong, int count) {
        if (dingdong && bridgeMaker.bridge.get(count).equals("U")) {
            System.out.print(answer[1]);
        }
        if (!dingdong && bridgeMaker.bridge.get(count).equals("U")) {
            System.out.print(answer[2]);
        }
        if (bridgeMaker.bridge.get(count).equals("D")) {
            System.out.print(answer[0]);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
