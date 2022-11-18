package bridge;

public class OutputView {
    public void printStartGame(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap() {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Success successResult, int tryCounts) {
        System.out.println("게임 성공 여부: "+successResult.getIsSuccessWord());
        System.out.println("총 시도한 횟수: "+tryCounts);
    }
}
