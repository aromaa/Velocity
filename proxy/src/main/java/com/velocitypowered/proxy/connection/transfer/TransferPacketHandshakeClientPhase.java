/*
 * Copyright (C) 2018-2023 Velocity Contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.velocitypowered.proxy.connection.transfer;

import com.velocitypowered.proxy.connection.MinecraftConnection;
import com.velocitypowered.proxy.connection.client.ClientHandshakePhase;
import com.velocitypowered.proxy.protocol.ProtocolUtils;
import com.velocitypowered.proxy.protocol.packet.LoginPluginResponse;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;

import java.util.Optional;

public class TransferPacketHandshakeClientPhase implements ClientHandshakePhase {

    private @MonotonicNonNull String data;

    @Override
    public boolean handle(MinecraftConnection connection, LoginPluginResponse message) {
        if (message.getId() == TransferPacketConstants.TRANSFER_PACKET_ID
                && message.content().readByte() == 1) {
            this.data = ProtocolUtils.readString(message.content());

            return true;
        }

        return false;
    }

    @Override
    public Optional<String> initialServerData() {
        return Optional.ofNullable(this.data);
    }
}
