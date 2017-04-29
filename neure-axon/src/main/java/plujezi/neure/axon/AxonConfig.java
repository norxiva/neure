package plujezi.neure.axon;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.annotation.AggregateAnnotationCommandHandler;
import org.axonframework.commandhandling.annotation.AnnotationCommandHandlerBeanPostProcessor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.CommandGatewayFactoryBean;
import org.axonframework.commandhandling.interceptors.BeanValidationInterceptor;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventhandling.annotation.AnnotationEventListenerBeanPostProcessor;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.fs.FileSystemEventStore;
import org.axonframework.eventstore.fs.SimpleEventFileResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import plujezi.neure.axon.domain.order.Order;
import plujezi.neure.axon.domain.order.OrderAggregate;

import java.io.File;
import java.util.Arrays;

@Configuration
public class AxonConfig {
    @Bean
    public AnnotationEventListenerBeanPostProcessor annotationEventListenerBeanPostProcessor() {
        AnnotationEventListenerBeanPostProcessor processor = new AnnotationEventListenerBeanPostProcessor();
        processor.setEventBus(eventBus());
        return processor;
    }

    @Bean
    public AnnotationCommandHandlerBeanPostProcessor annotationCommandHandlerBeanPostProcessor() {
        AnnotationCommandHandlerBeanPostProcessor processor = new AnnotationCommandHandlerBeanPostProcessor();
        processor.setCommandBus(commandBus());
        return processor;
    }

    @Bean
    public CommandBus commandBus() {
        SimpleCommandBus commandBus = new SimpleCommandBus();
        commandBus.setHandlerInterceptors(Arrays.asList(new BeanValidationInterceptor()));
//		commandBus.setTransactionManager(new SpringTransactionManager(transactionManager));
        return commandBus;
    }

    @Bean
    public EventBus eventBus() {
        return new SimpleEventBus();
    }

    @Bean
    public CommandGatewayFactoryBean<CommandGateway> commandGatewayFactoryBean() {
        CommandGatewayFactoryBean<CommandGateway> factory = new CommandGatewayFactoryBean<CommandGateway>();
        factory.setCommandBus(commandBus());
        return factory;
    }

    @Bean
    public CommandGateway commandGateway() throws Exception {
        CommandGatewayFactoryBean<CommandGateway> commandGatewayFactoryBean = commandGatewayFactoryBean();
        return commandGatewayFactoryBean.getObject();
    }

//	@Bean
//	public EntityManagerProvider entityManagerProvider() {
//		return new ContainerManagedEntityManagerProvider();
//	}

    @Bean
    public EventSourcingRepository<OrderAggregate> taskRepository() {
        FileSystemEventStore eventStore = new FileSystemEventStore(new SimpleEventFileResolver(new File("data/evenstore")));
        EventSourcingRepository<OrderAggregate> repository = new EventSourcingRepository<OrderAggregate>(OrderAggregate.class, eventStore);
        repository.setEventBus(eventBus());
        return repository;
    }

    @Bean
    public AggregateAnnotationCommandHandler<OrderAggregate> taskCommandHandler() {
        AggregateAnnotationCommandHandler<OrderAggregate> commandHandler = AggregateAnnotationCommandHandler
                .subscribe(OrderAggregate.class, taskRepository(), commandBus());
        return commandHandler;
    }


}
