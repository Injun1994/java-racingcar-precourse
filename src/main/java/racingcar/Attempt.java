package racingcar;

public class Attempt {

    protected int getNumberOfAttempts() {
        System.out.println(Info.NUMBER_OF_ATTEMPTS);
        int number = 0;
        try {
            number = Integer.parseInt(new ReadyForRacing(false).getInput());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(Info.ERROR_MSG_FOR_NUMBER);
            number = getNumberOfAttempts();
        }
        return number;
    }
}
