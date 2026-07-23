public class Client {
    String passport;
    String name;
    int balance = 0;
    String password;
    public Client(String passportInput, String nameInput,String passwordInput){
        passport = passportInput;
        name = nameInput;
        password = passwordInput;
    }
    public void deposit(int amount){
        balance +=amount;
    }
    public boolean write(int amount){
        if(amount <= balance){balance-=amount;return true;}
        else{return false;}
    }
}
