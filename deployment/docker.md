**lifecycle of a Docker Container**

- Create a container
- Run the container
- Pause the container(optional)
- Un-pause the container(optional)
- Start the container
- Stop the container
- Restart the container
- Kill the container
- Destroy the container

**Create Image from running container**
```
docker commit <conatainer id> <username/imagename>
```

17. Differentiate between COPY and ADD commands that are used in a Dockerfile?
Both the commands have similar functionality, but COPY is more preferred because of its higher transparency level than that of ADD.
COPY provides just the basic support of copying local files into the container whereas ADD provides additional features like remote URL and tar extraction support.

18. Can a container restart by itself?
Yes, it is possible only while using certain docker-defined policies while using the docker run command. Following are the available policies:

1. Off: In this, the container won’t be restarted in case it's stopped or it fails.
2. On-failure: Here, the container restarts by itself only when it experiences failures not associated with the user.
3. Unless-stopped: Using this policy, ensures that a container can restart only when the command is executed to stop it by the user.
4. Always: Irrespective of the failure or stopping, the container always gets restarted in this type of policy.

These policies can be used as:
docker run -dit — restart [restart-policy-value] [container_name]
19. Can you tell the differences between a docker Image and Layer?
Image: This is built up from a series of read-only layers of instructions. An image corresponds to the docker container and is used for speedy operation due to the caching mechanism of each step.

Layer: Each layer corresponds to an instruction of the image’s Dockerfile. In simple words, the layer is also an image but it is the image of the instructions run.

Consider the example Dockerfile below.
FROM ubuntu:18.04 COPY . /myapp RUN make /myapp CMD python /myapp/app.py Importantly, each layer is only a set of differences from the layer before it. 

- The result of building this docker file is an image. Whereas the instructions present in this file add the layers to the image. The layers can be thought of as intermediate images. In the example above, there are 4 instructions, hence 4 layers are added to the resultant image.

20. What is the purpose of the volume parameter in a docker run command?
The syntax of docker run when using the volumes is: docker run -v host_path:docker_path <container_name>
The volume parameter is used for syncing a directory of a container with any of the host directories. Consider the below command as an example: docker run -v /data/app:usr/src/app myapp
The above command mounts the directory  /data/app in the host to the usr/src/app directory. We can sync the container with the data files from the host without having the need to restart it.
This also ensures data security in cases of container deletion. This ensures that even if the container is deleted, the data of the container exists in the volume mapped host location making it the easiest way to store the container data.
21. Where are docker volumes stored in docker?
Volumes are created and managed by Docker and cannot be accessed by non-docker entities. They are stored in Docker host filesystem at /var/lib/docker/volumes/

22. What does the docker info command do?
The command gets detailed information about Docker installed on the host system. The information can be like what is the number of containers or images and in what state they are running and hardware specifications like total memory allocated, speed of the processor, kernel version, etc.

List the most commonly used instructions in Dockerfile?
FROM: This is used to set the base image for upcoming instructions. A docker file is considered to be valid if it starts with the FROM instruction.
LABEL: This is used for the image organization based on projects, modules, or licensing. It also helps in automation as we specify a key-value pair while defining a label that can be later accessed and handled programmatically.
RUN: This command is used to execute instructions following it on the top of the current image in a new layer. Note that with each RUN command execution, we add layers on top of the image and then use that in subsequent steps.
CMD: This command is used to provide default values of an executing container. In cases of multiple CMD commands the last instruction would be considered.

Can you differentiate between Daemon Logging and Container Logging?
In docker, logging is supported at 2 levels and they are logging at the Daemon level or logging at the Container level.
Daemon Level: This kind of logging has four levels- Debug, Info, Error, and Fatal.
- Debug has all the data that happened during the execution of the daemon process.
- Info carries all the information along with the error information during the execution of the daemon process.
- Errors have those errors that occurred during the execution of the daemon process.
- Fatal has the fatal errors that occurred during the execution.
Container Level:
- Container level logging can be done using the command: sudo docker run –it <container_name> /bin/bash
- In order to check for the container level logs, we can run the command: sudo docker logs <container_id>


Can you tell the difference between CMD and ENTRYPOINT?
CMD command provides executable defaults for an executing container. In case the executable has to be omitted then the usage of ENTRYPOINT instruction along with the JSON array format has to be incorporated.
ENTRYPOINT specifies that the instruction within it will always be run when the container starts. 
This command provides an option to configure the parameters and the executables. If the DockerFile does not have this command, then it would still get inherited from the base image mentioned in the FROM instruction.
- The most commonly used ENTRYPOINT is /bin/sh or /bin/bash for most of the base images.
As part of good practices, every DockerFile should have at least one of these two commands