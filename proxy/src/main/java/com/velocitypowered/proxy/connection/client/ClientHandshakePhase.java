package com.velocitypowered.proxy.connection.client;

import com.velocitypowered.proxy.connection.MinecraftConnection;
import com.velocitypowered.proxy.protocol.packet.LoginPluginResponse;

import java.util.Optional;

public interface ClientHandshakePhase {

    default boolean handle(MinecraftConnection connection,
                           LoginPluginResponse message) {
        return false;
    }

    default Optional<String> initialServerData() {
        return Optional.empty();
    }
}
