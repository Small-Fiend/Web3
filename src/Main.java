import Core.Branch;
import Core.Couch;
import Core.DataBase;
import Core.User;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String arg[]) throws Exception {
//        SimpleDateFormat test = new SimpleDateFormat("dd-MM-yyyy");
//        try {
//            Date d = test.parse("27-10-1999");
//            System.out.println(d);
//            System.out.println(new SimpleDateFormat().format(d));
//            System.out.println(test.format(test.parse("27-10-1999")));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        SimpleDateFormat = SimpleDateFormat.parse("1999-10-27", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        System.out.println(SimpleDateFormat.toString());

        String filePathRead = "C:\\Users\\1\\Desktop\\Web3\\JsonSaveList.json";
        String filePathWrite = "C:\\Users\\1\\Desktop\\Web3\\SaveList.json";
        long number = 1231212312l;
        Couch timeCouch = new Couch();
        timeCouch.setSpecialization("asasda");
        timeCouch.setPhoneNumber(number);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            timeCouch.setBirthday(new Timestamp(formatter.parse("2020-05-19").getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timeCouch.setinitials("Man");

        DataBase db = new DataBase();
        db.CreateTable();
        Branch branch1 = new Branch();
        branch1.setId(6);
        branch1.setNameBranch("11");
        branch1.readFile(filePathRead);
        branch1.writeFile(filePathWrite);
        DataBase.getArrayCouch(6);
        DataBase.addBranch(branch1);
        List<Couch> timeList = new ArrayList<Couch>();
        timeList.add(timeCouch);
        Branch branch = new Branch();
        branch.setId(4);
        branch.setNameBranch("456");
        branch.setArrayCouches(timeList);
        DataBase.getArrayCouch(4);
        DataBase.addBranch(branch);
        System.out.println("Databases created");
        User mix = new User(6,"asd", "78");
        DataBase.checkUser(mix);//Проверка наличия в базе пользователя с заданными логином
        System.out.println("This user exists");
        DataBase.getBranch(2);//Получение списка тренеров по идентификатору пользователя
        System.out.println("List of coaches by user ID: "+DataBase.getBranch(2).toString());
        DataBase.getArrayCouch(6);//Получения списка тренеров по идентификатору филиала
        System.out.println("List of coaches by branch ID: "+DataBase.getArrayCouch(6).toString());
        DataBase.getCouch("asd");//Получение тренера по его инициалам
        System.out.println(DataBase.getCouch("asd").toString());
        DataBase.getCouch("lis");//Получение тренера по его инициалам
        System.out.println(DataBase.getCouch("lis").toString());
        DataBase.getPassword(4);//Получение пароля пользователя по его идентификатору
        System.out.println("The user's password by its ID: "+DataBase.getPassword(4).toString());
        DataBase.getArrayUser();//Получение списка пользователей
        System.out.println("List of users: "+DataBase.getArrayUser().toString());

      DataBase.deleteBranch(branch);

    }
}