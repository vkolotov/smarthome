/**
 * Copyright (c) 2014-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.core.thing.type;

import org.eclipse.smarthome.core.common.registry.Identifiable;
import org.eclipse.smarthome.core.thing.UID;

/**
 * The {@link AbstractDescriptionType} class is the base class for a {@link ThingType},
 * a {@link BridgeType} a {@link ChannelType} or a {@link ChannelGroupType}.
 * This class contains only properties and methods accessing them.
 * <p>
 * <b>Hint:</b> This class is immutable.
 *
 * @author Michael Grammling - Initial Contribution
 */
public abstract class AbstractDescriptionType implements Identifiable<UID> {

    private UID uid;
    private String label;
    private String description;

    /**
     * Creates a new instance of this class with the specified parameters.
     *
     * @param uid the unique identifier which identifies the according type within
     *            the overall system (must neither be null, nor empty)
     *
     * @param label the human readable label for the according type
     *            (must neither be null nor empty)
     *
     * @param description the human readable description for the according type
     *            (could be null or empty)
     *
     * @throws IllegalArgumentException if the UID is null, or the label is null or empty
     */
    public AbstractDescriptionType(UID uid, String label, String description) throws IllegalArgumentException {

        if (uid == null) {
            throw new IllegalArgumentException("The UID must not be null");
        }

        if ((label == null) || (label.isEmpty())) {
            throw new IllegalArgumentException("The label must neither be null nor empty!");
        }

        this.uid = uid;
        this.label = label;
        this.description = description;
    }

    /**
     * Returns the unique identifier which identifies the according type within the overall system.
     *
     * @return the unique identifier which identifies the according type within
     *         the overall system (neither null, nor empty)
     */
    @Override
    public UID getUID() {
        return this.uid;
    }

    /**
     * Returns the human readable label for the according type.
     *
     * @return the human readable label for the according type (neither null, nor empty)
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * Returns the human readable description for the according type.
     *
     * @return the human readable description for the according type (could be null or empty)
     */
    public String getDescription() {
        return this.description;
    }

}
