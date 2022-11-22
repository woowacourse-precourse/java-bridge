package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game=new Game();
        try{
            game.start();
        }catch (IllegalArgumentException E){
            System.out.println(E.getMessage());
        }
    }
}
