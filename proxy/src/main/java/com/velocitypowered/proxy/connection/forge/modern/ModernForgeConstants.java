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

/**
 * Constants for use with Modern Forge systems.
 */
public class ModernForgeConstants {
    /**
     * Clients attempting to connect to 1.13+ Forge servers will have this token appended to the
     * hostname in the initial handshake packet.
     */
    public static final String HANDSHAKE_HOSTNAME_TOKEN = "\0FML3\0";

    public static final String HANDSHAKE_HOSTNAME_IDENTIFIER = "FML3";

    /**
     * The channel for forge login wrapper.
     */
    public static final String LOGIN_WRAPPER_CHANNEL = "fml:loginwrapper";
}
