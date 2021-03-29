package entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Clients {
    private int id;
    private String name;
    private String email;
    private long phone;
    private String about;
    private int age;
}
