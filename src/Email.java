import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private int defaultPasswordLength;
    private String email;
    private String companySuffix;
    private int mailboxCapacity;

    // Constructor
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for department - return the department
        department= setDepartment();

        // Call a method that returns a random password
        defaultPasswordLength = 16;
        password = generatePassword(defaultPasswordLength);

        // Combine elements to generate email
        companySuffix = "company.com";
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }
    void display(){
        System.out.println(email + "," + password);
    }


    // setting values for department
    private String setDepartment(){
        System.out.println("DEPARTMENT CODES\n1 for sales\n2 for Development\n3 for Accounting\n4 for Department");
        Scanner sc = new Scanner(System.in);
        int depChoice = sc.nextInt();
        if(depChoice == 1) return "sales";
        else if (depChoice == 2) return "dev";
        else if (depChoice == 3) return "acct";
        else return "";
    }

    // Generate a random password
    private String generatePassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*<>?,./{}|[];':`~-=_+";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

}
