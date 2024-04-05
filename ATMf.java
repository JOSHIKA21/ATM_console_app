import java.util.*;

class Bank {
    int bnkid;
    String ifsc;
    String loc;
    Double depositamt;

    public Bank(int bnkid, String ifsc, String loc, Double depositamt) {
        this.bnkid = bnkid;
        this.ifsc = ifsc;
        this.loc = loc;
        this.depositamt = depositamt;
    }
}

class User {
    Double accno;
    String name;
    Double phoneno;

    User(String name, Double accno, Double phoneno) {
        this.accno = accno;
        this.name = name;
        this.phoneno = phoneno;
    }
}

class ATM {
    double usedamt;
    double remamt;
    double refillAmt;
    Double depositamt;
    double totalamt;
    public int bnkid;

    public ATM(double usedamt) {
        this.usedamt = usedamt;
    }

    public double getRemainingAmt() {
        return remamt = depositamt - usedamt;
    }

    public double refill() {
        return totalamt = remamt + refillAmt;
    }
}

class Banks {
    ArrayList<Bank> bank = new ArrayList<>();
    ArrayList<ATM> atm = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void BankRole() {
        System.out.println(
                "Choose Operation to perform: \n1.Search ATM\n2.Check Balance in ATM\n3.Refill amount in ATM\n4.Exit");
        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();
        if (ch == 1) {
            searchATM();
        } else if (ch == 2) {
            checkBalance();
        } else if (ch == 3) {
            refillAmt();
        } else if (ch == 4) {
            System.out.println("Thank you! Action successfull. You can go back");
        } else {
            System.out.println("Please enter a valid choice");
        }
        System.out.println("Do you want to proceed further? Y/N");
        String c = sc.next();
        if (c.equals("y") || c.equals("Y")) {
            while (ch != 6) {
                BankRole();
            }
        } else if (c.equals("n") || c.equals("N")) {
            System.out.println("Thank you for checking ATM details");
        }
    }

    void searchATM() {
        System.out.println("Enter Bank id to search for ATM's: ");
        int id = sc.nextInt();
        boolean found = false;
        for (Bank b : bank) {
            if (id == b.bnkid) {
                System.out.println("Bank Id:" + b.bnkid);
                System.out.println("IFSC Code: " + b.ifsc);
                System.out.println("Bank Location :" + b.loc);
                System.out.println("Minimum Amount in ATM: " + b.depositamt);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No ATM found matching with given Id: " + id);
        }
    }

    void checkBalance() {
        System.out.print("Enter bank id to check remaining amount in ATM: ");
        int id = sc.nextInt();
        for (ATM a : atm) {
            if (id == a.bnkid) {
                System.out.println("Bank Id:" + id);
                System.out.println("Remaining Amount in ATM: " + a.getRemainingAmt());
                return;
            }
        }
        System.out.println("ATM for Bank with ID " + id + " not found.");
    }

    void refillAmt() {
        System.out.println("Emter bank id to check remaining amount in ATM: ");
        int id = sc.nextInt();
        ATM a = new ATM(id);
        for (Bank b : bank) {
            if (id == b.bnkid) {
                System.out.println("Bank Id:" + b.bnkid);
                System.out.println("Bank Location :" + b.loc);
                System.out.println("Minimum Amount in ATM: " + a.refillAmt);
            }
        }
    }

}

class Admin {
    ArrayList<Bank> bank = new ArrayList<>();
    ArrayList<User> user = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void AdminRole() {
        System.out.println(
                "Which operation you need to perform:\n 1.Add ATM setup\n2.Add User\n3.View ATM list\n4.View user list\n5.Remove ATM details\n6.Exit");
        System.out.print("Enter your choice: ");
        int opt = sc.nextInt();
        if (opt == 1) {
            addATMdetails();
        } else if (opt == 2) {
            addUser();
        } else if (opt == 3) {
            viewATMlist();
        } else if (opt == 4) {
            viewUserList();
        } else if (opt == 5) {
            removeATM();
        } else if (opt == 6) {
            System.out.println("Thank you");
        } else {
            System.out.println("Please enter a correct option to perform an operation");
        }
        System.out.println("Do you want to continue? Y/N");
        String ch = sc.next();
        if (ch.equals("y") || ch.equals("Y")) {
            while (opt != 6) {
                AdminRole();
            }
        } else {
            System.out.println("Thank you Have a nice day");
        }

    }

    void addATMdetails() {

        System.out.print("Enter ATM id: ");
        int bnkid = sc.nextInt();
        System.out.print("Enter Bank IFSC code: ");
        String ifsc = sc.next();
        System.out.print("Enter ATM'S location: ");
        String loc = sc.next();
        System.out.print("Enter ATM's minimum deposit amount: ");
        Double depositamt = sc.nextDouble();
        Bank b1 = new Bank(bnkid, ifsc, loc, depositamt);
        bank.add(b1);
        System.out.println("ATM setup completed successfully");

    }

    void addUser() {
        System.out.print("Enter Your name: ");
        String name = sc.next();
        System.out.print("Enter You Account Number: ");
        Double accno = sc.nextDouble();
        System.out.print("Enter Your Mobile number: ");
        Double phoneno = sc.nextDouble();
        User u1 = new User(name, accno, phoneno);
        user.add(u1);
        System.out.println("Successfully Added a new user");
    }

    void viewATMlist() {
        for (Bank b : bank) {
            System.out.println("ATM ID: " + b.bnkid + " Bank IFSC code: " + b.ifsc + " ATM'S location: " + b.loc
                    + " ATM's minimum deposit amount: " + b.depositamt);
        }
    }

    void viewUserList() {
        for (User u : user) {
            System.out.println("User name: " + u.name);
            System.out.println("Account number: " + u.accno);
            System.out.println("Phone no: " + u.phoneno);
        }
    }

    void removeATM() {
        int idx = 0;
        System.out.println("Enter ATM id to delete: ");
        int id = sc.nextInt();
        for (Bank b : bank) {
            if (b.bnkid == id) {
                idx = bank.indexOf(b);
            }
        }
        bank.remove(idx);
        System.out.println("ATM removed from");
    }
}

class Atm {
    double accno;
    String name;
    String pin;
    double balance;

    public Atm(double accno, String accname, String pin, double balance) {
        this.accno = accno;
        this.name = accname;
        this.pin = pin;
        this.balance = balance;
    }

    double getAccountNumber() {
        return accno;
    }

    boolean verifyPin(String pin) {
        return this.pin.equals(pin);
    }

    double getBalance() {
        return balance;
    }

    void deposit(double amt) {
        balance += amt;
    }

    boolean withdraw(double amt) {
        if (balance >= amt) {
            balance -= amt;
            return true;
        }
        return false;

    }
}

class customer {
    Scanner sc = new Scanner(System.in);
    Atm acc;
    int pin;

    public customer(Atm acc) {
        this.acc = acc;
    }

    void login() {
        System.out.println("Enter your name: ");
        String name = sc.next();
        System.out.println("Please enter your 4-digit PIN: ");
        String pass = sc.next();
        if (acc.verifyPin(pass)) {
            System.out.println("Login Successfull");
            userFunctions();
        } else {
            System.out.println("Ivalid PIN");
        }
    }

    void userFunctions() {
        while (true) {
            System.out.println(
                    "Please choose a option to perform: \n1.View Bank Balance\n2.Deposit\n3.Withdraw\n4.Pin change\n5.Mini Statement\n6.Exit");
            int op = sc.nextInt();
            if (op == 1) {
                viewBalance();
            } else if (op == 2) {
                depositAmt();
            } else if (op == 3) {
                withdrawAmt();
            } else if (op == 4) {
                pinChange();
            } else if (op == 5) {
                miniStatement();
            } else if (op == 6) {
                System.out.println("Thank U");
            } else {
                System.out.println("Please enter a valid input :)");
            }
            System.out.println("Do you want to continue? Y/N");
            String ch = sc.next();
            if (ch.equals("y") || ch.equals("Y")) {
                userFunctions();
            } else if (ch.equals("n") || ch.equals("N")) {
                System.out.println("Thank you! Have a good day");
                break;
            }
        }
    }

    void viewBalance() {
        System.out.println("Your balance is: " + acc.getBalance());
    }

    void depositAmt() {
        System.out.println("Enter amount to be deposited: ");
        double depositAmount = sc.nextDouble();
        acc.deposit(depositAmount);
        System.out.println("Amount deposited\t Your Balance is: Rs." + acc.getBalance());
    }

    void withdrawAmt() {
        System.out.println("Enter Amount to be withdrawn: ");
        double withdrawAmount = sc.nextDouble();
        if (acc.withdraw(withdrawAmount)) {
            System.out.println("Amount withdrawn\t Your Balance is: Rs." + acc.getBalance());
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    void pinChange() {
        System.out.println("Enter your current 4-digit PIN: ");
        String currentPin = sc.next();
        String regex = "\\d{4}";
        if (!currentPin.matches(regex)) {
            System.out.println("Invalid PIN format. PIN must be 4 digits.");
            return;
        }
        System.out.println("Enter your new 4-digit PIN: ");
        String newPin = sc.next();
        if (!newPin.matches(regex)) {
            System.out.println("Invalid PIN format. PIN must be 4 digits.");
            return;
        }
        System.out.println("Confirm your new 4-digit PIN: ");
        String confirmPin = sc.next();
        if (!confirmPin.matches(regex)) {
            System.out.println("Invalid PIN format. PIN must be 4 digits.");
            return;
        }
        if (newPin.equals(confirmPin)) {
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("PINs do not match. Please try again.");
        }

    }

    void miniStatement() {
        System.out.println("=================================================");
        System.out.println("MINI STATEMENT");
        System.out.println("NAME: " + acc.name);
        System.out.println("ACCOUNT NUMBER: " + acc.accno);
        System.out.println("Balance: " + acc.getBalance());
        System.out.println("=================================================");
    }
}

/**
 * ATM
 */
public class ATMf {
    public static void main(String[] args) {
        System.out.println("Enter your role:\n 1.Admin\n 2.User\n3.Banks");
        Scanner sc = new Scanner(System.in);
        Admin a1 = new Admin();
        Banks b1 = new Banks();
        Atm a = new Atm(9876543, "user1", "1234", 1000);
        customer u1 = new customer(a);
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        if (choice == 1) {
            a1.AdminRole();
        } else if (choice == 2) {
            u1.login();
        } else if (choice == 3) {
            b1.BankRole();
        }

    }
}
