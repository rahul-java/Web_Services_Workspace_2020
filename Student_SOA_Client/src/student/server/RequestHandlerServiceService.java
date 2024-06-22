/**
 * RequestHandlerServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package student.server;

public interface RequestHandlerServiceService extends javax.xml.rpc.Service {
    public java.lang.String getRequestHandlerServiceAddress();

    public student.server.RequestHandlerService getRequestHandlerService() throws javax.xml.rpc.ServiceException;

    public student.server.RequestHandlerService getRequestHandlerService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
