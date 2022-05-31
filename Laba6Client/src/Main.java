import client.Client;

public class Main {
    public static void main(String[] args) {
        Client.connect();
        while (true) {
            Client.sendRequest();
            Client.getAnswer();
        }
    }

}
