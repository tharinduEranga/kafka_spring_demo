# How to run

1. Start the ZooKeeper service
$ bin/zookeeper-server-start.sh config/zookeeper.properties

2. Start the Kafka broker service
$ bin/kafka-server-start.sh config/server.properties

3. Start the application

4. Run the below curl
curl -X POST -F 'message=test' http://localhost:9000/kafka/publish
