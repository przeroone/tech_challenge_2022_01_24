FROM openjdk:17-jdk as build
COPY . /myapp
WORKDIR /myapp
RUN javac QuestionOne.java
RUN javac QuestionTwo.java
RUN javac QuestionThree.java

FROM openjdk:17-jdk
WORKDIR /myapp
COPY --from=build /myapp/*.class .
ENTRYPOINT ["java"]