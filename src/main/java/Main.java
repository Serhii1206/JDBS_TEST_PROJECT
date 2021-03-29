import database.Database;
import entity.Clients;
import lombok.Builder;
import service.ClietService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Database.getConnection();
//        ClietService clietService = new ClietService();

        ClietService clietService = new ClietService();

        System.out.println(clietService.getAll());
//        System.out.println(clietService.finePhone(380958089094l));
////
//        System.out.println(ClietService.findName("Serj"));
//        System.out.println(ClietService.findName("Dina"));
//        System.out.println(ClietService.findName("Den"));
////
//        System.out.println(ClietService.finePhone(380958089095L));
//        System.out.println(clietService.getAll().isEmpty());
//
//        System.out.println(clietService.getAll().size());
        Clients client = new Clients();
//        client.setName("Bag");
//        client.setEmail("Bag@mail.com.ua");
//        client.setAge(10);
//
//        client.setPhone(328965274521L);
//        client.setId(201);
//        ClietService.save(client);

//        client.setId(3);
//        client.setName("Jef");
//        client.setEmail("Jef@email.com");
//        client.setPhone(380884767644L);
//        client.setAbout("Hello");
//        client.setAge(39);
//        ClietService.save(client);
////
        client.setId(48);
        ClietService.delete(client);
        //      System.out.println(clietService.getAll());
//        client.setName("Dina");
//        ClietService.deleteName(client);
//        client.setId(6);
//        client.setEmail("Dinka@mail.ua");
//        ClietService.upDate(client);
    }
}
