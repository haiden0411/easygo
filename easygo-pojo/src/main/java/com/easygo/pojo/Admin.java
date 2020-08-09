package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin implements Serializable {
    private static final long serialVersionUID = -4661478899811906793L;
    private Integer id;
    private String username;
    private String password;
    private String status;
    private String photo;
    private Integer del;
}
