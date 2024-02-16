import java.util.Scanner;

class Person {
    protected String surname;
    protected String firstName;
    protected String street;
    protected String zipCode;
    protected String city;

    public void initialize() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter surname: ");
        surname = scanner.nextLine();
        System.out.print("Enter first name: ");
        firstName = scanner.nextLine();
        System.out.print("Enter street: ");
        street = scanner.nextLine();
        System.out.print("Enter zip code: ");
        zipCode = scanner.nextLine();
        System.out.print("Enter city: ");
        city = scanner.nextLine();
    }
    public interface Employee_Interface {
        double salaryToPay(double hours, double rate);

        default double SalaryForOvertime(double hours, double rate) {
            if (hours > 90) {
                double overtimeHours = hours - 90;
                double overtimeRates=rate*1.5;
                return overtimeRates*overtimeHours;
            }
            return salaryToPay(hours, rate);
        }


        static boolean Bonus(int yearsOfExperience) {
            return yearsOfExperience > 5;
        }
    }
    public void print() {
        System.out.println("Surname: " + surname);
        System.out.println("First name: " + firstName);
        System.out.println("Street: " + street);
        System.out.println("Zip code: " + zipCode);
        System.out.println("City: " + city);
    }
}

 class Staff extends Person implements Person.Employee_Interface {
    private String education;
    private String position;
    public double hours;
    private double rate;
    int yearsOfExperience;

    public void initialize1() {
        initialize();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter education: ");
        education = scanner.nextLine();
        System.out.print("Enter position: ");
        position = scanner.nextLine();
        System.out.print("Enter hours :");
        hours=scanner.nextDouble();
        System.out.print("Enter the rate:");
        rate=scanner.nextDouble();
        System.out.print("Enter years of Experience:");
        yearsOfExperience=scanner.nextInt();

    }
    public void print1() {
        print();
        System.out.print("Education: " + education);
        System.out.print("Position: " + position);
        System.out.print("hours:"+hours);
        System.out.print("rates"+rate);
        System.out.print("Years of Experience"+yearsOfExperience);

    }


         @Override
         public double salaryToPay(double hours, double rate) {

             return hours*rate;
         }

         @Override
         public double SalaryForOvertime(double hours, double rate) {
             return Employee_Interface.super.SalaryForOvertime(hours, rate);
         }
         public void print2(){
             System.out.print("salary:"+salaryToPay(hours,rate));
             System.out.print("OvertimePay:"+SalaryForOvertime(hours,rate));

         }

 }
public class main2 {

    public static void main(String[] args) {
        Staff staff = new Staff();
        staff.initialize1();
        staff.print1();
        staff.print2();


    }
}
//you can override a default method,We cant override a static class and you finally you don't have to override a "normal" interface method.
//InterfaceName.staticMethodName(a static method is called by specifying the interface
//name, followed by a period, followed by the method name. Here is the general
//form)
