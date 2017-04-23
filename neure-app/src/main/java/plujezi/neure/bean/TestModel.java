package plujezi.neure.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.ws.rs.GET;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
public class TestModel implements Serializable{

    private static final long serialVersionUID = -2158027184559622837L;
    private Integer id;
    private String name;
    private String password;
    private Date createTime;

}