package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("다리 건너기 게임을 시작합니다\n");

        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        int bridgeSize = Integer.parseInt(input);

        int[] bridge = new int[bridgeSize];
        for (int i = 0; i < bridge.length; i++) {
            bridge[i] = bridgeNumberGerator.generate();
        }

        for (int i = 0; i < bridge.length; i++) {
            if (bridge[i] == 0)
                System.out.print("D ");
            if (bridge[i] == 1)
                System.out.print("U ");
        }

        int count = 0;
        int current = 0;
        boolean gameEnd = false;
        while (!gameEnd) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D");
            String move = Console.readLine();
            if (move.equals("U")) {
                if (bridge[current] == 0) {
                    // 못감
                    makeBridge(bridge, current, false);
                    gameEnd = true;
                }
                if (bridge[current] == 1) {
                    // 갈 수 있음
                    makeBridge(bridge, current, true);
                    current++;
                }
            }
            if (move.equals("D")) {
                if (bridge[current] == 0) {
                    // 갈 수 있음
                    makeBridge(bridge, current, true);
                    current++;
                }
                if (bridge[current] == 1) {
                    // 못감
                    makeBridge(bridge, current, false);
                    gameEnd = true;
                }
            }
            if (gameEnd == false && current == bridgeSize) {
                System.out.println("게임 성공 여부 : 성공");
                System.out.println("총 시도한 횟수 : " + count);
                break;
            }
            if (gameEnd == true && count != bridgeSize) {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도 : R, 종료 : O");
                String retry = Console.readLine();
                if (retry.equals("R")) {
                    count++;
                    current = 0;
                    gameEnd = false;
                }
                if (retry.equals("Q")) {
                    System.out.println("최종게임 결과");
                    // 결과 출력
                    makeBridge(bridge, current, false);
                    System.out.println("게임 성공 여부 : 실패");
                    System.out.println("총 시도한 횟수 : " + count);
                }
            }

        }
    }

    public static void makeBridge(int[] bridge, int current, boolean correct) {
        StringBuilder up = new StringBuilder();
        StringBuilder down = new StringBuilder();
        up.append("[");
        down.append("[");
        for (int i = 0; i < current + 1; i++) {
            if (i != 0) {
                up.append("|");
                down.append("|");
            }
            if (bridge[i] == 0) {
                up.append(" ");
                down.append("O");
            }
            if (bridge[i] == 1) {
                up.append("O");
                down.append(" ");
            }
        }
        if (correct == false) {
            if (bridge[current] == 0) {
                up.setLength(up.length() - 1);
                down.setLength(down.length() - 1);
                up.append(" ");
                down.append("X");
            }
            if (bridge[current] == 1) {
                up.setLength(up.length() - 1);
                down.setLength(down.length() - 1);
                up.append("X");
                down.append(" ");
            }
        }
        up.append("]");
        down.append("]");

        System.out.println(up.toString());
        System.out.println(down.toString());
    }
}
