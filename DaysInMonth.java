import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DaysInMonth {


    /**
     * Compute the number of days in the specified month of the specified year.
     * @param m
     * @param y
     * @return
     */
    static int Days(int m, int y) {

        // **** initialization ****
        int days = 0;
    
        // **** these months hold 31 days ****
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
            days = 31;
        }

        // **** these months hold 30 days ****
        else if (m == 4 || m == 6 || m == 9 || m == 11) {
            days = 30;
        }

        // **** feb may hold 28 or 29 days ****
        if (m == 2) {
            if (y % 400 == 0 && y % 100 == 0) {
                days = 29;
            }
            else {
                if (y % 4 == 0 && y % 100 != 0) {
                    days = 29;
                }
                else {
                    days = 28;
                }
            }
        }

        // **** return the number of days in the specified month of the specified year ****
        return days;
    }


    /**
     * Test scaffold
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** initialization ****
        String[] monthNames = { "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        // **** open a buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** get m number (1 == Jan, ..., 12 == Dec) ****
        System.out.print("main >>> month [1..12]: ");
        int m = Integer.parseInt(br.readLine().trim());
        if (m < 1 || m > 12) {
            System.err.println("main <<< unexpected month: " + m);
            System.exit(-1);
        }

        // ???? ????
        System.out.println("main <<< month: " + m);
        // **** get y ****
        System.out.print("main >>> year: ");
        int y = Integer.parseInt(br.readLine().trim());

        // ???? ????
        System.out.println("main <<< year: " + y);

        // **** close the buffered reader ****
        br.close();

        // **** compute the number of days in the specified month of the specified year ****
        int days = Days(m, y);

        // **** display number of days in the specified month of the specified year ****
        System.out.println("main <<< # of days  in " + monthNames[m - 1] + ", " + y + ": " + days);

        // **** compute and display the number of hours in the specified month of the specified year ****
        int hours = days * 24;
        System.out.println("main <<< # of hours in " + monthNames[m - 1] + ", " + y + ": " + hours);
    }
}