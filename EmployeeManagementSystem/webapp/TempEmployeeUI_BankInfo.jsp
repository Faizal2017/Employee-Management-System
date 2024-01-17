<%@page import="com.dao.DisplayDetails"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
	String EmpID = request.getParameter("empID");
	ResultSet rs = DisplayDetails.DisplayTempEmp(EmpID);
	int i = 1;
	int count = 1 , count2 = 1;
	%>
	<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="css/style.css"> 
    <link rel="stylesheet" href="css/Button.css"> 
    <link rel="stylesheet" href="css/stylesidebar.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" integrity="sha256-h20CPZ0QyXlBuAw7A+KluUYx/3pK+c7lYEpqLTlxjYQ=" crossorigin="anonymous" /> 
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/ae360af17e.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-growl/1.0.0/jquery.bootstrap-growl.min.js"></script>
    <script src="Js/index.js">   </script>
    <title>Account Information</title>
  </head>
  <body> 
  <div class="wrapper">
        <!-- Sidebar -->
        
        <aside id="sidebar" >
            <div class="h-100">
            <% while(rs.next()){ %>
                
        	<div class="logo-details">
            <img src="img/ProPic/<%=rs.getString("Photo") %>">
            <h3  class="name" style="  color: #FFF;  font-size: 18px; margin: 10px 0 8px 0;"><b><%=rs.getString("name") %></b></h3>
            <span style="  color: #FFF;"><%=rs.getString("Position") %></span>
            
        </div>
    <ul class="sidebar-nav">
        <li class="sidebar-header">
            <a href="TempEmployeeUI_PersonalInfo.jsp?empID=<%=rs.getString("EmpId")%>" class="sidebar-link collapsed" >
            <i class="fa fa-user-circle pe-2" aria-hidden="true"></i>
            Personal Details
            </a>
        </li>
        <li class="sidebar-header">
            <a  class="sidebar-link collapsed"  href="TempEmployeeUI_BankInfo.jsp?empID=<%=rs.getString("EmpId")%>">
            <i class="fa fa-money pe-2" aria-hidden="true"></i>
            Account Details
            </a>
        </li>
        <li class="sidebar-header">
            <a  class="sidebar-link collapsed"  href="TempLeaveR.jsp?empID=<%=rs.getString("EmpId")%>">
            <i class="fa fa-paper-plane-o pe-2" aria-hidden="true"></i>
             Leave Request
            </a>
        </li>
        
        <li class="sidebar-header" style="position: absolute; bottom: 0; width: 80%;">
            <a  class="sidebar-link collapsed" href="index.jsp">
            <i class="fa fa-sign-out pe-2" aria-hidden="true"></i>
            Log out<%} %>
            </a>
        </li>
    </ul>
    </div>
    </aside>
    <div class="main">
    <nav class="navbar navbar-expand px-3" style="border-bottom: 1px solid #433633;  padding: 0 !important;">
    	<marquee><h2><b><div id="datetime" style="font-family: 'Poppins', sans-serif; color:#433633;"></div></b></h2></marquee>
    </nav>
    <div class="title" style="margin: 5% 0 0 31%;"><h1><b>Account Details</b></h1></div>
    <div class="card-body1" style="padding: 1.5rem; min-height: 30%; margin: 9% 0 0 16%;" >
   
      
      <div class="table table-striped" >
        <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4 no-footer">
          <div class="row">
            <div class="col-sm-12 col-md-6" style="left: 53%; ">
              <div id="dataTable_filter" class="dataTables_filter" style="display:flex; width: 90%;">
              </div>
             </div> 
            <div class="row">
            <div class="col-sm-12">
            <div class="table-container" >
          <table class="table table-striped" id="dataTable"  cellspacing="0" role="grid" aria-describedby="dataTable_info"  >
          <thead>
            <tr role="row" class="table-warning">
              <th class="sorting_asc"  style="width: 10.2px;">#</th>
              <th class="sorting" style="width: 50.2px;">Account Number</th>
              <th class="sorting" style="width: 58.2px;">Bank</th>
              <th class="sorting" style="width: 57px;">Branch</th>
          </thead>
          <tbody>
          <% 
        rs = DisplayDetails.DisplayAcdetails(EmpID); 
         while(rs.next()){ 
         count = 0;%>
           <tr role="row" class="odd">
                <td class="align-middle sorting_1"><%=i++ %></td>
                <td class=" align-middle"><%=rs.getString("AccountNo") %></td>
                <td class=" align-middle"><%=rs.getString("Bank") %></td>
                <td class=" align-middle"><%=rs.getString("Branch") %></td>
             </tr>
             <%}
         if(count == 1 ){%>
        	<tr role="row" class="odd">
               <td colspan="4" ><h2 style="color: #433633; font-family: 'Poppins', sans-serif; text-align:center;">NO Account Added !!!</h2> </td>
             </tr>
             <%} %>
            </tbody>
        </table></div>
      </div></div>
            </div>
          </div>
    </div>
    </div>
    <div class="title" style="margin: 25% 0 0 31%;"><h1><b>Payment History</b></h1></div>
    <div class="card-body1" style="padding: 1.5rem; min-height: 35%; margin: 30% 0 0 3%; width:78%;" >
   
      
      <div class="table table-striped" >
        <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4 no-footer">
          <div class="row">
            <div class="col-sm-12 col-md-6" style="left: 53%; ">
              <div id="dataTable_filter" class="dataTables_filter" style="display:flex; width: 90%;">
              </div>
             </div> 
            <div class="row">
            <div class="col-sm-12">
            <div class="table-container" >
          <table class="table table-striped" id="dataTable"  cellspacing="0" role="grid" aria-describedby="dataTable_info"  >
          <thead>
            <tr role="row" class="table-warning">
              <th class="sorting_asc"  style="width: 10.2px;">#</th>
              <th class="sorting" style="width: 50.2px;">Payment ID</th>
              <th class="sorting" style="width: 58.2px;">Salary</th>
              <th class="sorting" style="width: 57px;">Month</th>
              <th class="sorting" style="width: 57px;">Extra Leave</th>
              <th class="sorting" style="width: 57px;">Bonus %</th>
              <th class="sorting" style="width: 57px;">Net Salary</th>
              <th class="sorting" style="width: 57px;">Account</th>
              <th class="sorting" style="width: 57px;">Date</th>
          </thead>
          <tbody>
          <% 
        rs = DisplayDetails.DisplayPaymentHistory(EmpID); 
         while(rs.next()){ 
         count2 = 0;%>
           <tr role="row" class="odd">
                <td class="align-middle sorting_1"><%=i++ %></td>
                <td class=" align-middle"><%=rs.getString("PId") %></td>
                <td class=" align-middle"><%=rs.getString("Salary") %></td>
                <td class=" align-middle"><%=rs.getString("Month") %></td>
                <td class=" align-middle"><%=rs.getString("ExtraLeave") %></td>
                <td class=" align-middle"><%=rs.getString("BonusPercentage") %></td>
                <td class=" align-middle"><%=rs.getString("NetSalary") %></td>
                <td class=" align-middle"><%=rs.getString("Account") %></td>
                <td class=" align-middle"><%=rs.getString("Date") %></td>
             </tr>
             <%} 
         if(count2 == 1 ){%>
     	<tr role="row" class="odd">
            <td colspan="9" ><h2 style="color: #433633; font-family: 'Poppins', sans-serif; text-align:center;">NO Payment Found !!!</h2> </td>
          </tr>
          <%} %>
            </tbody>
        </table></div>
      </div></div>
            </div>
          </div>
    </div>
    </div>
    </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
    <script src="script.js"></script>
  </body>
</html>

