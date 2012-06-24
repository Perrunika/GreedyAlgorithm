package robot;

/**
 *
 * @author Radoslava Radkova
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Robot {

    //time for the robot to rest after running every programmed km
    int timeOff;
    //arrays to store the needed km and time
    int[] arrayKm = new int[5];
    int[] arrayTime = new int[5];
    //used to store, map and sort the input km and time
    HashMap hashmap = new HashMap();

    //method used for setting the km and the time that the robot
    //can be programmed to run
    public void setProgrammedKmAndTime(int km1, int km2, int km3, int km4,
            int km5, int time1, int time2, int time3, int time4, int time5) {
        hashmap.put(km1, time1);
        hashmap.put(km2, time2);
        hashmap.put(km3, time3);
        hashmap.put(km4, time4);
        hashmap.put(km5, time5);

        // unsorted keys output
        Iterator it = hashmap.keySet().iterator();

        // sorted keys in ascending order
        List list = new ArrayList(hashmap.keySet());
        Collections.sort(list);

        //reverse the list
        Collections.reverse(list);
        it = list.iterator();

        //store the sorted keys and values in arrayKm and arrayTime
        while (it.hasNext()) {

            for (int i = 0; i < arrayKm.length; i++) {
                Integer element = (Integer) it.next();
                arrayKm[i] = element;
                arrayTime[i] = (Integer) hashmap.get(element);

                //    System.out.println(arrayKm[i] + "  i=" + i + "   " + arrayTime[i]);
            }
        }

    }

    //used for setting the time for the robot to rest
    public void setTimeOff(int time) {
        timeOff = time;
    }

    public int getTimeOff() {

        return timeOff;
    }

    //algorithmA to compute the min time for the Robot to run the required km
    public void getMinTimeUsingAlgorithmA(int TotalKMToTravel) {

        int kmLeftInJourney = TotalKMToTravel;
        int minTime = 0;

        //the while loop stops then the computed km to run is equal to 0
        while (kmLeftInJourney != 0) {

            //for loop used to compare the biggest km value in arrayKm
            //to the required Km to run.
            for (int i = 0; i < arrayKm.length;) {

                //if the km value in the arrayKm is smaller or equal,
                //it is subtracted from the km left to run
                if (kmLeftInJourney >= arrayKm[i]) {
                    System.out.println("==============");
                    kmLeftInJourney = kmLeftInJourney - arrayKm[i];
                    // The time that takes the robot to run these km
                    // is added to the minTime
                    minTime += arrayTime[i];

                    //printing current values
                    System.out.println("KM Travelled now: " + arrayKm[i]);
                    System.out.println("KM Travel left: " + kmLeftInJourney);
                    System.out.println("KM Travel total: "
                            + (TotalKMToTravel - kmLeftInJourney));
                    System.out.println("Time taken to get here: " + minTime);

                    //adds the time that the bobot is required to rest to the
                    //min Time
                    if (kmLeftInJourney != 0) {
                        minTime += timeOff;
                        System.out.println("Resting for: " + timeOff);
                    }
                    //when the kilometers left in the journey are smaller than
                    //the maximum value in the arrayKm, the loop continues with
                    //the next value in the array
                } else {
                    i++;
                }
            }
        }

        System.out.println("The minimum required time is: " + minTime + " min");

    }
}
