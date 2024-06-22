/**
 * RequestHandlerServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package student.server;

public class RequestHandlerServiceServiceLocator extends org.apache.axis.client.Service implements student.server.RequestHandlerServiceService {

    public RequestHandlerServiceServiceLocator() {
    }


    public RequestHandlerServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RequestHandlerServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RequestHandlerService
    private java.lang.String RequestHandlerService_address = "http://localhost:8081/Student_SOA_WebServer/services/RequestHandlerService";

    public java.lang.String getRequestHandlerServiceAddress() {
        return RequestHandlerService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RequestHandlerServiceWSDDServiceName = "RequestHandlerService";

    public java.lang.String getRequestHandlerServiceWSDDServiceName() {
        return RequestHandlerServiceWSDDServiceName;
    }

    public void setRequestHandlerServiceWSDDServiceName(java.lang.String name) {
        RequestHandlerServiceWSDDServiceName = name;
    }

    public student.server.RequestHandlerService getRequestHandlerService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RequestHandlerService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRequestHandlerService(endpoint);
    }

    public student.server.RequestHandlerService getRequestHandlerService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            student.server.RequestHandlerServiceSoapBindingStub _stub = new student.server.RequestHandlerServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getRequestHandlerServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRequestHandlerServiceEndpointAddress(java.lang.String address) {
        RequestHandlerService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (student.server.RequestHandlerService.class.isAssignableFrom(serviceEndpointInterface)) {
                student.server.RequestHandlerServiceSoapBindingStub _stub = new student.server.RequestHandlerServiceSoapBindingStub(new java.net.URL(RequestHandlerService_address), this);
                _stub.setPortName(getRequestHandlerServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("RequestHandlerService".equals(inputPortName)) {
            return getRequestHandlerService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://server.student", "RequestHandlerServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://server.student", "RequestHandlerService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RequestHandlerService".equals(portName)) {
            setRequestHandlerServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
