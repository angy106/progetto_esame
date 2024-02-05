FROM ubuntu:latest

RUN apt-get update
RUN apt-get install -y maven
RUN apt-get install -y git

RUN apt-get clean \
    && rm -rf /var/lib/apt/lists/

RUN git clone https://github.com/angy106/progetto_esame.git

WORKDIR /progetto_esame

RUN mvn package

CMD [ "java", "-jar", "target/projectMcD-1.0.0.jar" ]