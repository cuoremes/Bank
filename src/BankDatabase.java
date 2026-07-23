import java.util.HashMap;
import java.util.Scanner;

public class BankDatabase {
    Scanner input = new Scanner(System.in);
    HashMap<String,Client> clients = new HashMap<>();
    public void registerClient(String passport, String name, String password){
        Client newClient = new Client(passport,name,password);
        clients.put(passport,newClient);
    }
    public Client FindClient(String passport){
        return clients.get(passport);
    }
    public boolean salary(String fromPassport, int amount){
        Client worker = FindClient(fromPassport);
        worker.deposit(amount);
        return true;

    }
    public boolean transfer(String fromPassport, String toPassport, int amount){
        Client sender = FindClient(fromPassport);
        Client receiver = FindClient(toPassport);
        if(sender == null || receiver == null){
            return false;
        }
        if(sender.write(amount)){
            receiver.deposit(amount);
            return true;
        }
        else{
            return false;
        }
    }
    public boolean entryPassport(String fromPassport){
        Client fromFound = FindClient(fromPassport);
        if(fromFound==null){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean entryPassword(String fromPassport,String fromPassword){
        Client fromFound = FindClient(fromPassport);
        if(fromPassword.equals(fromFound.password)){
            return true;
        }
        else{
            return false;
        }
    }
    /*public static void entry(Scanner input, BankDatabase database){
        System.out.println("Введите номер Вашего паспорта:");
        String fromPassport = input.nextLine();
        if(database.entryPassport(input,fromPassport)){
            System.out.println("Введите Ваш пароль:");
            String fromPassword = input.nextLine();
            if(database.entryPassword(input,fromPassport,fromPassword)){

            }

        }
        else{
            System.out.println("Данный пользователь не найден");
            menuCommand.clearScreen(input);

        }
    }*/

    }

