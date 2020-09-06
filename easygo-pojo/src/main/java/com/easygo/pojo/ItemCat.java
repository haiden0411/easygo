package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCat implements Serializable {
  private static final long serialVersionUID = 6544497683564230035L;
  private Integer id;
  private Integer parentId;
  private String name;
  private Integer del;
  private TypeTemplate typeTemplate;
}
