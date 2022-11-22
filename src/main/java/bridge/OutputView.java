package bridge;

import java.util.List;

/** 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다. */
public class OutputView {
    public final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public final String FINAL_MESSAGE = "최종 게임 결과";
    public final String STATUS_MESSAGE = "게임 성공 여부: ";
    public final String TIMES_MESSAGE = "총 시도한 횟수: ";

    OutputView() {

    }

    public void printStart() {
        System.out.println(START_MESSAGE);
        System.out.println();
    }

    //현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
    //출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
    public void printMap(List<String> result) {
        for (int index = 0; index < result.size(); index++) {
            System.out.println(result.get(index));
        }
        System.out.println();
    }

    /**
     *게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printGameResult(List<String> result) {
        System.out.println(FINAL_MESSAGE);

        for (int index = 0; index < result.size(); index++) {
            System.out.println(result.get(index));
        }
        System.out.println();
    }

    public void printStatusResult(String gamestatus) {
        System.out.println(STATUS_MESSAGE + gamestatus);
    }

    public void printTimesResult(int trynum) {
        System.out.println(TIMES_MESSAGE + trynum);
    }
}
