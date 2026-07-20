import java.util.HashMap;

public class BankDatabase {
    HashMap<String,Client> clients = new HashMap<>();
    public void registerClient(String passport, String name, int Balance ){
        Client newClient = new Client(passport,name,Balance);
        clients.put(passport,newClient);
    }
    public Client FindClient(String passport){
        return clients.get(passport);
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
}
