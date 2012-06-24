
package robot;

/**
 *
 * @author Radoslava Radkova
 */
public class Main {

    public static void main(String[] args) {

        Robot robot = new Robot();

        //setting resting time
        robot.setTimeOff(2);

        //setting five values of km to be programmed and five corresponding times
        robot.setProgrammedKmAndTime(1, 2, 3, 5, 10, 10, 5, 3, 2, 1);

        robot.getMinTimeUsingAlgorithmA(43);

    }
}