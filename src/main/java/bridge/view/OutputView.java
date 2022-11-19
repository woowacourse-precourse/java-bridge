package bridge.view;


import bridge.domain.User;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private StringBuilder upState = new StringBuilder();
    private StringBuilder downState = new StringBuilder();

    public void printStartGame() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printChoiceBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printChoiceUpOrDown() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printChoiceRetry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세여.(재시도: R, 종료: Q)");
    }


    public void printResultMap() {
        System.out.println("[ " + upState + " ]");
        System.out.println("[ " + downState + " ]");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int index, boolean check, String moveUpOrDown) {
        if (index >= 1) {
            upState.append(" | ");
            downState.append(" | ");
        }
        checkUpOrDown(moveUpOrDown, check);
        printResultMap();
    }

    private void checkUpOrDown(String UpAndDown, boolean check) {
        if (UpAndDown.equals("U")) {
            setUpState(check);
        }
        if (UpAndDown.equals("D")) {
            setDownState(check);
        }
    }


    private void setUpState(boolean check) {
        if (check) {
            upState.append("O");
        }
        if (!check) {
            upState.append("X");
        }
        downState.append(" ");
    }

    private void setDownState(boolean check) {
        if (check) {
            downState.append("O");
        }
        if (!check) {
            downState.append("X");
        }
        upState.append(" ");
    }

    public void initUpOrDownState() {
        upState = new StringBuilder();
        downState = new StringBuilder();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(User user){
        System.out.println("\n최종 게임 결과");
        printResultMap();
        System.out.println("\n게임 성공 여부: " + isPass(user.isSuccessComplete()));
        System.out.println("총 시도한 횟수: " + user.getTryCount());
    }
    private String isPass(boolean pass){
        if (pass)return "성공";
        return "실패";
    }
}
