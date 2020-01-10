package vn.tuton.disruptor.test.simple;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.util.concurrent.ThreadFactory;

public class DisruptorFactory {
    public Disruptor<ValueEvent> disruptor(ProducerType producerType) {
        int ringBufferSize = 16;
        ThreadFactory threadFactory = DaemonThreadFactory.INSTANCE;
        WaitStrategy waitStrategy = new BusySpinWaitStrategy();
        Disruptor<ValueEvent> disruptor = new Disruptor<>(
                ValueEvent.EVENT_FACTORY,
                ringBufferSize,
                threadFactory,
                producerType,
                waitStrategy);
        return disruptor;
    }
}
