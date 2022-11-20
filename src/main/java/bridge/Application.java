package bridge;

public class Application {

    public static void main(String[] args) {
        try{
            new Run();
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        // TODO: 프로그램 구현
    }
}
