package max;

public class RequestHandlerSoaProxy implements max.RequestHandlerSoa {
  private String _endpoint = null;
  private max.RequestHandlerSoa requestHandlerSoa = null;
  
  public RequestHandlerSoaProxy() {
    _initRequestHandlerSoaProxy();
  }
  
  public RequestHandlerSoaProxy(String endpoint) {
    _endpoint = endpoint;
    _initRequestHandlerSoaProxy();
  }
  
  private void _initRequestHandlerSoaProxy() {
    try {
      requestHandlerSoa = (new max.RequestHandlerSoaServiceLocator()).getRequestHandlerSoa();
      if (requestHandlerSoa != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)requestHandlerSoa)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)requestHandlerSoa)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (requestHandlerSoa != null)
      ((javax.xml.rpc.Stub)requestHandlerSoa)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public max.RequestHandlerSoa getRequestHandlerSoa() {
    if (requestHandlerSoa == null)
      _initRequestHandlerSoaProxy();
    return requestHandlerSoa;
  }
  
  public java.lang.String getData(java.lang.String xml) throws java.rmi.RemoteException{
    if (requestHandlerSoa == null)
      _initRequestHandlerSoaProxy();
    return requestHandlerSoa.getData(xml);
  }
  
  
}