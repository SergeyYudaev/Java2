import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Socket socket;
    static final int PORT = 8189;
    static final String IP_ADRESS = "localhost";

    public static void main(String[] args) {
        try {
            socket = new Socket(IP_ADRESS, PORT);

            Thread t1 = new Thread(new Runnable() {
                public void run() {
                    try {
                        while (true) {
                            Scanner sc = new Scanner(socket.getInputStream());
                            String str = sc.nextLine();

                            if (str.equals("end")) {
                                System.out.println("Server lost");
                                break;
                            }
                            System.out.println("Server: " + str);
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
                                out.println("end");
                                System.out.println("disconnected");
                                break;
                            }

                            out.println(str);
                            System.out.println("Client: " + str);
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
        }
    }
}
