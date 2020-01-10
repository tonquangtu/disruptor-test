package vn.tuton.disruptor.test.simple;

import com.lmax.disruptor.RingBuffer;

public interface EventProducer {
    void produce(RingBuffer<ValueEvent> ringBuffer, int count);
}
