package racingcar;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ReadyForRacing {

    private final List<Car> racerList;


    public ReadyForRacing(boolean flag) {

        System.out.println(Info.CAR_NAME_INPUT);
        String racerLine = getInput();
        List<Car> list = new ArrayList<>();

        try {
            String[] racers = racerLine.split(",");

            for (String racer : racers) {
                if (!isInputEmpty(racer)) {
                    list.add(new Car(racer));
                }
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(Info.ERROR_MSG);
        }
        this.racerList = list;
    }

    protected String getInput() {
        return readLine();
    }

    protected int getNumberOfAttempts() {
        System.out.println(Info.NUMBER_OF_ATTEMPTS);
        int number = 0;
        try {
            number = Integer.parseInt(getInput());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(Info.ERROR_MSG_FOR_NUMBER);
            number = getNumberOfAttempts();
        }
        return number;
    }

    protected boolean isInputEmpty(String input) {
        if ("".equals(input) || StringUtils.isBlank(input)) {
            return true;
        }
        return false;
    }

    protected List<Car> getRacerList() {
        return racerList;
    }

    protected String lineList(List<Winner> winners) {
        return String.join(", " + winners);
    }
}
