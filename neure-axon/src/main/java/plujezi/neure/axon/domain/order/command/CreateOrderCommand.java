package plujezi.neure.axon.domain.order.command;

import lombok.Value;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
public class CreateOrderCommand {

    private String id;

    @NotNull
    private String orderNo;

    @NotNull
    private BigDecimal amount;

    private String status;
}
