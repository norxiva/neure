package plujezi.neure.bean;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TestModel {
    private Integer id;
    private String name;
    private String password;
    private LocalDateTime createTime;
}