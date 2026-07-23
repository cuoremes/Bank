import com.sun.jdi.Value;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class menuCommand {
    public static void clearScreen(){
        Scanner input = new Scanner(System.in);
        System.out.println("Нажмите Enter чтобы продолжить");
        input.nextLine();
        for(int i=0;i<50;i++){
            System.out.println();
        }
    }
    public static void shortClearScreen(){
        for(int i=0;i<5;i++){
            System.out.println();
        }
    }
    public static void registration(BankDatabase database){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите номер паспорта:");
        String passport = input.next();

        System.out.println("Введите имя клиента:");
        String name = input.next();


        System.out.println("Придумайте пароль:");
        String password = input.next();

        database.registerClient(passport,name, password);
        System.out.println("Клиент " + name + " успешно зарегистрирован!"+"Номер паспорта: "+passport);
    }
    public static void search(BankDatabase database){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите номер паспорта для поиска:");
        String passport = input.nextLine();

        Client found = database.FindClient(passport);
        if(found ==null){
            System.out.println("Такой пользователь не зарегистрирован");
        }
        else{
            System.out.println("Имя клиента: "+ found.name+" Баланс: "+ found.balance+" рублей");
        }
        clearScreen();
    }
    public static void transfer(BankDatabase database){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите Ваш паспорт:");
        String fromPassport = input.nextLine();

        if(database.entryPassport(fromPassport)){
            System.out.println("Введите Ваш пароль:");
            String fromPassword = input.nextLine();

            if(database.entryPassword(fromPassport,fromPassword)){
                System.out.println("Введите паспорт получателя:");
                String toPassport = input.nextLine();

                if(database.entryPassport(toPassport)){
                    System.out.print("Введите сумму перевода: ");
                    int amount = input.nextInt();
                    boolean success = database.transfer(fromPassport, toPassport,amount);

                    if(success){
                        System.out.println("Операция прошла успешно");
                        clearScreen();
                    } else {System.out.println("!Операция отклонена!Недостаточно средств!");clearScreen();}

                }else{System.out.println("Данный пользователь не найден");clearScreen();}
            }else{System.out.println("!Введён неверный пароль!Доступ запрещён!ь");clearScreen();}
        }else{System.out.println("Данный пользователь не найден");clearScreen();}
    }
    public static void work(BankDatabase database){
        int count = 0;
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("Введите номер Вашего паспорта:");
        String fromPassport = input.nextLine();

        if(database.entryPassport(fromPassport)){
            System.out.println("Введите Ваш пароль:");
            String fromPassword = input.nextLine();

            if(database.entryPassword(fromPassport,fromPassword)){
                System.out.println("За каждый правильно решённый пример начисляется 100 рублей");
                System.out.println("В примерах с делением результатом округляется до целого в сторону нуля ");
                System.out.println("Нажмите Enter чтобы начать");
                input.nextLine();
                while(true){
                    int numberOne = random.nextInt(-1001,1001);
                    int numberTwo = random.nextInt(-1001,1001);
                    int operation = random.nextInt(4);
                    int result = switch (operation){
                        case 1:
                            System.out.println("("+numberOne+")"+"+"+"("+numberTwo+")"+" = ");
                            yield numberOne+numberTwo;
                        case 2:
                            System.out.println("("+numberOne+")"+"-"+"("+numberTwo+")"+" = ");
                            yield numberOne-numberTwo;
                        case 3:
                            System.out.println("("+numberOne+")"+"*"+"("+numberTwo+")"+" = ");
                            yield numberOne*numberTwo;
                        case 0:
                            System.out.println("("+numberOne+")"+"/"+"("+numberTwo+")"+" = ");
                            yield numberOne/numberTwo;
                        default:
                            yield 0;
                    };
                    int uAnswer = input.nextInt();
                    if (uAnswer==result){
                        System.out.println("Правильно! +100 рублей");
                        count+=1;
                    }
                    else{
                        System.out.println("Неправильно!");
                    }
                    System.out.println("1. Продолжить");
                    System.out.println("2. Вернуться в меню");
                    int command = input.nextInt();
                    if(command == 1){
                        System.out.println("Следующий пример:");
                    } else if (command==2) {
                        boolean salary = database.salary(fromPassport, count*100);
                        break;

                    }

                }

            }
        }
    }
}
