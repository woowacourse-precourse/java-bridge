package bridge.viewer;

import bridge.domain.UserPosition;
import bridge.domain.Result;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMap(UserPosition userPosition) {
        System.out.print("[");
        for (int i=0; i<userPosition.size();i++) {
            if (userPosition.upAt(i)) {
                System.out.print(" O ");
            } else {
                System.out.print("   ");
            }
            if (i == userPosition.size() - 1) {
                System.out.println("]");
            } else {
                System.out.println("|");
            }
        }
        System.out.print("[");
        for (int i=0; i<userPosition.size();i++) {
            if (userPosition.downAt(i)) {
                System.out.print(" O ");
            } else {
                System.out.print("   ");
            }
            if (i == userPosition.size() - 1) {
                System.out.println("]");
            } else {
                System.out.println("|");
            }
        }
    }

    public void printResult(UserPosition userPosition, Result result) {
        System.out.print("[");
        for (int i=0; i<userPosition.size();i++) {
            if (userPosition.upAt(i)) {
                System.out.print(" O ");
            } else {
                System.out.print("   ");
            }
            if (i == userPosition.size() - 1) {
                System.out.println("]");
            } else {
                System.out.println("|");
            }
        }
        System.out.print("[");
        for (int i=0; i<userPosition.size();i++) {
            if (userPosition.downAt(i)) {
                System.out.print(" O ");
            } else {
                System.out.print("   ");
            }
            if (i == userPosition.size() - 1) {
                System.out.println("]");
            } else {
                System.out.println("|");
            }
        }
    }
}
