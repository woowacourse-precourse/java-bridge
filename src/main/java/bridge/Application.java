package bridge;

public class Application {

    public static void main(String[] args) {

    }

    public static void errorHandling(String errorMessage){
        System.out.println("[ERROR]" + errorMessage);
        throw new IllegalArgumentException();
    }
}
