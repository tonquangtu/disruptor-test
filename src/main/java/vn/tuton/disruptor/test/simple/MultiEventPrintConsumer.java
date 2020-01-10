package vn.tuton.disruptor.test.simple;

import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MultiEventPrintConsumer implements EventConsumer {
    @Override
    public EventHandler<ValueEvent>[] getEventHandler() {
        final EventHandler<ValueEvent> eventHandler = (event, sequence, endOfBatch) -> print("Handler 1", event, sequence);
        final EventHandler<ValueEvent> otherEventHandler = (event, sequence, endOfBatch) -> print("Handler 2", event, sequence);
        return new EventHandler[] {eventHandler, otherEventHandler};
    }

    void print(String tag, ValueEvent valueEvent, long sequence) {
        log.info("[{}] Sequence: {} and value: {}", tag, sequence, valueEvent.getValue());

    }
}
