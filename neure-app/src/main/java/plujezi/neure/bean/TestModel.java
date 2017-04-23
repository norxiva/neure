package plujezi.neure.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class TestModel implements Serializable{

    private static final long serialVersionUID = -2158027184559622837L;
    private Integer id;
    private String name;
    private String password;

    // dubbo dose not support LocalDateTime
    private Date createTime;

}