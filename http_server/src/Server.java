import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.Date;

/**
 * Java program to create a simple HTTP Server using ServerSocket and Socket class.
 * @author Isabela Cardoso
 **/
public class Server {
    private ServerSocket serverSocket;

    // Constructor that initializes the server socket with the given port number
    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    // Starts the server and listens for incoming connections
    public void start() throws IOException {
        System.out.println("Listening for connection on port " + serverSocket.getLocalPort() + "...");
        while (true) {
            try (Socket socket = serverSocket.accept()) {
                respondWithSystemInfo(socket);
            }
        }
    }

    // Sends the system info to the connected client
    private void respondWithSystemInfo(Socket socket) throws IOException {
        System.out.println("Connection established");

        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long totalMemory = Runtime.getRuntime().totalMemory();

        String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" +
                "Operating System: " + osName + " " + osVersion + "\n" +
                "Java Version: " + javaVersion + "\n" +
                "Available Processors: " + availableProcessors + "\n" +
                "Total Memory: " + totalMemory + " bytes";

        socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
    }


    // Main method to start the server
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.start();
    }
}
