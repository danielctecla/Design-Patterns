class DatabaseConnection {
    private String connectionString;

    public DatabaseConnection(String connectionString) {
        this.connectionString = connectionString;
    }

    public void executeQuery(String query) {
        System.out.println("Executing query: " + query + " on " + connectionString);
    }

}

class DatabaseConnectionManager {
    private static DatabaseConnectionManager instance;
    private DatabaseConnection connection;

    private DatabaseConnectionManager() {
        connection = new DatabaseConnection("jdbc:mysql://localhost:3306/myDatabase");
    }

    public static synchronized DatabaseConnectionManager getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionManager();
        }
        return instance;
    }

    public DatabaseConnection getConnection() {
        return connection;
    }

}

public class Singleton {
    public static void main(String[] args) {
        // Get the singleton instance
        DatabaseConnectionManager manager = DatabaseConnectionManager.getInstance();

        DatabaseConnection connection = manager.getConnection();
        connection.executeQuery("SELECT * FROM users");

        DatabaseConnectionManager anotherManagerInstance = DatabaseConnectionManager.getInstance();
        DatabaseConnection anotherConnection = anotherManagerInstance.getConnection();
        anotherConnection.executeQuery("UPDATE users SET name = 'John' WHERE id = 1");

        System.out.println("Are both instances the same? " + (manager == anotherManagerInstance));
    }
}
