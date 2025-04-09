FROM alpine/java:21-jdk

WORKDIR /app

COPY . .

RUN javac HelloWorld.java

ENTRYPOINT [ "java", "HelloWorld" ]

