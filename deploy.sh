#请设置一个端口号
port=8555

containerName=photoshare-web:${port}
#跟pom设置的镜像名称一样
imageName=photoshare-web/photoshare-controller

echo -e "拉取代码";
git pull

echo -e "打包";
mvn clean install package -Dmaven.test.skip

echo -e "停止容器: ${containerName}";
docker stop $containerName;

echo -e "删除容器: ${containerName}";
docker rm $containerName;

echo -e "删除镜像: ${imageName}";
docker rmi $imageName;

echo -e "构建镜像";
cd photoshare-controller
mvn package docker:build -Dmaven.test.skip

echo -e "镜像: ${imageName} 制作完成";

echo -e "启动镜像: ${imageName}";

docker run -d --name $containerName -p ${port}:8555 ${imageName}

echo -e "-------------Docker镜像[ ${imageName} ]启动完成-----------------\n\n";
echo -e "正在为您打开 Jave Web 应用日志...\n\n";
echo -e "---------------------------------------------------";

sleep 2;

docker logs -f ${containerName};