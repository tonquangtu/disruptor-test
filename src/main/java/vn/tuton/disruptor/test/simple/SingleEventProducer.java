package vn.tuton.disruptor.test.simple;

import com.lmax.disruptor.RingBuffer;

public class SingleEventProducer implements EventProducer {
    @Override
    public void produce(RingBuffer<ValueEvent> ringBuffer, int count) {
        final Runnable producer = () -> startProduce(ringBuffer, count);
        new Thread(producer).start();
    }

    private void startProduce(final RingBuffer<ValueEvent> ringBuffer, final int count) {
        for (int i = 0; i < count; i++) {
            final long seq = ringBuffer.next();
            final ValueEvent valueEvent = ringBuffer.get(seq);
            valueEvent.setValue(i);
            ringBuffer.publish(seq);
        }
    }
}
