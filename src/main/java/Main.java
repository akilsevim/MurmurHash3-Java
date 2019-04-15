public class Main {

    public static void main(String[] args) {
        ServerClass server = new ServerClass();
        try {
            server.startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
