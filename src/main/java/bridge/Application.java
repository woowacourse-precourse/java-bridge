package bridge;

public class Application {
    public static void main(String[] args) {
        try {
            new GameManager();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}