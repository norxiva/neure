package plujezi.neure.axon.domain.order;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;


@Getter
@Setter
@Builder
public class Order {

    @Id
    private String id;

    private String orderNo;

    private BigDecimal amount;

    private String status;
}
