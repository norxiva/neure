package plujezi.neure.axon.domain.order.event;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class OrderExecutedEvent {
    private String id;

    private String orderNo;

    private BigDecimal amount;

    private String status;
}
