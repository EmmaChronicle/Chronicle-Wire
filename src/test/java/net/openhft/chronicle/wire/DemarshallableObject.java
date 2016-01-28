package net.openhft.chronicle.wire;

import org.jetbrains.annotations.NotNull;

/**
 * Created by peter on 27/01/16.
 */
public class DemarshallableObject implements Demarshallable, WriteMarshallable {
    final String name;
    final int value;

    public DemarshallableObject(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public DemarshallableObject(WireIn wire) {
        this.name = wire.read(() -> "name").text();
        this.value = wire.read(() -> "value").int32();
    }

    @Override
    public void writeMarshallable(@NotNull WireOut wire) {
        wire.write(() -> "name").text(name)
                .write(() -> "value").int32(value);
    }
}