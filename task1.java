package kr8;

import java.util.ArrayList;
import java.util.List;



class Connection {

    int filed;
}

public class task1 {
    private static final int MAX_CONNECTIONS = 10;
    private static List<Connection> connections = new ArrayList<>();

    static {

        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            connections.add(new Connection());
        }
    }

    public static Connection getConnection() {

        if (!connections.isEmpty()) {
            return connections.remove(0);
        } else {

            throw new RuntimeException("No available connections.");
        }
    }

    public static void releaseConnection(Connection connection) {

        if (connections.size() < MAX_CONNECTIONS) {
            connections.add(connection);
        } else {

            System.out.println("Connection pool is full. Ignoring the connection.");
        }
    }

    public static void main(String[] args) {

        Connection connection1 = task1.getConnection();
        Connection connection2 = task1.getConnection();


        task1.releaseConnection(connection1);
        task1.releaseConnection(connection2);
    }
}
