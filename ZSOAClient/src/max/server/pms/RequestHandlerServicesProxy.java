package max.server.pms;

public class RequestHandlerServicesProxy implements max.server.pms.RequestHandlerServices {
  private String _endpoint = null;
  private max.server.pms.RequestHandlerServices requestHandlerServices = null;
  
  public RequestHandlerServicesProxy() {
    _initRequestHandlerServicesProxy();
  }
  
  public RequestHandlerServicesProxy(String endpoint) {
    _endpoint = endpoint;
    _initRequestHandlerServicesProxy();
  }
  
  private void _initRequestHandlerServicesProxy() {
    try {
      requestHandlerServices = (new max.server.pms.RequestHandlerServicesServiceLocator()).getRequestHandlerServices();
      if (requestHandlerServices != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)requestHandlerServices)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)requestHandlerServices)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (requestHandlerServices != null)
      ((javax.xml.rpc.Stub)requestHandlerServices)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public max.server.pms.RequestHandlerServices getRequestHandlerServices() {
    if (requestHandlerServices == null)
      _initRequestHandlerServicesProxy();
    return requestHandlerServices;
  }
  
  public java.lang.String getData(java.lang.String stateCode) throws java.rmi.RemoteException{
    if (requestHandlerServices == null)
      _initRequestHandlerServicesProxy();
    return requestHandlerServices.getData(stateCode);
  }
  
  
}