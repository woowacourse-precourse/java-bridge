package bridge;

import controller.GameController;

public class Application {
    //TODO 리드미 확인할 것
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // TODO: View 에서는 최소한의 검증만 -> 알파벳 대문자인지만 확인하고 도메인에서 확인할 것
        // TODO: 마지막에 실패한 경우 예외 처리
        // TODO: 요구사항 제발 제대로 찬찬히 읽어보기
        try {
            GameController gameController = new GameController();
            gameController.control();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
