package br.com.jeffmonteiro.todolist.user;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_users")// Assigning a name to the my table.
public class UserModel {

    @Id // Private key in my table
    @GeneratedValue(generator = "UUID")
    private UUID id;
    
    private String username;
    private String name;
    private String password;
}
