package plujezi.neure.server.api.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class Model implements Serializable{

    private static final long serialVersionUID = -4035658473399706512L;
    private String fullName;
    // dubbo does not support LocalDateTime, will throw exception of StackOverflowError
//    private LocalDateTime birthday;
    private Integer age;
}
