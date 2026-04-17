package Lab01;
import java.util.Scanner;
public class DaysInMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strMonth;
        int year;

        while (true) {
            System.out.print("Enter Month (e.g. 1, Jan, January): ");
            strMonth = sc.next().toLowerCase();
            System.out.print("Enter Year: ");
            
            if (sc.hasNextInt()) {
                year = sc.nextInt();
                if (year < 0) {
                    System.out.println("Invalid year. Please try again.");
                    continue;
                }
            } else {
                System.out.println("Invalid year format. Please try again.");
                sc.next(); // clear buffer
                continue;
            }

            int days = getDays(strMonth, year);
            if (days != -1) {
                System.out.println("Number of days: " + days);
                break;
            } else {
                System.out.println("Invalid month. Please try again.");
            }
        }
        sc.close();
    }

    // Hàm kiểm tra tháng và trả về số ngày
    public static int getDays(String m, int y) {
        if (m.equals("1") || m.equals("jan") || m.equals("jan.") || m.equals("january")) return 31;
        if (m.equals("3") || m.equals("mar") || m.equals("mar.") || m.equals("march")) return 31;
        if (m.equals("5") || m.equals("may") || m.equals("may.") || m.equals("may")) return 31;
        if (m.equals("7") || m.equals("jul") || m.equals("jul.") || m.equals("july")) return 31;
        if (m.equals("8") || m.equals("aug") || m.equals("aug.") || m.equals("august")) return 31;
        if (m.equals("10") || m.equals("oct") || m.equals("oct.") || m.equals("october")) return 31;
        if (m.equals("12") || m.equals("dec") || m.equals("dec.") || m.equals("december")) return 31;
        
        if (m.equals("4") || m.equals("apr") || m.equals("apr.") || m.equals("april")) return 30;
        if (m.equals("6") || m.equals("jun") || m.equals("jun.") || m.equals("june")) return 30;
        if (m.equals("9") || m.equals("sep") || m.equals("sep.") || m.equals("september")) return 30;
        if (m.equals("11") || m.equals("nov") || m.equals("nov.") || m.equals("november")) return 30;

        if (m.equals("2") || m.equals("feb") || m.equals("feb.") || m.equals("february")) {
            // Kiểm tra năm nhuận
            if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) return 29;
            else return 28;
        }
        return -1; // Tháng không hợp lệ
    }
}
