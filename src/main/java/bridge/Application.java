package bridge;

import controller.GameController;

public class Application {
    //TODO 리드미 확인할 것
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // TODO: View 에서는 최소한의 검증만 -> 알파벳 대문자인지만 확인하고 도메인에서 확인할 것
        // TODO: Dto 적용해보기, Service, Repository 적용해보기
        // TODO: 마지막에 실패한 경우 예외 처리
        try {
            GameController gameController = new GameController();
            gameController.control();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
