**Features of Kubernetes**

- Automated Scheduling
- Self-Healing Capabilities
- Automated rollouts & rollback
- Horizontal Scaling & Load Balancing
- Offers environment consistency for development, testing, and production
- Infrastructure is loosely coupled to each component can act as a separate unit
- Provides a higher density of resource utilization
- Offers enterprise-ready features
- Application-centric management
- Auto-scalable infrastructure
- You can create predictable infrastructure

**Components of Kubernetes**
- Master Node: This is responsible for the management of Kubernetes cluster. It is the entry point for all kinds of administrative tasks. There may be more than one master node in the cluster to check for fault tolerance. Components of master node are as follows:

    - API Server: 
        - Cluster gateway. 
        - The API server acts as an entry point for all the requests coming from UI/command line.
        - Also acts as a gatekeeper for authentication.

    - Scheduler:
        - It takes the r`equest from API sever.
        - The scheduler schedules the tasks to the slave node. 
        - It stores the resource usage information for every slave node. 
        - It is responsible for distributing the workload.
        - It sends the request for kubelet and

    - control manager:
        - detects cluster state changes & make sure desired number of application replicas are always running.
        - In case of pods dies, it sends the request to scheduler to re-create the pod.

    - Etcd: 
        - store configuration detail such as what resources are available in node, any changes in the cluster state etc.
        - It also manages network rules and port forwarding activity.

- Worker/Slave nodes: Does all the heavy lifting. Run containerized applications in Pods. Components of worker node are as follows:

    - Kubelet: It gets the configuration of a Pod from the API server and ensures that the described containers are up and running.

    - kubeproxy: 
        - Acts are a router within the node.
        - Reduces the network overhead by forwarding the request to services available within the same node.

        - Docker Container: Docker container runs on each of the worker nodes, which runs the configured pods.

        - Pods: A pod is a combination of single or multiple containers that logically run together on nodes.

**Tools that are used for container monitoring are:**

- Heapster
- cAdvisor
- Prometheus
- InfluxDB
- Grafana

**Question:** Name the initial namespaces from which Kubernetes starts?

**Answer:**

- Default
- Kube – system
- Kube – public

**Question:** What is the Kubernetes controller manager?

**Answer:** The controller manager is a daemon that is used for embedding core control loops, garbage collection, and Namespace creation. It enables the running of multiple processes on the master node even though they are compiled to run as a single process.

**Question:** What are the types of controller managers?

**Answer:** The primary controller managers that can run on the master node are the endpoints controller, service accounts controller, namespace controller, node controller, token controller, and replication controller.

**Question:** What is etcd?

**Answer:** Kubernetes uses etcd as a distributed key-value store for all of its data, including metadata and configuration data, and allows nodes in Kubernetes clusters to read and write data. Although etcd was purposely built for CoreOS, it also works on a variety of operating systems (e.g., Linux, BSB, and OS X) because it is open-source. Etcd represents the state of a cluster at a specific moment in time and is a canonical hub for state management and cluster coordination of a Kubernetes cluster.

**Question:** What are the different services within Kubernetes?

**Answer:** Different types of Kubernetes services include:

- Cluster IP service
- Node Port service
- External Name Creation service and
- Load Balancer service

**Question:** What is ClusterIP?

**Answer:** The ClusterIP is the default Kubernetes service that provides a service inside a cluster (with no external access) that other apps inside your cluster can access. 

**Question:** What is NodePort? 

**Answer:** The NodePort service is the most fundamental way to get external traffic directly to your service. It opens a specific port on all Nodes and forwards any traffic sent to this port to the service.

**Question:** What is the LoadBalancer in Kubernetes? 

**Answer:** The LoadBalancer service is used to expose services to the internet. A Network load balancer, for example, creates a single IP address that forwards all traffic to your service. 

**Question:** What is the Ingress network, and how does it work?

**Answer:** An ingress is an object that allows users to access your Kubernetes services from outside the Kubernetes cluster. Users can configure the access by creating rules that define which inbound connections reach which services.

How does it work- This is an API object that provides the routing rules to manage the external users' access to the services in the Kubernetes cluster through HTTPS/ HTTP. With this, users can easily set up the rules for routing traffic without creating a bunch of load balancers or exposing each service to the nodes.

**Question:** What do you understand by Cloud controller manager?

**Answer:** You must have heard about Public, Private and hybrid clouds. With the help of cloud infrastructure technologies, you can run Kubernetes on them. In the context of Cloud Controller Manager, it is the control panel component that embeds the cloud-specific control logic. This process lets you link the cluster into the cloud provider's API and separates the elements that interact with the cloud platform from components that only interact with your cluster. 

This also enables the cloud providers to release the features at a different pace compared to the main Kubernetes project. It is structured using a plugin mechanism and allows various cloud providers to integrate their platforms with Kubernetes.

**Question:** What is Container resource monitoring?

**Answer:** This refers to the activity that collects the metrics and tracks the health of containerized applications and microservices environments. It helps to improve health and performance and also makes sure that they operate smoothly.

**Question:** What is the difference between a replica set and a replication controller?

**Answer:** A replication controller is referred to as RC in short. It is a wrapper on a pod. This provides additional functionality to the pods, which offers replicas. 

It monitors the pods and automatically restarts them if they fail. If the node fails, this controller will respawn all the pods of that node on another node. If the pods die, they won't be spawned again unless wrapped around a replica set. 

Replica Set, on the other hand, is referred to as rs in short. It is told as the next-generation replication controller. This kind of support has some selector types and supports the equality-based and the set-based selectors. 

It allows filtering by label values and keys. To match the object, they have to satisfy all the specified label constraints.

**Question:** What is a headless service?

**Answer:** A headless service is used to interface with service discovery mechanisms without being tied to a ClusterIP, therefore allowing you to directly reach pods without having to access them through a proxy. It is useful when neither load balancing nor a single Service IP is required. 

**Question:** What are federated clusters?

**Answer:** The aggregation of multiple clusters that treat them as a single logical cluster refers to cluster federation. In this, multiple clusters may be managed as a single cluster. They stay with the assistance of federated groups. Also, users can create various clusters within the data center or cloud and use the federation to control or manage them in one place. 

You can perform cluster federation by doing the following: 

Cross cluster that provides the ability to have DNS and Load Balancer with backend from the participating clusters. 

Users can sync resources across different clusters in order to deploy the same deployment set across the various clusters.

**Question:** What is Kubelet?

**Answer:** The kubelet is a service agent that controls and maintains a set of pods by watching for pod specs through the Kubernetes API server. It preserves the pod lifecycle by ensuring that a given set of containers are all running as they should. The kubelet runs on each node and enables the communication between the master and slave nodes.

**Question:** What is Kubectl?

**Answer:** Kubectl is a CLI (command-line interface) that is used to run commands against Kubernetes clusters. As such, it controls the Kubernetes cluster manager through different create and manage commands on the Kubernetes component

**Question:** Give examples of recommended security measures for Kubernetes.

**Answer:** Examples of standard Kubernetes security measures include defining resource quotas, support for auditing, restriction of etcd access, regular security updates to the environment, network segmentation, definition of strict resource policies, continuous scanning for security vulnerabilities, and using images from authorized repositories.

**Question:** What is Kube-proxy?

**Answer:** Kube-proxy is an implementation of a load balancer and network proxy used to support service abstraction with other networking operations. Kube-proxy is responsible for directing traffic to the right container based on IP and the port number of incoming requests.

OR 

Kube-proxy is an implementation of both a network proxy and a load balancer. It is used to support service abstraction used with other networking operations. It is responsible for directing traffic to the container depend on IP and the port number.

**Question:** How can you get a static IP for a Kubernetes load balancer? 

**Answer:** A static IP for the Kubernetes load balancer can be achieved by changing DNS records since the Kubernetes Master can assign a new static IP address.

**Question:** Define Stateful sets in Kubernetes

**Answer:** The stateful set is a workload API object that is used to manage the stateful application. It can also be used to manage the deployments and scaling the sets of pods. The state information and other data of stateful pods are store in the disk storage, which connects with stateful set.

**Question:** Explain Prometheus in Kubernetes

**Answer:** Prometheus is an application that is used for monitoring and alerting. It can be called out to your systems, grab real-time metrics, compress it, and stores properly in a database.

**Question:** Why use Daemon sets?

**Answer:** Daemon sets are used because:

- It enables to runs storage platforms like ceph and glusterd on each node.
- Daemon sets run the logs collection on every node such as filebeat or fluentd.
- It performs node monitoring on each and every node.

**Question:** Explain Replica set

**Answer:** A Replica set is used to keep replica pods stable. It enables us to specify the available number of identical pods. This can be considered a replacement for the replication .controller.

**Question:** List out some important Kubectl commands:

**Answer:** The important Kubectl commands are:

- kubectl annotate
- kubectl cluster-info
- kubectl attach
- kubectl apply
- kubectl config
- kubectl autoscale
- kubectl config current-context
- kubectl config set.

**Question:** Why uses Kube-apiserver?

**Answer:** Kube-apiserver is an API server of Kubernetes that is used to configure and validate API objects, which include services, controllers, etc. It provides the frontend to the cluster’s shared region using which components interact with each other.

**Question:** Explain the types of Kubernetes pods

**Answer:** There are two types of pods in Kubernetes:

- Single Container Pod: It can be created with the run command.
- Multicontainer pods: It can be created using the “create” command in Kubernetes.

**Question:** What do you mean by persistent volume?

**Answer:** A persistent volume is a storage unit that is controlled by the administrator. It is used to manage an individual pod in a cluster.

**Question:** What are Secrets in Kubernetes?

**Answer:** Secrets are sensitive information like login credentials of the user. They are objects in Kubernetes that stores sensitive information like username and password after performing encryption.

**Question:** What is Sematext Docker Agent?

**Answer:** Sematext Docker agent is a log collection agent with events and metrics. It runs as a small container in each Docker host. These agents gather metrics, events, and logs for all cluster nodes and containers.

**Question:** Define OpenShift

**Answer:** OpenShift is a public cloud application development and hosting platform developed by Red Hat. It offers automation for management so that developers can focus on writing the code.

**Question:** What are the ways to provide API-Security on Kubernetes?

**Answer:** The ways to provide API-Security on Kubernetes are:

- Using correct auth mode with API server authentication mode= Node.
- Make kubeless that protects its API via authorization-mode=Webhook.
- Ensure the kube-dashboard uses a restrictive RBAC (Role-Based Access Control) policy

**Question:** What are the types of Kubernetes Volume?

**Answer:** 
- EmptyDir
- GCE persistent disk
- Flocker
- HostPath
- NFS
- ISCSI
- rbd
- PersistentVolumeClaim
- downwardAPI

**Question:** Explain PVC?

**Answer:** The full form of PVC stands for Persistent Volume Claim. It is storage requested by Kubernetes for pods. The user does not require to know the underlying provisioning. This claim should be created in the same namespace where the pod is created.

**Question:**  What is the Kubernetes Network Policy?

**Answer:** Network Policy defines how the pods in the same namespace would communicate with each other and the network endpoint.

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**
**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**

**Question:**

**Answer:**