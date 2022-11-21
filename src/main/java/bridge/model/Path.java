package bridge.model;

import bridge.resource.InputType;

public class Path {
    private static final String FORMAT_OF_PATH_START = "[";
    private static final String FORMAT_OF_PATH_END = "]";
    private static final String FORMAT_OF_SEPARATOR = "|";
    private static final String CORRECT_BLOCK = " O ";
    private static final String INCORRECT_BLOCK = " X ";
    private static final String EMPTY_BLOCK = "   ";

    private String path;
    private final InputType commandType;

    public Path(InputType commandType) {
        this.path = FORMAT_OF_PATH_START;
        this.commandType = commandType;
    }

    public String getPath() {
        return path;
    }

    public void clear() {
        this.path = FORMAT_OF_PATH_START;
    }

    public void updateCorrectBlock(String command) {
        replaceEndFormatToSeparator();

        if (command.equals(commandType.getCommand())) {
            addCorrectBlock();
            return;
        }

        addEmptyBlock();
    }

    public void updateIncorrectBlock(String command) {
        replaceEndFormatToSeparator();

        if (command.equals(commandType.getCommand())) {
            addIncorrectBlock();
            return;
        }

        addEmptyBlock();
    }

    private void replaceEndFormatToSeparator() {
        path = path.replace(FORMAT_OF_PATH_END, FORMAT_OF_SEPARATOR);
    }

    private void addCorrectBlock() {
        path += CORRECT_BLOCK + FORMAT_OF_PATH_END;
    }

    private void addIncorrectBlock() {
        path += INCORRECT_BLOCK + FORMAT_OF_PATH_END;
    }

    private void addEmptyBlock() {
        path += EMPTY_BLOCK + FORMAT_OF_PATH_END;
    }
}
