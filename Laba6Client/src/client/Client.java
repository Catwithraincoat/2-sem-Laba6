package client;

import java.io.*;
import java.net.*;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

import commands.*;
import utils.Message;

public class Client {

    //Статические переменные
    static private DatagramPacket sendPacket, receivePacket;
    static private DatagramSocket socket;
    static private SocketAddress address;
    static private int port = 59812;
    static private BufferedReader reader;
    static private byte[] sendBuffer, receiveBuffer;
    static private ByteArrayOutputStream out;
    static private ByteArrayInputStream in;
    static private String answer;
    static private Object command;
    static public CommandsKeeper listener = new CommandsKeeper( new AddCommand(), new AddIfMaxCommand(),
            new ExecuteScriptCommand(), new ExitCommand(), new InfoCommand(), new RemoveAllByUnitOfMeasure(), new RemoveByIdCommand(),
            new RemoveGreaterCommand(), new RemoveLowerCommand(), new HelpCommand(), new ShowCommand(), new UpdateIdCommand(), new PrintFieldDescendingmanufacturerCommand());;
    static String[] strCommands  = {"add", "add_if_max", "clear", "execute_script", "exit", "help", "info", "print_field_descending_manufacturer",
            "remove_all_by_unit_of_measure", "remove_by_id", "remove_greater", "remove_lower", "save", "show", "update id"};


    //Настройка подключения
    public static void connect() {
        try {
            socket = new DatagramSocket();
            socket.setSoTimeout(1000);
            address = new InetSocketAddress(InetAddress.getLocalHost(), port);
            System.out.println(InetAddress.getLocalHost());
            sendBuffer = new byte[65536];

        } catch (SocketException | UnknownHostException e) {
            System.out.println("{ошибка соединения: " + e.getMessage() + "}");
        }
    }

    //Вводим запрос серверу и отправляем его
    public static void sendRequest() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            sendBuffer = new byte[65536];
            while(true){
                System.out.println("Введите запрос: ");
                String request = reader.readLine();
                if (Arrays.asList(strCommands).contains(request)){
                    command = CommandsKeeper.execution(request);
                    break;
                }}



            if (command != null) {
                sendBuffer = serialization(command);
                sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address);
                socket.send(sendPacket);

            } else sendRequest();

        } catch (IOException e) {
            System.out.println("{ошибка при отправке запроса на сервер: " + e.getMessage() + "}");
        }
    }

    //Получаем ответ от сервера и выводим на экран
    public static void getAnswer() {
        try {
            receiveBuffer = new byte[65536];
            receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            HashMap<SocketAddress,byte[]> que = new HashMap<>();
            que.put(address, new byte[0]);
            try {

                socket.receive(receivePacket);
                while (!Objects.equals(deserialization(receiveBuffer), "true")){
                    que.put(address, joinByteArray(que.get(address),receiveBuffer));
                    socket.receive(receivePacket);}
                String answer = deserialization(que.get(address));
                System.out.println("{ОТВЕТ ПОЛУЧЕН}");
                System.out.println(answer);

            } catch (SocketTimeoutException e) {
                System.out.println("{СЕРВЕР ВРЕМЕННО НЕДОСТУПЕН}\n");
            }
        } catch (IOException e) {
            System.out.println("{ошибка при получении ответа с сервера: " + e.getMessage() + "}");
        }
    }

    //Сериализация
    public static byte[] serialization(Object command) {
        try {
            out = new ByteArrayOutputStream();
            ObjectOutputStream obj = new ObjectOutputStream(out);
            obj.writeObject(command);

        } catch (IOException e) {
            System.out.println("{ошибка при сериализации объекта: " + e.getMessage() + "}");
        }
        return out.toByteArray();
    }

    //Десериализация
    public static String deserialization(byte[] receiveBuffer) {
        try {
            in = new ByteArrayInputStream(receiveBuffer);
            ObjectInputStream obj = new ObjectInputStream(in);
            Message command = (Message) obj.readObject();
            answer = command.getStr();


        } catch (IOException | ClassNotFoundException e) {
            System.out.println("{ошибка при десериализации объекта: " + e.getMessage() + "}");
        }
        return answer;
    }
    public static byte[] joinByteArray(byte[] byte1, byte[] byte2) {

        byte[] result = new byte[byte1.length + byte2.length];

        System.arraycopy(byte1, 0, result, 0, byte1.length);
        System.arraycopy(byte2, 0, result, byte1.length, byte2.length);

        return result;

    }

}
