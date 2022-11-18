package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            Controller controller = new Controller();


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
