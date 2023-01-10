package com.tzy.tedarik.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User  {
    @Id
    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
 //   private Date createdAt = new Date();
    private List<String> permissions;


}
