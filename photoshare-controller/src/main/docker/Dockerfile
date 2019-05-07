FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD photoshare-controller-0.0.1-SNAPSHOT.jar photoshare.jar
RUN sh -c 'touch /photoshare.jar'
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/photoshare.jar"]