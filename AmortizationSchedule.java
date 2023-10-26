
import java.util.Scanner;

public final class AmortizationSchedule {

  
    private AmortizationSchedule() {
    }

    //calculate monthly payment formula
    public static double monthlyPayment(double balance, double rate,
            double length) {
        double monthlyRate = rate / 12;
        //(1+r)^n
        double rateUpdated = Math.pow((1 + monthlyRate), length);

        double payment = balance
                * ((monthlyRate * rateUpdated) / (rateUpdated - 1));
        return payment;
    }

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //getting input
        System.out.print("Enter your total loan amount: ");
        double balance = in.nextDouble();

        System.out.print("Enter the length of your loan in months: "); //double
        double length = in.nextDouble();

        System.out.print("Enter the loan's interest rate as a decimal: ");
        double rate = in.nextDouble();

        //calculating payments
        double pay = monthlyPayment(balance, rate, length);

        double interestPayment = balance * (rate / 12);

        double principal = pay - interestPayment;

        //print table
        System.out.printf(
                "---------------------------------------------------------------"
                        + "---------------------%n");
        System.out.printf(
                "                                Amortization Schedule          "
                        + "                     %n");
        System.out.printf(
                "---------------------------------------------------------------"
                        + "---------------------%n");

        System.out.printf(
                "  MONTH  | BALANCE | PRINCIPAL | INTEREST | MONTHLY PAYMENT | "
                        + "TOTAL PAID | REMAINING%n");
        System.out.printf(
                "---------------------------------------------------------------"
                        + "---------------------%n");
        double total = pay;
        double remaining = balance - principal;
        for (int i = 1; i < length + 1; i++) {

            System.out.printf(
                    "   %2d    | %7.2f |   %5.2f   |   %5.2f  |      %.2f"
                            + "      |  %7.2f   |  %.2f   %n",
                    i, balance, principal, interestPayment, pay, total,
                    remaining);
            //update
            total += pay;
            balance = remaining;
            interestPayment = balance * (rate / 12);
            principal = pay - interestPayment;
            remaining -= principal;

        }

        in.close();
    }

}
