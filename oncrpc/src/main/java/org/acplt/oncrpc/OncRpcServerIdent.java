/*
 * $Header: /home/harald/repos/remotetea.sf.net/remotetea/src/org/acplt/oncrpc/OncRpcServerIdent.java,v 1.1 2003/08/13 12:03:41 haraldalbrecht Exp $
 *
 * Copyright (c) 1999, 2000
 * Lehrstuhl fuer Prozessleittechnik (PLT), RWTH Aachen
 * D-52064 Aachen, Germany.
 * All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Library General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this program (see the file LICENSE.txt for more
 * details); if not, write to the Free Software Foundation, Inc.,
 * 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package org.acplt.oncrpc;

import java.io.IOException;

/**
 * The class <code>OncRpcServerIdent</code> represents an tuple
 * { program, version, protocol, port} uniquely identifying a particular
 * ONC/RPC server on a given host. This information is used, for instance,
 * as the ONC/RPC portmap PMAP_GETPORT call parameters.
 *
 * <p>An <code>OncRpcServerIdent</code> can be directly serialized into an
 * encoding XDR stream (that is more political correct than "flushed down
 * the toilet").
 *
 * @version $Revision: 1.1 $ $Date: 2003/08/13 12:03:41 $ $State: Exp $ $Locker:  $
 * @author Harald Albrecht
 */
public class OncRpcServerIdent implements XdrAble {

    /**
     * The program number of the ONC/RPC server in question.
     */
    public int program;
    /**
     * The program version number of the ONC/RPC server in question.
     */
    public int version;
    /**
     * The protocol used for communicating with the ONC/RPC server in question.
     * This can be one of the constants ("public final static int") defined
     * in the {@link OncRpcProtocols} interface.
     */
    public int protocol;
    /**
     * The port number of the ONC/RPC server in question.
     */
    public int port;

    /**
     * Constuct an <code>OncRpcServerIdent</code> object with senseless
     * default values for the requested program number, version number,
     * protocol type and port number.
     */
    public OncRpcServerIdent() {
        program  = 0;
        version  = 0;
        protocol = 0;
        port     = 0;
    }

    /**
     * Constructs an <code>OncRpcServerIdent</code> object with the
     * requested program number, version number, protocol type and port
     * number.
     * 
     * @param program Program number of the RPC program
     * @param version Version number of the RPC program
     * @param protocol Protocol type (transport mapping) used for the RPC communication
     * @param port Port number the RPC server is listening for clients
     */
    public OncRpcServerIdent(int program, int version,
                             int protocol, int port) {
        this.program  = program;
        this.version  = version;
        this.protocol = protocol;
        this.port     = port;
    }

    /**
     * Constructs an <code>OncRpcServerIdent</code> object and restores
     * its state from the given XDR stream.
     * 
     * @param xdr An XDR decoding stream
     * 
     * @throws OncRpcException Decoding the identifiers of the RPC server failed.
     * @throws IOException IO error reading bytes from the XDR stream.
     */
    public OncRpcServerIdent(XdrDecodingStream xdr)
           throws OncRpcException, IOException {
        xdrDecode(xdr);
    }

    /**
     * Encodes -- that is: serializes -- an OncRpcServerIdent object
     * into a XDR stream.
     *
     * @param xdr An XDR encoding stream
     * 
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public void xdrEncode(XdrEncodingStream xdr)
           throws OncRpcException, IOException {
        xdr.xdrEncodeInt(program);
        xdr.xdrEncodeInt(version);
        xdr.xdrEncodeInt(protocol);
        xdr.xdrEncodeInt(port);
    }

    /**
     * Decodes -- that is: deserializes -- an OncRpcServerIdent object
     * from a XDR stream.
     *
     * @param xdr An XDR decoding stream
     * 
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public void xdrDecode(XdrDecodingStream xdr)
           throws OncRpcException, IOException {
        program  = xdr.xdrDecodeInt();
        version  = xdr.xdrDecodeInt();
        protocol = xdr.xdrDecodeInt();
        port     = xdr.xdrDecodeInt();
    }

}

// End of OncRpcServerIdent.java
