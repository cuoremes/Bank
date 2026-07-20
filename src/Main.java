import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        BankDatabase db = new BankDatabase();
        Scanner input = new Scanner(System.in);
        System.out.println("МОДУЛЬ БАНКА");
        while (true){
            System.out.println("--- МЕНЮ ОБСЛУЖИВАНИЯ ---");
            System.out.println("1. Зарегистрировать нового клиента");
            System.out.println("2. Найти клиента по паспорту");
            System.out.println("3. Перевести деньги");
            System.out.println("0. Выйти из системы");
            System.out.println("Выберите действие:");
            int command = input.nextInt();
            input.nextLine();
            if(command == 0){
                System.out.println("Работа завершена");
                break;
            }
            if(command==1){
                System.out.println("Введите номер паспорта:");
                String passport = input.nextLine();

                System.out.println("Введите имя клиента:");
                String name = input.nextLine();

                System.out.println("Введите свой баланс:");
                int  balance = input.nextInt();


                db.registerClient(passport,name,balance);
                System.out.println("Клиент "+ name+ " успешно зареган!");

            }
            if(command==2){
                System.out.println("Введите номер паспорта для поиска:");
                String passport = input.nextLine();

                Client found = db.FindClient(passport);

                if(found ==null){
                    System.out.println("Такой пользователь не зарегистрирован");
                }
                else{
                    System.out.println("Имя клиента: "+ found.name+" Баланс: "+ found.balance+" рублей");

                }

            }
            if(command==3){
                System.out.print("Введите паспорт отправителя: ");
                String fromPassport = input.nextLine();

                System.out.print("Введите паспорт получателя: ");
                String toPassport = input.nextLine();

                System.out.print("Введите сумму перевода: ");
                int amount = input.nextInt();

                boolean success = db.transfer(fromPassport, toPassport,amount);
                    if(success){
                        System.out.println("Операция прошла успешно");
                    }
                    else {
                        System.out.println("Операция отклонена");
                    }


            }


        }
    }
}