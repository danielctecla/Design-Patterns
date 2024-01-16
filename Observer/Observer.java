import java.util.Set;
import java.util.HashSet;

interface ObserverObject {
    void update(String post);
}

interface SubjectObservable {
    void registerObserver(ObserverObject observer);
    void removeObserver(ObserverObject observer);
    void notifyObservers(String post);
}

class User implements ObserverObject, SubjectObservable {
    private Set<ObserverObject> followers;
    private String name;

    User(String name) {
        this.name = name;
        this.followers = new HashSet<>();
    }

    public void registerObserver(ObserverObject observer) {
        followers.add(observer);
    }

    public void removeObserver(ObserverObject observer) {
        followers.remove(observer);
    }

    public void notifyObservers(String post) {
        for (ObserverObject observer : followers) {
            observer.update(post);
        }
    }

    public void update(String post) {
        System.out.println();
        System.out.println(this.name + " received a notification \nPost: " + post + "\n");
    }

    public void follow(User user) {
        user.registerObserver(this);
        System.out.println(this.name + " followed " + user.name);
        System.out.println();
    }

    public void unfollow(User user) {
        user.removeObserver(this);
        System.out.println(this.name + " unfollowed " + user.name);
        System.out.println();
    }

    public void post(String post) {
        System.out.println(this.name + " posted: " + post);
        notifyObservers(post);
    }    
}

public class Observer {
    public static void main(String[] args) {
        User daniel = new User("Daniel Catonga");
        User john = new User("John Doe");
        User tony = new User("Tony Stark");

        tony.follow(daniel);
        tony.follow(john);

        daniel.post("Hi, I'm Daniel! This is my first post.");
        john.post("Hi, I'm John! This is my first post.");

        tony.unfollow(daniel);
        daniel.follow(john);

        daniel.post("Hi, I'm Daniel! This is my second post.");
        john.post("Hi, I'm John! This is my second post.");
    }
}
