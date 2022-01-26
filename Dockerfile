FROM openjdk:latest
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac QuestionOne.java
RUN javac QuestionTwo.java
RUN javac QuestionThree.java
ENTRYPOINT ["java"]