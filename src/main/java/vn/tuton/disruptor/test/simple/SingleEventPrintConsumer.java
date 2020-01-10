package vn.tuton.disruptor.test.simple;

import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingleEventPrintConsumer implements EventConsumer {
    @Override
    public EventHandler<ValueEvent>[] getEventHandler() {
        EventHandler<ValueEvent> eventHandler = (valueEvent, sequence, endOfBatch) -> print(valueEvent, sequence);
        return new EventHandler[] {eventHandler};
    }

    void print(ValueEvent value, long sequence) {
        log.info("Sequence: {} and value: {}", sequence, value.getValue());
    }
}
