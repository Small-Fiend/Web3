package Server;

import Core.Branch;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl extends UnicastRemoteObject implements Server {
    public static void main(String[] args) {
        //Это сервер с параметрами
        String addressHost = "127.0.0.1";
        int hostPort = 1099;
        String hostName = "Server_Couch"; // это имя хоста

        try{
            System.setProperty(hostName, addressHost); // задаем параметры
            Server service = new ServerImpl();
            String serviceName = "DataCouch"; // это именно имя сервися
            System.out.println("Initializing: " + serviceName);
            //Заглушка
            Registry registry = LocateRegistry.createRegistry(hostPort); // здесь создаем заглущку
            //вот здесь должна быть еще одна строка, но на локальной машине работает и без нее, но посмотреть надо, там в одном из примеров будет
            registry.rebind(serviceName, service);//здесь пизаем ее в регистр и все, сервер есть и ждет коннекта к себе, идем в клиент
            System.out.println("Start: " + serviceName);
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            System.exit(2);
        }
    }

    protected ServerImpl() throws RemoteException {
    }

    @Override
    public Branch transformFunction(Branch array) {
//        listComments.checkDuplicate();
        System.out.println("File received");
        array.deleteDuplicate();
        array.listSort();
        return array;
    }

}
