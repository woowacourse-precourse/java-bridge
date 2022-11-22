package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            GameController gameController = new GameController();
            gameController.startGame();
        }catch (CloneNotSupportedException e){
            System.out.println("clone error");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
