import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    ManagementDirectory managerDirectory = new ManagementDirectory();
    Regex regex = new Regex();
    boolean check = true;
    String noResult = "No Result!";
    String error = "ERROR!";
    String done = "DONE!";
    String display;
    int choice;
    String numberPhone;
    int group = 3;
    String name;
    int gender = 3;
    String address;
    int id;
    String email;
    final int FIRST = 1;
    final int SECOND = 2;
    final int THIRD = 3;
    final int FORTH = 4;
    final int FIFTH = 5;
    final int SIXTH = 6;

    Scanner scanner = new Scanner(System.in);

    public Menu() throws IOException {
    }

    public void menuMain() {
        display = """
                                
                    MENU DIRECTORY
                    1. SHOW
                    2. ADD NEW
                    3. UPDATE
                    4. DELETE
                    5. FIND
                    6. OUT
                                
                """;
        System.out.println(display);
        try {
            choice = scanner.nextInt();
            switch (choice) {
                case FIRST:
                    menuShow();
                    break;
                case SECOND:
                    menuAdd();
                    break;
                case THIRD:
                    menuEdit();
                    break;
                case FORTH:
                    menuDel();
                    break;
                case FIFTH:
                    menuFind();
                    break;
                case SIXTH:
                    System.exit(1);
                    break;
                default:
                    System.out.println(error);
                    menuMain();
            }
        } catch (Exception e) {
            System.out.println(error);
            scanner.nextLine();
            menuMain();
        }
        }

    public void menuAdd() throws IOException {
        scanner.nextLine();
        managerDirectory.add(menuNewDir());
        System.out.println(done);
        menuMain();
    }

    public void menuEdit() throws IOException {
        System.out.println("Nhap vao ID muon sua");
        id = scanner.nextInt();
        scanner.nextLine();
        int index = managerDirectory.findByID(id);
        if (index != -1) {
            managerDirectory.edit(id, menuNewDir());
            System.out.println(done);
        } else {
            System.out.println(noResult);
        }
        menuMain();
    }

    public void menuFind() {
        System.out.println("Nhap vao ID muon tim");
        id = scanner.nextInt();
        int index = managerDirectory.findByID(id);
        if (index != -1) {
            managerDirectory.directoryList.get(index);
        } else {
            System.out.println(noResult);
        }
        menuMain();
    }

    public void menuShow() {
        if (managerDirectory.getDirectoryList().isEmpty()) {
            System.out.println("Empty!");
        } else {
            managerDirectory.showAll();

        }
        menuMain();
    }

    public void menuDel() {
        System.out.println("Nhap vao ID muon tim");
        id = scanner.nextInt();
        int index = managerDirectory.findByID(id);
        if (index != -1) {
            managerDirectory.delete(id);
            System.out.println(done);
        } else {
            System.out.println(noResult);
        }
        menuMain();
    }

    public Directory menuNewDir() {
        do {
            System.out.println("Nhap vao so dien thoai");
            numberPhone = scanner.nextLine();
        } while (!regex.regexNumberPhone(numberPhone));

        try {

            System.out.println("Chon nhom! 1 - Gia dinh || 2 - Cong viec");

            group = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Chon nhom! 1 - Gia dinh || 2 - Cong viec");
            scanner.nextLine();
            group = scanner.nextInt();
        }
        scanner.nextLine();
        System.out.println("Nhap vao ten");
        name = scanner.nextLine();
        do {
            try {

                System.out.println("Nhap vao gioi tinh! 1 - Nam || 2 - Nu");
                gender = scanner.nextInt();
                check = false;
            } catch (Exception e) {
                System.out.println("Nhap vao gioi tinh! 1 - Nam || 2 - Nu");
                scanner.nextLine();
                gender = scanner.nextInt();
            }
        } while (check);
        scanner.nextLine();
        System.out.println("Nhap vao dia chi");
        address = scanner.nextLine();
        do {
            System.out.println("Nhap vao Email");
            email = scanner.nextLine();
        } while (!regex.regexEmail(email));
        return new Directory(numberPhone, group, name, gender, address, email);
    }
}
