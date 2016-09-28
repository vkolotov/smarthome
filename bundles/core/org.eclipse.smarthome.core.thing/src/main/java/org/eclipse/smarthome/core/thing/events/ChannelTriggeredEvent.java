/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.core.thing.events;

import org.eclipse.smarthome.core.events.AbstractEvent;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.types.Type;

/**
 * {@link ChannelTriggeredEvent}s can be used to deliver triggers through the Eclipse SmartHome event bus.
 * Trigger events must be created with the {@link ThingEventFactory}.
 */
public class ChannelTriggeredEvent extends AbstractEvent {

    /**
     * The thing trigger event type.
     */
    public final static String TYPE = ChannelTriggeredEvent.class.getSimpleName();

    /**
     * The channel which triggered the event.
     */
    private final ChannelUID channel;

    /**
     * The event.
     */
    private final String event;

    /**
     * Constructs a new thing trigger event.
     *
     * @param topic the topic. The topic includes the thing UID, see
     *            {@link ThingEventFactory#THING_TRIGGERED_EVENT_TOPIC}
     * @param payload the payload. Contains a serialized {@link ThingEventFactory.TriggerEventPayloadBean}.
     * @param source the source
     * @param channel the channel which triggered the event
     */
    protected ChannelTriggeredEvent(String topic, String payload, String source, String event, ChannelUID channel) {
        super(topic, payload, source);
        this.event = event;
        this.channel = channel;
    }

    /**
     * Returns the event.
     *
     * @return the event
     */
    public String getEvent() {
        return event;
    }

    /**
     * @return the channel which triggered the event
     */
    public ChannelUID getChannel() {
        return channel;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String toString() {
        return channel + " triggered " + event;
    }

}