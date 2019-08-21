package net.messi.early.storm.processor;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;

public class AccessLogMessageProcessor implements Runnable {

    private KafkaStream kafkaStream;
    private ArrayBlockingQueue<String> queue;
    private Logger LOGGER = LoggerFactory.getLogger(AccessLogMessageProcessor.class);

    public AccessLogMessageProcessor(KafkaStream kafkaStream) {
        this.kafkaStream = kafkaStream;
    }

    public AccessLogMessageProcessor(KafkaStream kafkaStream, ArrayBlockingQueue<String> queue) {
        this.kafkaStream = kafkaStream;
        this.queue = queue;
    }

    @Override
    public void run() {
        ConsumerIterator<byte[], byte[]> it = kafkaStream.iterator();
        while (it.hasNext()) {
            String message = new String(it.next().message());
            LOGGER.info("kafka消费者接受到一条日志:Access-Log-MESSI:{}", message);
            try {
                queue.put(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
