package com.ambh.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2018-12-01T23:39:19.290-03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://soap.ambh.com/", name = "CustomerOrdersPortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CustomerOrdersPortType {

    @WebMethod
    @WebResult(name = "getOrdersResponse", targetNamespace = "http://soap.ambh.com/", partName = "parameters")
    public GetOrdersResponse getOrders(
        @WebParam(partName = "parameters", name = "getOrdersRequest", targetNamespace = "http://soap.ambh.com/")
        GetOrdersRequest parameters
    );

    @WebMethod
    @WebResult(name = "createOrdersResponse", targetNamespace = "http://soap.ambh.com/", partName = "parameters")
    public CreateOrdersResponse createOrders(
        @WebParam(partName = "parameters", name = "createOrdersRequest", targetNamespace = "http://soap.ambh.com/")
        CreateOrdersRequest parameters
    );
}
