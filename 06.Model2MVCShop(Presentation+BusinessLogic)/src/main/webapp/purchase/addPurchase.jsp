
<%@page import="com.model2.mvc.service.domain.Purchase"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%-- <%
	Purchase purchase = (Purchase)request.getAttribute("purchase");
%> --%>
<html>
<head>
<title>���� ���� ����Ʈ</title>
</head>

<body>

<form name="updatePurchase" action="/updatePurchaseView.do?tranNo=${purchase.tranNo}" method="post">

������ ���� ���Ű� �Ǿ����ϴ�.

<table border=1>
   <tr>
      <td>��ǰ��ȣ</td>
      <td>${purchase.purchaseProd.prodNo}</td>
      <td></td>
   </tr>
   <tr>
      <td>�����ھ��̵�</td>
      <%-- <td><%=purchase.getBuyer().getUserId() %></td> --%>
      <td>${purchase.buyer.userId }</td>
      <td></td>
   </tr>
   <tr>
      <td>���Ź��</td>
      <td> <%-- <%=purchase.getPaymentOption() %> --%>
      ${purchase.paymentOption }
      </td>
      <td></td>
   </tr>
   <tr>
      <td>�������̸�</td>
      <td><%-- <%=purchase.getReceiverName() %> --%>
      ${purchase.receiverName}
      </td>
      <td></td>
   </tr>
   <tr>
      <td>�����ڿ���ó</td>
      <td><%-- <%=purchase.getReceiverPhone() %> --%>
      ${purchase.receiverPhone }
      </td>
      <td></td>
   </tr>
   <tr>
      <td>�������ּ�</td>
      <td><%-- <%=purchase.getDivyAddr() %> --%>
	  ${purchase.divyAddr}
      </td>
      <td></td>
   </tr>
      <tr>
      <td>���ſ�û����</td>
      <td><%-- <%=purchase.getDivyRequest() %> --%>
      ${purchase.divyRequest }
      </td>
      <td></td>
   </tr>
   <tr>
      <td>����������</td>
      <td><%-- <%=purchase.getOrderDate() %> --%>
      ${purchase.orderDate}
      </td>
      <td></td>
   </tr>
</table>
</form>

</body>
</html>