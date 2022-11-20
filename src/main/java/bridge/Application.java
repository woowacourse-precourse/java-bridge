package bridge;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        int n;
        boolean gameOver = false;

        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
        n = Integer.parseInt(Console.readLine());
        System.out.println();

        do {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");

            if (gameOver) {
                System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            }

        } while(BridgeGame.retry());

        System.out.println("게임 성공 여부: ");
        System.out.println("총 시도한 횟수: ");
    }
}
