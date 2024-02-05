package racingcar;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ReadyForRacing {

    private final List<Car> racerList;


    public ReadyForRacing(boolean flag) {
        racerList = new ArrayList<>();

        if (!flag) {
            return;
        }

        System.out.println(Info.CAR_NAME_INPUT);
        String racerLine = getInput();

        try {
            String[] racers = racerLine.split(",");

            for (String racer : racers) {
                if (!isInputEmpty(racer)) {
                    racerList.add(new Car(racer));
                }
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(Info.ERROR_MSG);
        }
    }

    protected String getInput() {
        return readLine();
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
        String line = "";
        String join = ", ";

        for (Winner winner : winners) {
            line += winner.valueOf("") + join;
        }
        if (line.lastIndexOf(join) != -1) {
            line = line.substring(0, line.length() - join.length());
        }
        return line;
    }
}
