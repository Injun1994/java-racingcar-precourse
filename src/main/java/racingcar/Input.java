package racingcar;

import org.junit.platform.commons.util.StringUtils;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private List<Car> racerList;

    public Input(List<Car> racerList) {
        if (racerList == null) {
            return;
        }

        Info info = new Info();
        info.outputCarNameInput();
        String racerLine = getInput();

        try {
            String[] racers = racerLine.split(",");

            for (String racer : racers) {
                if (!isInputEmpty(racer)) {
                    racerList.add(new Car(racer));
                }
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            info.outputErrorMsg();
        }
        this.racerList = racerList;
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
}
