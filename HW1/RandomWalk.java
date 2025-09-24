import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class RandomWalk {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(-n - 0.5, n + 0.5);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();

        int x = 0, y = 0;
        int steps = 0;

        int stepSize = 1;
        int direction = 0;
        int changes = 0;


        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledSquare(x, y, 0.45);
        StdDraw.show();
        StdDraw.pause(100);

        while (Math.abs(x) <= n && Math.abs(y) <= n) {
            for (int i = 0; i < stepSize; i++) {
                if (direction == 0) y--;
                else if (direction == 1) x--;
                else if (direction == 2) y++;
                else if (direction == 3) x++;

                steps++;

                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.filledSquare(x, y, 0.45);
                StdDraw.show();
                StdDraw.pause(50);


                if (Math.abs(x) > n || Math.abs(y) > n) {
                    StdOut.println("Total steps = " + steps);
                    return;
                }
            }


            direction = (direction + 1) % 4;
            changes++;

            if (changes % 2 == 0) {
                stepSize++;
            }
        }
    }

}
