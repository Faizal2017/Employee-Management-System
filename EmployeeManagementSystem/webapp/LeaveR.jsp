<%@page import="java.time.LocalDate"%>
<%@page import="com.dao.DisplayDetails"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dao.DisplayLeaveReqDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
	
<%	
	LocalDate currentDate = LocalDate.now();
	String EmpID = request.getParameter("empID");
	ResultSet rs = DisplayLeaveReqDAO.DisplayProfile(EmpID); 
	%>
<html>
<head>

	<link rel="stylesheet" href="css/style.css"> 
    <link rel="stylesheet" href="css/Button.css"> 
    <link rel="stylesheet" href="css/stylesidebar.css">
     <link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet"> 
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
    <title>Leave Request</title>
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
            <a href="EmployeeUI_PersonalInfo.jsp?empID=<%=rs.getString("EmpId")%>" class="sidebar-link collapsed" >
            <i class="fa fa-user-circle pe-2" aria-hidden="true"></i>
            Personal Details
            </a>
        </li>
        <li class="sidebar-header">
            <a  class="sidebar-link collapsed"  href="EmployeeUI_BankInfo.jsp?empID=<%=rs.getString("EmpId")%>">
            <i class="fa fa-money pe-2" aria-hidden="true"></i>
            Account Details
            </a>
        </li>
        <li class="sidebar-header">
            <a  class="sidebar-link collapsed"  href="LeaveR.jsp?empID=<%=rs.getString("EmpId")%>">
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
    <div class="title" style="margin: 5% 0 0 31%;"><h1><b>Leave Request</b></h1></div>
    <div class="card-body1" style="padding: 1.5rem; min-height: 30%; margin: 9% 0 0 16%;" >
   
      
      <div class="table table-striped" >
        <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4 no-footer">
          <div class="row">
            
            <div class="row">
            <div class="col-sm-12">
            <div class="table-container" style="overflow-x: clip;">
            <form  action="AddLeaveRequest" method="post">
       				
    <div class="flex flex-wrap -mx-3 mb-6">
    
    <div class="w-full md:w-1/2 px-3">
      <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-last-name">
        Leave Reason :
      </label>
      <input name="Reason"  class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="grid-last-name" type="text" required>
    </div>
  
  
  
    <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
      <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-password">
        Leave Description :
      </label>
      <textarea name="Des" cols="50" class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="grid-password"  required></textarea>
    </div>
  
  </div>
  <div class="flex flex-wrap -mx-3 mb-6">
    <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
      <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-city">
        Leave From :
      </label>
      <input name="From" class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="grid-city" type="date" min="<%=currentDate %>" required>
    </div>
    <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
      <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-city">
        Days : 
      </label>
      <input name="days" class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="grid-city" type="number" min=1 max=3  required>
    </div>
    </div>
   <input type="hidden" name="EmpID" value="<%= EmpID%>">
  
       				
         
                <button type="submit" style="--color: #cfbab6 !important; position:absolute !important; left:84% !important; top:90% !important" ><span>Send</span><i></i></button>
            
        </form>
          
</div>
      </div></div>
            </div>
          </div>
    </div>
    </div>
    <div class="title" style="margin: 30% 0 0 27%;"><h1><b>Leave Request History</b></h1></div>
    <div class="card-body1" style="padding: 1.5rem; min-height: 27%; max-height: 27%;margin: 35% 0 0 3%; width:78%;" >
   	<div class="table table-striped" >
        <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4 no-footer">
          <div class="row"> 
            <div class="row">
            <div class="col-sm-12">
            <div class="table-container" style="max-height: 148px;">
          <table class="table table-striped" id="dataTable"  cellspacing="0" role="grid" aria-describedby="dataTable_info"  >
          <thead>
            <tr role="row" class="table-warning">
              <th class="sorting_asc"  style="width: 10.2px;">#</th>
              <th class="sorting" style="width: 50.2px;">Request ID</th>
              <th class="sorting" style="width: 58.2px;">Reason</th>
              <th class="sorting" style="width: 57px;">Description</th>
              <th class="sorting" style="width: 57px;">From</th>
              <th class="sorting" style="width: 57px;">Days</th>
              <th class="sorting" style="width: 57px;">Status</th>
          </thead>
          <tbody>
          <% 
          int i = 1 , count = 1;
          ResultSet rs2 = DisplayLeaveReqDAO.DisplayLR(EmpID); 
          rs2 = DisplayLeaveReqDAO.DisplayLR(EmpID);
    	  while(rs2.next()){ 
    	  count = 0;%>
           <tr role="row" class="odd">
                <td class="align-middle sorting_1"><%=i++ %></td>
                <td class=" align-middle"><%=rs2.getString("ReqID") %></td>
                <td class=" align-middle"><%=rs2.getString("Title") %></td>
                <td class=" align-middle"><%=rs2.getString("Description") %></td>
                <td class=" align-middle"><%=rs2.getString("FromDate") %></td>
                <td class=" align-middle"><%=rs2.getInt("Days") %></td>
                <td class=" align-middle"><%=rs2.getString("Status") %> <% if(rs2.getString("Status").equals("Pending")){ %>| <a href="DeleteLeaveRequestServlet?Id=<%=rs2.getString("ReqID") %>&empid=<%=rs2.getString("EmpID") %>" class="btn btn-danger btn-circle" onclick="return confirm('Do you Want to Delete ?')">
                    <span class="icon text-white" title="Delete">
                      <i class="fa-solid fa-trash"></i>
                    </span>
                  </a> <% } %></td>
             </tr>
             <%} 
             if (count == 1){%>
            	 <tr role="row" class="odd">
                 <td colspan="7" ><h2 style="color: #433633; font-family: 'Poppins', sans-serif; text-align:center;">NO Leaave Found !!!</h2> </td>
               </tr> 
            	 
            <%  }
             %>
            </tbody>
        </table></div></div></div></div></div>
      
      
    </div>
    </div>
    </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
    <script src="script.js"></script>
    
    <% 
    if( request.getAttribute("name") != null){
    %><script>
    $(document).ready(function() {
        $.bootstrapGrowl('Send Successfully !!', {
            type: 'success',
            offset: {from: 'top', amount: 75},
            align: 'right',
            width: 350,
            allow_dismiss: true,
            delay: 3000
        });
    });
    
</script><% }%>
<% 
        if( request.getAttribute("name5") != null){
        %><script>
        $(document).ready(function() {
            $.bootstrapGrowl('Deleted Successfully !!', {
                type: 'info',
                offset: {from: 'top', amount: 75},
                align: 'right',
                width: 350,
                allow_dismiss: true,
                delay: 3000
            });
        });
    </script><% }%>
  </body>
</html>
