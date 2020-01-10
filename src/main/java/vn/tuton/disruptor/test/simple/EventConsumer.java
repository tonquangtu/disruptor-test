package vn.tuton.disruptor.test.simple;

import com.lmax.disruptor.EventHandler;

public interface EventConsumer {
    EventHandler<ValueEvent>[] getEventHandler();
}
