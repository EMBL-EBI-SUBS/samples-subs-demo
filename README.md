# samples-subs-demo
Dead simple demo stack featuring a sample submission API and RabbitMQ messaging

## Dependencies
Requires installation of RabbitMQ: You can do this at https://www.rabbitmq.com/download.html

## Build
Build from the root of the project with `mvnw clean package`

## Run
After building you'll have 2 executable jars in `samples-subs-demo-api/target/` and `samples-subs-demo-consumer/target/`.  Run with the following set of command:

### Start RabbitMQ
```
>: rabbitmq-server
```

### Start Demo API
Open a new shell and start the API
```
>: java -jar sample-subs-demo-api/target/sample-subs-demo-api-0.0.1-SNAPSHOT.jar
```
This starts your server: check it is live at http://localhost:8080/health

### Submit a dummy sample
In a new shell, send a POST request to submit a sample
```
>: curl -i -X POST -H "Content-Type:application/json" -d '{"name":"foo"}' http://localhost:8080/samples
```
This should return a `201 CREATED` response and you should be able to see this sample from http://localhost:8080/samples

### Start the consumer application
Open a new shell and start the consumer
```
>: java -jar sample-subs-demo-consumer/target/sample-subs-demo-consumer-0.0.1-SNAPSHOT.jar
```
Your message consumer is now running as a dedicated server application, and is monitoring the message queue to be notified of new submissions

If you submit another new sample:
```
>: curl -i -X POST -H "Content-Type:application/json" -d '{"name":"bar"}' http://localhost:8080/samples
```
You should see the following console message from the consumer application:
```
Received a newly created sample: accession = 2, name = bar
```

This is an asynchronous messaging application which sends JSON serialized forms of the sample objects as messages, so the consumer can read the sample metadata.
This makes it quite resilient: for example, you can terminate the consumer, submit some new samples, than restart the consumer and any new messages in the queue will be pulled back at restart.

Feedback on this noddy implementation welcome: tburdett@ebi.ac.uk




