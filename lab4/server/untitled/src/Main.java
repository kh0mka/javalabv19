import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket (Constants.Port);
        ) {
            System.out.println("Server is listening on port " + Constants.Port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                try (
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        BufferedReader in = new BufferedReader(new InputStreamReader (clientSocket.getInputStream()));
                ) {
                    String query = in.readLine();
                    System.out.println("Received search query: " + query);

                    String[] sentences = Constants.Text.split("\\.");
                    StringBuilder response = new StringBuilder();

                        for (String sentence : sentences) {
                            if (sentence.contains(query.trim ())) {
                                response.append(sentence.trim());
                                response.append ("*EOS");
                            }
                        }

                    if(response.isEmpty ()) {
                        response.append(Constants.TextNotFoundMessage);
                    }

                    out.println(response);

                }
                catch (Exception e) {
                    System.out.println("Error handling client request: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error starting server: " + e.getMessage());
        }
    }
}