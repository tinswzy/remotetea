/*
 * Automatically generated by jrpcgen 1.0.5 on 14.08.03 10:19
 * jrpcgen is part of the "Remote Tea" ONC/RPC package for Java
 * See http://remotetea.sourceforge.net for details
 */
package tests.org.acplt.oncrpc.jrpcgen;
import org.acplt.oncrpc.*;
import java.io.IOException;

import java.net.InetAddress;

import org.acplt.oncrpc.server.*;

/**
 */
public abstract class demoServerStub extends OncRpcServerStub implements OncRpcDispatchable {

    public demoServerStub()
           throws OncRpcException, IOException {
        this(0);
    }

    public demoServerStub(int port)
           throws OncRpcException, IOException {
        this(null, port);
    }

    public demoServerStub(InetAddress bindAddr, int port)
           throws OncRpcException, IOException {
        info = new OncRpcServerTransportRegistrationInfo [] {
            new OncRpcServerTransportRegistrationInfo(demo.DEMO, 1),
            new OncRpcServerTransportRegistrationInfo(demo.DEMO, 2),
        };
        transports = new OncRpcServerTransport [] {
            new OncRpcUdpServerTransport(this, bindAddr, port, info, 32768),
            new OncRpcTcpServerTransport(this, bindAddr, port, info, 32768)
        };
    }

    public void dispatchOncRpcCall(OncRpcCallInformation call, int program, int version, int procedure)
           throws OncRpcException, IOException {
        if ( version == 1 ) {
            switch ( procedure ) {
            case 0: {
                call.retrieveCall(XdrVoid.XDR_VOID);
                NULL_1();
                call.reply(XdrVoid.XDR_VOID);
                break;
            }
            case 1: {
                XdrString args$ = new XdrString();
                call.retrieveCall(args$);
                XdrString result$ = new XdrString(echo_1(args$.stringValue()));
                call.reply(result$);
                break;
            }
            case 2: {
                STRINGVECTOR args$ = new STRINGVECTOR();
                call.retrieveCall(args$);
                XdrString result$ = new XdrString(concat_1(args$));
                call.reply(result$);
                break;
            }
            case 3: {
                XdrInt args$ = new XdrInt();
                call.retrieveCall(args$);
                XdrBoolean result$ = new XdrBoolean(checkfoo_1(args$.intValue()));
                call.reply(result$);
                break;
            }
            case 4: {
                call.retrieveCall(XdrVoid.XDR_VOID);
                XdrInt result$ = new XdrInt(foo_1());
                call.reply(result$);
                break;
            }
            case 5: {
                LINKEDLIST args$ = new LINKEDLIST();
                call.retrieveCall(args$);
                LINKEDLIST result$ = ll_1(args$);
                call.reply(result$);
                break;
            }
            default:
                call.failProcedureUnavailable();
            }
        } else if ( version == 2 ) {
            switch ( procedure ) {
            case 0: {
                call.retrieveCall(XdrVoid.XDR_VOID);
                NULL_2();
                call.reply(XdrVoid.XDR_VOID);
                break;
            }
            case 42: {
                class XdrAble$ implements XdrAble {
                    public String arg1;
                    public String arg2;
                    public void xdrEncode(XdrEncodingStream xdr)
                        throws OncRpcException, IOException {
                    }
                    public void xdrDecode(XdrDecodingStream xdr)
                        throws OncRpcException, IOException {
                        arg1 = xdr.xdrDecodeString();
                        arg2 = xdr.xdrDecodeString();
                    }
                };
                XdrAble$ args$ = new XdrAble$();
                call.retrieveCall(args$);
                XdrString result$ = new XdrString(cat_2(args$.arg1, args$.arg2));
                call.reply(result$);
                break;
            }
            case 43: {
                class XdrAble$ implements XdrAble {
                    public String one;
                    public String two;
                    public String three;
                    public void xdrEncode(XdrEncodingStream xdr)
                        throws OncRpcException, IOException {
                    }
                    public void xdrDecode(XdrDecodingStream xdr)
                        throws OncRpcException, IOException {
                        one = xdr.xdrDecodeString();
                        two = xdr.xdrDecodeString();
                        three = xdr.xdrDecodeString();
                    }
                };
                XdrAble$ args$ = new XdrAble$();
                call.retrieveCall(args$);
                XdrString result$ = new XdrString(cat3_2(args$.one, args$.two, args$.three));
                call.reply(result$);
                break;
            }
            case 3: {
                XdrInt args$ = new XdrInt();
                call.retrieveCall(args$);
                XdrString result$ = new XdrString(checkfoo_2(args$.intValue()));
                call.reply(result$);
                break;
            }
            case 55: {
                class XdrAble$ implements XdrAble {
                    public LINKEDLIST l1;
                    public LINKEDLIST l2;
                    public void xdrEncode(XdrEncodingStream xdr)
                        throws OncRpcException, IOException {
                    }
                    public void xdrDecode(XdrDecodingStream xdr)
                        throws OncRpcException, IOException {
                        l1 = new LINKEDLIST(xdr);
                        l2 = new LINKEDLIST(xdr);
                    }
                };
                XdrAble$ args$ = new XdrAble$();
                call.retrieveCall(args$);
                LINKEDLIST result$ = llcat_2(args$.l1, args$.l2);
                call.reply(result$);
                break;
            }
            case 100: {
                class XdrAble$ implements XdrAble {
                    public String a;
                    public int b;
                    public int c;
                    public int d;
                    public void xdrEncode(XdrEncodingStream xdr)
                        throws OncRpcException, IOException {
                    }
                    public void xdrDecode(XdrDecodingStream xdr)
                        throws OncRpcException, IOException {
                        a = xdr.xdrDecodeString();
                        b = xdr.xdrDecodeInt();
                        c = xdr.xdrDecodeInt();
                        d = xdr.xdrDecodeInt();
                    }
                };
                XdrAble$ args$ = new XdrAble$();
                call.retrieveCall(args$);
                test_2(args$.a, args$.b, args$.c, args$.d);
                call.reply(XdrVoid.XDR_VOID);
                break;
            }
            default:
                call.failProcedureUnavailable();
            }
        } else {
            call.failProcedureUnavailable();
        }
    }

    public abstract void NULL_1();

    public abstract String echo_1(String arg1);

    public abstract String concat_1(STRINGVECTOR arg1);

    public abstract boolean checkfoo_1(int arg1);

    public abstract int foo_1();

    public abstract LINKEDLIST ll_1(LINKEDLIST arg1);

    public abstract void NULL_2();

    public abstract String cat_2(String arg1, String arg2);

    public abstract String cat3_2(String one, String two, String three);

    public abstract String checkfoo_2(int foo);

    public abstract LINKEDLIST llcat_2(LINKEDLIST l1, LINKEDLIST l2);

    public abstract void test_2(String a, int b, int c, int d);

}
// End of demoServerStub.java
