package com.velocitypowered.proxy.connection.client;

public class ClientHandshakePhases {

    public static final ClientHandshakePhase VANILLA = new ClientHandshakePhase() {
    };

    private ClientHandshakePhases() {
        throw new AssertionError();
    }
}
