package Client;

import Core.Branch;
import Server.Server;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) {
        //вот два пути для чтения и записи
        String filePathRead = "C:\\Users\\1\\Desktop\\Web3\\JsonSaveList.json";
        String filePathWrite = "C:\\Users\\1\\Desktop\\Web3\\SaveList.json";

        //те же параметры, что и у сервера, чтобы мы могли подсоеденится
        String hostAddress = "127.0.0.1";
        int hostPort = 1099;
        String hostName = "Server_Comments";
        String hostPath = "rmi://localhost/DataCouch"; // путь до него

        try{

            System.setProperty(hostName, hostAddress); // задаем параметры

            Server serv = (Server) Naming.lookup(hostPath); // создаем связь с сервером

            Branch testElement = new Branch();// создание своих классов и считывание данных из json
            testElement.readFile(filePathRead);

            System.out.println("File read. Sending to server.");
            testElement = serv.transformFunction(testElement); // удаленно вызываем метод и сразу же приравниваем его, после того как он вернется

            //Проверка на ошибки: если да - записываем ошибки в файл, если нет - пишем данные.
            if (testElement.isCheckError()) {
                System.out.println("!!Error!!\nEnd of the program!!");
                try (Writer fileSave = new FileWriter(filePathWrite)) {
                    fileSave.write(testElement.getRowError());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("File received. Write on your device.");
                testElement.writeFile(filePathWrite);
            }

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            System.err.println("NotBoundException : " +
                    e.getMessage());
        }
    }
}
