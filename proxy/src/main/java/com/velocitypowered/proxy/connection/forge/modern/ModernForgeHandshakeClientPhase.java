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

package com.velocitypowered.proxy.connection.forge.modern;

import com.velocitypowered.proxy.connection.MinecraftConnection;
import com.velocitypowered.proxy.connection.backend.VelocityServerConnection;
import com.velocitypowered.proxy.connection.client.ClientConnectionPhase;
import com.velocitypowered.proxy.connection.client.ConnectedPlayer;
import com.velocitypowered.proxy.protocol.packet.LoginPluginResponse;

public enum ModernForgeHandshakeClientPhase implements ClientConnectionPhase {
    NOT_STARTED {
        @Override
        public boolean handle(ConnectedPlayer player, LoginPluginResponse message, VelocityServerConnection server) {
            if (super.handle(player, message, server)) {
                player.setPhase(IN_PROGRESS);
                return true;
            }

            return false;
        }
    },
    IN_PROGRESS,
    COMPLETED {
        @Override
        public boolean consideredComplete() {
            return true;
        }
    };

    @Override
    public boolean handle(ConnectedPlayer player, LoginPluginResponse message, VelocityServerConnection server) {
        if (server != null) {
            MinecraftConnection backendConn = server.getConnection();
            if (backendConn != null) {
                backendConn.write(message.retain());

                return true;
            }
        }

        return false;
    }
}
