package Lab5pgm1;
import java.util.Scanner;

// Interface for the Bank
interface BankInterface {
    double getBalance();
    double getInterestRate();
}

// BankA implementation
class BankA implements BankInterface {
    private double balance;

    BankA(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.0;
    }
}

// BankB implementation
class BankB implements BankInterface {
    private double balance;

    BankB(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.4;
    }
}

// BankC implementation
class BankC implements BankInterface {
    private double balance;

    BankC(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.9;
    }
}

// Main Class
public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept user input for balances
        System.out.println("Enter deposit for Bank A: ");
        double depositA = scanner.nextDouble();
        System.out.println("Enter deposit for Bank B: ");
        double depositB = scanner.nextDouble();
        System.out.println("Enter deposit for Bank C: ");
        double depositC = scanner.nextDouble();

        BankA bankA = new BankA(depositA);
        BankB bankB = new BankB(depositB);
        BankC bankC = new BankC(depositC);

        System.out.println("Bank A - Balance: " + bankA.getBalance() + ", Interest Rate: " + bankA.getInterestRate() + "%");
        System.out.println("Bank B - Balance: " + bankB.getBalance() + ", Interest Rate: " + bankB.getInterestRate() + "%");
        System.out.println("Bank C - Balance: " + bankC.getBalance() + ", Interest Rate: " + bankC.getInterestRate() + "%");

        scanner.close();
    }
}
