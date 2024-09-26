Benefits
=========
- Microservices are self-contained, independent deployment module.
- The cost of scaling is comparatively less than the monolithic architecture.
- Microservices are independently manageable services. It can enable more and more services as the need arises. It minimizes the impact on existing service.
- It is possible to change or upgrade each service individually rather than upgrading in the entire application.
- Microservices allows us to develop an application which is organic (an application which latterly upgrades by adding more functions or modules) in nature.
- It enables event streaming technology to enable easy integration in comparison to heavyweight interposes communication.
- Microservices follows the single responsibility principle.
- The demanding service can be deployed on multiple servers to enhance performance.
- Less dependency and easy to test.
- Dynamic scaling.
- Faster release cycle.

Drawbacks
==========
- Microservices has all the associated complexities of the distributed system.
- There is a higher chance of failure during communication between different services.
- Difficult to manage a large number of services.
- The developer needs to solve the problem, such as network latency and load balancing.
- Complex testing over a distributed environment.

Challanges
==========
1. Data Synchronization (Consistency) — Event sourcing architecture can address this issue using the async messaging platform. The SAGA design pattern can address this challenge.

2. Security — An API Gateway can solve these challenges. There are many open source and enterprise APIs are available like Spring Cloud Gateway, Apigee, WSO2, Kong, Okta (2-step authentication) and public cloud offering from AWS, GCP and Azure etc. Custom solutions can also be developed for API security using JWT token, Spring Security, and Netflix OSS Zuul2.

3.  Services Communication — There are the different way to communicate microservices –
a. Point to point using API Gateway
b. Messaging event driven platform using Kafka and RabbitMQ
c. Service Mesh

4. Service Discovery — This will be addressed by open source Istio Service Mesh, API Gateway, Netflix Eureka APIs. It can also be done using Netflix Eureka at the code level. However, doing it in with the orchestration layer will be better and can be managed by these tools rather doing and maintaining it through code and configuration.

5. Data Staleness — The database should be always updated to give recent data. The API will fetch data from the recent and updated database. A timestamp entry can also be added with each record in the database to check and verify the recent data. Caching can be used and customized with an acceptable eviction policy based on business requirements.

6. Distributed Logging, Cyclic Dependencies of Services and Debugging — There are multiple solutions for this. Externalized logging can be used by pushing log messages to an async messaging platform like Kafka, Google PubSub, ELK etc. Also, a good number of APM tools available like WaveFront, DataDog, App Dynamics, AWS CloudWatch etc.

    It’s difficult to identify issues between microservices when services are dependent on each other and they have a cyclic dependency. Correlation ID can be passed by the client in the header to REST APIs to track all the relevant logs across all the pods/Docker containers on all clusters.

7. Testing — This issue can be addressed with unit and integration testing by mocking microservices individually or integrated/dependent APIs which are not available for testing using WireMock, BDD, Cucumber, integration testing.

8. Monitoring & Performance — Monitoring can be done using open-source tools like Prometheus with Grafana APIs by creating gauges and matrices, GCP StackDriver, Kubernetes, Influx DB, combined with Grafana, Dynatrace, Amazon CloudWatch, VisualVM, jProfiler, YourToolKit, Graphite etc.

    Tracing can be done by the latest Open tracing project or Uber’s open source Jaeger. It will trace all microservices communication and show request/response, errors on its dashboard. Open tracing , Jaeger are good APIs to trace API logs Many enterprise offerings are also available like Tanzu TSM etc.

9. DevOps Support — Microservices deployment and support-related challenges can be addressed using state-of-the-art CI/CD DevOps tools like Jenkin, Concourse (supports Yaml), Spinnaker is good for multi-cloud deployment. PAAS K8 based solutions TKG, OpenShift.

10. Fault Tolerance — Istio Service Mesh or Spring Hystrix can be used to break the circuit if there is no response from the dependent microservices for the given SLA/ETA and provide a mechanism to re-try and graceful shutdown services without any data loss.

Architecture
============


Design-Patterns
===============
There are various design-patterns available to build microservice architecture.

![Design-Patterns](https://github.com/nitinjmv/my-notes/blob/main/resources/microservices-design-pattern.JPG)


