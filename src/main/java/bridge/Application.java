package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            new GameMachine().run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("[ERROR] 확인되지 못한 에러가 발생하였습니다.");
            System.out.println(e.getMessage());
        }
    }
}
