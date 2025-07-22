@Configuration
public class RabbitMQConfiguration {

    // === Exchange and Routing Key Constants ===
    private static final String MAIN_EXCHANGE = "exchange";
    private static final String DLX_EXCHANGE = "dlx";
    private static final String ORPHAN_EXCHANGE = "orphan";

    private static final String ROUTING_KEY = "applicant-data-retention";

    private static final String WORKING_QUEUE = "data-retention-queue";
    private static final String DLQ = "data-retention-dlq";
    private static final String PARKING_LOT_QUEUE = "data-retention-parking-lot";
    private static final String ORPHAN_QUEUE = "orphan";

    // === Exchanges ===
    @Bean
    public DirectExchange mainExchange() {
        return ExchangeBuilder.directExchange(MAIN_EXCHANGE)
                .durable(true)
                .withArgument("alternate-exchange", ORPHAN_EXCHANGE)
                .build();
    }

    @Bean
    public DirectExchange dlxExchange() {
        return ExchangeBuilder.directExchange(DLX_EXCHANGE)
                .durable(true)
                .build();
    }

    @Bean
    public FanoutExchange orphanExchange() {
        return ExchangeBuilder.fanoutExchange(ORPHAN_EXCHANGE)
                .durable(true)
                .build();
    }

    // === Queues ===
    @Bean
    public Queue workingQueue() {
        return QueueBuilder.durable(WORKING_QUEUE)
                .withArgument("x-dead-letter-exchange", DLX_EXCHANGE)
                .withArgument("x-dead-letter-routing-key", ROUTING_KEY)
                .build();
    }

    @Bean
    public Queue dlq() {
        return QueueBuilder.durable(DLQ).build();
    }

    @Bean
    public Queue parkingLotQueue() {
        return QueueBuilder.durable(PARKING_LOT_QUEUE).build();
    }

    @Bean
    public Queue orphanQueue() {
        return QueueBuilder.durable(ORPHAN_QUEUE).build();
    }

    // === Bindings ===

    @Bean
    public Binding bindWorkingQueue() {
        return BindingBuilder.bind(workingQueue())
                .to(mainExchange())
                .with(ROUTING_KEY);
    }

    @Bean
    public Binding bindDLQ() {
        return BindingBuilder.bind(dlq())
                .to(dlxExchange())
                .with(ROUTING_KEY);
    }

    @Bean
    public Binding bindOrphanQueue() {
        return BindingBuilder.bind(orphanQueue())
                .to(orphanExchange());
    }

    // Parking-lot queue intentionally has no binding — messages are routed there manually
}
