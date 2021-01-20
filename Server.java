import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    static ServerSocket server;
    static Socket socket;
    static final int PORT = 8189;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");
            socket = server.accept();
            System.out.println("Client connected");

            Thread t1 = new Thread(new Runnable() {
                public void run() {
                    try {
                        while (true) {
                            Scanner sc = new Scanner(socket.getInputStream());
                            String str = sc.nextLine();

                            if (str.equals("end"))
                                break;

                            System.out.println("Client: " + str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread t2 = new Thread(new Runnable() {
                public void run() {
                    try {
                        while (true) {
                            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                            Scanner sc = new Scanner(System.in);
                            String str = sc.nextLine();

                            if (str.equals("end")) {
                                out.println("lost");
                                System.out.println("disconnected");
                                break;
                            }

                            out.println(str);
                            System.out.println("Server: " + str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
