package bridge;
import bridge.BridgeGame;
public class Application {

    public static void main(String[] args) {
        try {
            Controller controller = new Controller();
            controller.play();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
