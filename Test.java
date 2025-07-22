@Configuration
public class RabbitMQConfig {

    // === Main Exchange (Working Exchange) ===
    @Bean
    public DirectExchange mainExchange() {
        return ExchangeBuilder.directExchange("exchange")
                .durable(true)
                .withArgument("alternate-exchange", "orphan") // Optional fallback
                .build();
    }

    // === DLX Exchange ===
    @Bean
    public DirectExchange dlxExchange() {
        return ExchangeBuilder.directExchange("dlx").durable(true).build();
    }

    // === Orphan Exchange ===
    @Bean
    public FanoutExchange orphanExchange() {
        return ExchangeBuilder.fanoutExchange("orphan").durable(true).build();
    }

    // === Working Queues with DLX configured ===
    @Bean
    public Queue dataRetentionQueue() {
        return QueueBuilder.durable("data-retention-queue")
                .withArgument("x-dead-letter-exchange", "dlx")
                .withArgument("x-dead-letter-routing-key", "applicant-data-retention")
                .build();
    }

    @Bean
    public Queue reportingInfoQueue() {
        return QueueBuilder.durable("reporting-info-queue")
                .withArgument("x-dead-letter-exchange", "dlx")
                .withArgument("x-dead-letter-routing-key", "applicant-reporting-info")
                .build();
    }

    // === DLQs ===
    @Bean
    public Queue dataRetentionDLQ() {
        return QueueBuilder.durable("data-retention-dlq").build();
    }

    @Bean
    public Queue reportingInfoDLQ() {
        return QueueBuilder.durable("reporting-info-dlq").build();
    }

    // === Orphan Queue ===
    @Bean
    public Queue orphanQueue() {
        return QueueBuilder.durable("orphan").build();
    }

    // === Bindings: Main Exchange to Working Queues ===
    @Bean
    public Binding bindDataRetention() {
        return BindingBuilder
                .bind(dataRetentionQueue())
                .to(mainExchange())
                .with("applicant-data-retention");
    }

    @Bean
    public Binding bindReportingInfo() {
        return BindingBuilder
                .bind(reportingInfoQueue())
                .to(mainExchange())
                .with("applicant-reporting-info");
    }

    // === Bindings: DLX to DLQs ===
    @Bean
    public Binding bindDataRetentionDLQ() {
        return BindingBuilder
                .bind(dataRetentionDLQ())
                .to(dlxExchange())
                .with("applicant-data-retention");
    }

    @Bean
    public Binding bindReportingInfoDLQ() {
        return BindingBuilder
                .bind(reportingInfoDLQ())
                .to(dlxExchange())
                .with("applicant-reporting-info");
    }

    // === Binding: Orphan Exchange to Orphan Queue ===
    @Bean
    public Binding bindOrphan() {
        return BindingBuilder.bind(orphanQueue()).to(orphanExchange());
    }
}
