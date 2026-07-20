public class Client {
    String passport;
    String name;
    int balance;
    public Client(String passportInput, String nameInput, int balanceInput){
        passport = passportInput;
        name = nameInput;
        balance = balanceInput;

    }
    public void deposit(int amount){
        balance +=amount;
    }
    public boolean write(int amount){
        if(amount <= balance){balance-=amount;return true;}
        else{return false;}
    }

}
