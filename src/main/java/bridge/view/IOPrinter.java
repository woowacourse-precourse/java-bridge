package bridge.view;

public class IOPrinter {

    protected void print(final Object message) {
        System.out.print(message);
    }

    protected void println(final Object message) {
        System.out.println(message);
    }

    protected void println() {
        System.out.println();
    }

    protected void printBeforeNextLine(final Object message) {
        this.println();
        this.print(message);
    }

    protected void printlnBeforeNextLine(final Object messsage) {
        this.printBeforeNextLine(messsage);
        this.println();
    }
}
