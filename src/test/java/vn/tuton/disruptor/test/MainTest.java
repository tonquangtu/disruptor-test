package vn.tuton.disruptor.test;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.junit.jupiter.api.Test;
import vn.tuton.disruptor.test.simple.DelayMultiEventProducer;
import vn.tuton.disruptor.test.simple.DisruptorFactory;
import vn.tuton.disruptor.test.simple.EventConsumer;
import vn.tuton.disruptor.test.simple.EventProducer;
import vn.tuton.disruptor.test.simple.MultiEventPrintConsumer;
import vn.tuton.disruptor.test.simple.SingleEventPrintConsumer;
import vn.tuton.disruptor.test.simple.SingleEventProducer;
import vn.tuton.disruptor.test.simple.ValueEvent;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testSingleProducerSingleConsumer() throws InterruptedException {
        final EventConsumer eventConsumer = new SingleEventPrintConsumer();
        final EventProducer eventProducer = new SingleEventProducer();
        DisruptorFactory factory = new DisruptorFactory();
        Disruptor<ValueEvent> disruptor = factory.disruptor(ProducerType.SINGLE);
        disruptor.handleEventsWith(eventConsumer.getEventHandler());

        final RingBuffer<ValueEvent> ringBuffer = disruptor.start();

        eventProducer.produce(ringBuffer, 32);

        sleep(2000);

        disruptor.halt();
        disruptor.shutdown();
    }

    @Test
    public void testSingleProducerAndMultiConsumer() throws InterruptedException {
        final EventConsumer eventConsumer = new MultiEventPrintConsumer();
        final EventProducer eventProducer = new SingleEventProducer();
        DisruptorFactory factory = new DisruptorFactory();
        Disruptor<ValueEvent> disruptor = factory.disruptor(ProducerType.SINGLE);
        disruptor.handleEventsWith(eventConsumer.getEventHandler());

        final RingBuffer<ValueEvent> ringBuffer = disruptor.start();

        eventProducer.produce(ringBuffer, 32);

        sleep(3000);

        disruptor.halt();
        disruptor.shutdown();
    }

    @Test
    public void testMultiProducerAndMultiConsumer() throws InterruptedException {
        final EventConsumer eventConsumer = new MultiEventPrintConsumer();
        final EventProducer eventProducer = new DelayMultiEventProducer();
        DisruptorFactory factory = new DisruptorFactory();
        Disruptor<ValueEvent> disruptor = factory.disruptor(ProducerType.MULTI);
        disruptor.handleEventsWith(eventConsumer.getEventHandler());

        final RingBuffer<ValueEvent> ringBuffer = disruptor.start();

        int count = 32;
        eventProducer.produce(ringBuffer, count);

        sleep((count + 3) * 1000);

        disruptor.halt();
        disruptor.shutdown();
    }

    void sleep(long time) throws InterruptedException {
        Thread.sleep(time);
    }
}