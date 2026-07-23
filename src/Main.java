import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        BankDatabase database = new BankDatabase();
        Scanner input = new Scanner(System.in);
        System.out.println("МОДУЛЬ БАНКА");
        while (true){
            System.out.println("--- МЕНЮ ОБСЛУЖИВАНИЯ ---");
            System.out.println("1. Зарегистрировать нового клиента");
            System.out.println("2. Найти клиента по паспорту");
            System.out.println("3. Перевести деньги");
            System.out.println("4. Заработок");
            System.out.println("0. Выйти из системы");
            System.out.println("Выберите действие:");
            int command = input.nextInt();
            input.nextLine();
            if(command == 0){
                System.out.println("Работа завершена");
                break;
            }
            if(command==1){
               menuCommand.registration(database);
            }
            if(command==2){
                menuCommand.search(database);
            }
            if(command==3){
                menuCommand.transfer(database);
            }
            if(command==4){
                menuCommand.work(database);
            }
        }
    }
}