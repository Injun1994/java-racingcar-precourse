package racingcar;

public class Attempt {
    protected int getNumberOfAttempts() {
        Info info = new Info();
        info.outputNumberOfAttempts();

        int number = 0;
        try {
            number = Integer.parseInt(new Input(null).getInput());
        } catch (IllegalArgumentException illegalArgumentException) {
            info.outputErrorMsgForNumber();
            number = getNumberOfAttempts();
        }
        return number;
    }
}
