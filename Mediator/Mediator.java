import java.util.ArrayList;
import java.util.List;

interface ChatMediator {
    void sendMessage(String msg, User user);
    void addUser(User user);
}

abstract class User {
    protected ChatMediator mediator;
    protected String name;

    User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }
    
    abstract public void send(String msg);
    abstract public void receive(String msg);
}

class UsertoChat extends User {
    public UsertoChat(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    public void send(String msg) {
        System.out.println(this.name + " sent: " + msg + "\n");
        mediator.sendMessage(msg, this);
    }

    public void receive(String msg) {
        System.out.println(this.name + " receive:" + msg);
    }
}

class ChatMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void sendMessage(String msg, User user) {
        for (User u : this.users) {
            if (u != user) {
                u.receive(msg);
            }
        }
    }
}

public class Mediator {

    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();

        User user1 = new UsertoChat(mediator, "Pedro");
        User user2 = new UsertoChat(mediator, "Maria");
        User user3 = new UsertoChat(mediator, "Juan");
        User user4 = new UsertoChat(mediator, "Ana");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        user1.send("Hi All");
        System.out.println();
        user2.send("Hi Pedro");
        System.out.println();
        user3.send("¡Hi Pedro and Maria!");
        System.out.println();
        user4.send("Hi, How are you all?");
    }
}