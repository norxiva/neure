package plujezi.neure.axon.domain.order;

import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import plujezi.neure.axon.domain.order.command.CreateOrderCommand;
import plujezi.neure.axon.domain.order.command.ExecuteOrderCommand;
import plujezi.neure.axon.domain.order.event.OrderCreatedEvent;
import plujezi.neure.axon.domain.order.event.OrderExecutedEvent;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
public class OrderAggregate extends AbstractAnnotatedAggregateRoot<String> {

    private static final long serialVersionUID = -4549206941550358693L;

    @AggregateIdentifier
    private String id;

    @NotNull
    private boolean executed;

    @CommandHandler
    public OrderAggregate(CreateOrderCommand command){
        apply(new OrderCreatedEvent(command.getId(), command.getOrderNo(), command.getAmount(), command.getStatus()));
    }

    @CommandHandler
    public void on(ExecuteOrderCommand command){
        apply(new OrderExecutedEvent(command.getId(), command.getOrderNo(), command.getAmount(), command.getStatus()));
    }

    @EventHandler
    public void on(OrderCreatedEvent event){
        this.id = event.getId();
    }

    public void on(OrderExecutedEvent event){
        this.executed = true;
    }

}
