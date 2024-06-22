package pension.up;

public class RequestHandlerServiceProxy implements pension.up.RequestHandlerService {
  private String _endpoint = null;
  private pension.up.RequestHandlerService requestHandlerService = null;
  
  public RequestHandlerServiceProxy() {
    _initRequestHandlerServiceProxy();
  }
  
  public RequestHandlerServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initRequestHandlerServiceProxy();
  }
  
  private void _initRequestHandlerServiceProxy() {
    try {
      requestHandlerService = (new pension.up.RequestHandlerServiceServiceLocator()).getRequestHandlerService();
      if (requestHandlerService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)requestHandlerService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)requestHandlerService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (requestHandlerService != null)
      ((javax.xml.rpc.Stub)requestHandlerService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public pension.up.RequestHandlerService getRequestHandlerService() {
    if (requestHandlerService == null)
      _initRequestHandlerServiceProxy();
    return requestHandlerService;
  }
  
  public java.lang.String getData() throws java.rmi.RemoteException{
    if (requestHandlerService == null)
      _initRequestHandlerServiceProxy();
    return requestHandlerService.getData();
  }
  
  
}