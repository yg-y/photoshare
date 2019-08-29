# 基于Java8镜像
FROM java:8

# 将本地文件夹挂在到当前容器
VOLUME /tmp

# 复制文件到容器
ADD photoshare-controller-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
