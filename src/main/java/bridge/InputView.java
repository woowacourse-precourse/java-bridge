package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    final static BridgeGame bridgeGame = new BridgeGame();
    final static OutputView outputView = new OutputView();

    static int size = 1;
    static List<String> move = new ArrayList<>();

    public void readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        try {
            size = write_bridge_size();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readBridgeSize();
        }
    }

    public int write_bridge_size() {
        int answer = 0;
        try {
            answer = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력을 하였습니다.");
        }
        return answer;
    }

    public void readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        try {
            move.add(checkMoving());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            readMoving();
        }
    }

    public String checkMoving() {
        String answer = "";
        try {
            answer = Console.readLine();
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력을 하였습니다.");
        }
        return answer;
    }

    public static void readGameCommand() {
        OutputView.now_size = OutputView.bridge_answer.size();
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String a = Console.readLine();
        if(Objects.equals(a, "R")){
            ++BridgeGame.play_count;
            OutputView.now_size = 0;
            Application.playBridgeGame();
        }
        if(Objects.equals(a,"Q")){
            System.out.println("최종 게임 결과");
            outputView.printResult();
            System.out.println("\n 게임 성공 여부 : 실패");
            System.out.println("총 시도한 횟수 : " + BridgeGame.play_count);
        }
    }

    public int getSize() {
        return size;
    }

    public List<String> getMove() {
        return move;
    }
}
