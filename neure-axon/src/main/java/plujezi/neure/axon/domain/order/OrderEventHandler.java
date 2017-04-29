package plujezi.neure.axon.domain.order;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import plujezi.neure.axon.domain.order.command.ExecuteOrderCommand;
import plujezi.neure.axon.domain.order.event.OrderCreatedEvent;
import plujezi.neure.axon.domain.order.event.OrderExecutedEvent;

@Component
public class OrderEventHandler {

    private OrderRepository orderRepository;

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    public OrderEventHandler(OrderRepository orderRepository
//            , CommandGateway commandGateway
    ){
        this.orderRepository = orderRepository;
//        this.commandGateway = commandGateway;
    }

    @EventHandler
    public void on(OrderCreatedEvent event){
        Order order = orderRepository.save(Order.builder()
                .id(event.getId())
                .orderNo(event.getOrderNo())
                .amount(event.getAmount())
                .status("CREATED").build());
        commandGateway.send(new ExecuteOrderCommand(order.getId(),
                order.getOrderNo(), order.getAmount(), order.getStatus()));
    }

    @EventHandler
    public void on(OrderExecutedEvent event){
        orderRepository.save(Order.builder()
                .id(event.getId())
                .orderNo(event.getOrderNo())
                .amount(event.getAmount())
                .status("EXECUTED").build());

    }



}
