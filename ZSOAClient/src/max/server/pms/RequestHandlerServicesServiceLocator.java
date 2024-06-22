/**
 * RequestHandlerServicesServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package max.server.pms;

public class RequestHandlerServicesServiceLocator extends org.apache.axis.client.Service implements max.server.pms.RequestHandlerServicesService {

    public RequestHandlerServicesServiceLocator() {
    }


    public RequestHandlerServicesServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RequestHandlerServicesServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RequestHandlerServices
    private java.lang.String RequestHandlerServices_address = "http://localhost:8080/ZSOAServerWebService/services/RequestHandlerServices";

    public java.lang.String getRequestHandlerServicesAddress() {
        return RequestHandlerServices_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RequestHandlerServicesWSDDServiceName = "RequestHandlerServices";

    public java.lang.String getRequestHandlerServicesWSDDServiceName() {
        return RequestHandlerServicesWSDDServiceName;
    }

    public void setRequestHandlerServicesWSDDServiceName(java.lang.String name) {
        RequestHandlerServicesWSDDServiceName = name;
    }

    public max.server.pms.RequestHandlerServices getRequestHandlerServices() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RequestHandlerServices_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRequestHandlerServices(endpoint);
    }

    public max.server.pms.RequestHandlerServices getRequestHandlerServices(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            max.server.pms.RequestHandlerServicesSoapBindingStub _stub = new max.server.pms.RequestHandlerServicesSoapBindingStub(portAddress, this);
            _stub.setPortName(getRequestHandlerServicesWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRequestHandlerServicesEndpointAddress(java.lang.String address) {
        RequestHandlerServices_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (max.server.pms.RequestHandlerServices.class.isAssignableFrom(serviceEndpointInterface)) {
                max.server.pms.RequestHandlerServicesSoapBindingStub _stub = new max.server.pms.RequestHandlerServicesSoapBindingStub(new java.net.URL(RequestHandlerServices_address), this);
                _stub.setPortName(getRequestHandlerServicesWSDDServiceName());
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
        if ("RequestHandlerServices".equals(inputPortName)) {
            return getRequestHandlerServices();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://pms.server.max", "RequestHandlerServicesService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://pms.server.max", "RequestHandlerServices"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RequestHandlerServices".equals(portName)) {
            setRequestHandlerServicesEndpointAddress(address);
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
