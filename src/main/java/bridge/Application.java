package bridge;
import camp.nextstep.edu.missionutils.Console;
public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void gameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요.");
        InputView user_input = new InputView();
        int bs = Integer.valueOf(Console.readLine());
        user_input.readBridgeSize(bs);


    }
}
