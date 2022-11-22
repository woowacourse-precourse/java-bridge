package bridge;
import java.util.InputMismatchException;


public class Application {
    public static void main(String[] args) {
        try {
            Game_Control gamecontrol = new Game_Control();
            gamecontrol.start();
        } catch (IllegalArgumentException e) {
            System.out.println(Message.INPUT_NUM_ERROR);
        } catch (IllegalStateException e) {
            System.out.println(Message.INPUT_U_D_ERROR);
        }catch(InputMismatchException e){
            System.out.println(Message.INPUT_CORRECT_COMMAND);
        }
    }
}
