package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Controller controller = new Controller();
            controller.getGame();
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
