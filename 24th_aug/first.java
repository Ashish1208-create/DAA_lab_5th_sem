import java.util.Arrays;

public class first {

    public static void main(String[] args) {

        Activity[] activity = {
            new Activity(1, 1, 4),
            new Activity(2, 3, 5),
            new Activity(3, 0, 6),
            new Activity(4, 5, 7),
            new Activity(5, 3, 9),
            new Activity(6, 5, 9),
            new Activity(7, 6, 10),
            new Activity(8, 8, 11),
            new Activity(9, 8, 12),
            new Activity(10, 2, 14),
            new Activity(11, 12, 16)
        };

        // Sort according to finish time
        Arrays.sort(activity, (a, b) -> a.finish - b.finish);

        // Select first activity
        int count = 1;
        int lastFinish = activity[0].finish;

        System.out.println("Selected activities:");
        System.out.println(activity[0].activity);

        // Check remaining activities
        for (int i = 1; i < activity.length; i++) {

            // Activity is compatible
            if (activity[i].start >= lastFinish) {

                System.out.println(activity[i].activity);

                count++;
                lastFinish = activity[i].finish;
            }
        }

        System.out.println("Maximum activities = " + count);
    }
}

class Activity {
    int activity;
    int start;
    int finish;

    Activity(int activity, int start, int finish) {
        this.activity = activity;
        this.start = start;
        this.finish = finish;
    }
}