common_path=/Users/gao/work/idea_workspace/blackshark/shark-common
web_path=/Users/gao/work/idea_workspace/blackshark/shark-web

cd ${web_path}
yarn build

rm -rf ${common_path}/src/main/resources/static
mv ${web_path}/dist ${common_path}/src/main/resources/static

cd ${common_path}
mvn clean package -Dmaven.test.skip=true

scp ${common_path}/target/shark-common-*.jar root@43.140.248.190:/root/
ssh root@43.140.248.190 -C "  /root/start_balckshark.sh"


#java -jar -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 shark-common/target/shark-common-1.0-SNAPSHOT.jar
