package plujezi.neure.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class TestModel implements Serializable{

    private static final long serialVersionUID = -2158027184559622837L;
    private Integer id;

    @NotNull
    private String name;
    @NotNull
    private String password;

    // dubbo dose not support LocalDateTime
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone="GMT+8")
    private Date createTime;

    private Integer pageNum;
    private Integer pageSize;

}