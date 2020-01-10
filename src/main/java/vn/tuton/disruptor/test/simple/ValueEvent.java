package vn.tuton.disruptor.test.simple;

import com.lmax.disruptor.EventFactory;
import lombok.Data;

@Data
public class ValueEvent {
    private long value;
    public final static EventFactory<ValueEvent> EVENT_FACTORY = ValueEvent::new;
}
