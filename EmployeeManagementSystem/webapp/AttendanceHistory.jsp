<%@page import="com.dao.AttendanceDAO"%>
<%@page import="com.dao.DisplayDetails"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
	String Empid = request.getParameter("EMPID");
	String empid = Empid.substring(0, 1);
	ResultSet rs = null;
	if(empid.equals("P")){
		rs = DisplayDetails.Displayp(Empid);
	}
	else if(empid.equals("T")){
		rs = DisplayDetails.Displayt(Empid);
	}
	

%>
<html>
<head>
    
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/Button.css"> 
    <link rel="stylesheet" href="css/stylesidebar.css"> 
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/ae360af17e.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="Js/index.js">   </script>
    <title>User Attendance History</title>
  </head>
  <body> 
  <div class="wrapper">
        <!-- Sidebar -->
        <aside id="sidebar" >
            <div class="h-100">
                <div class="sidebar-logo">
                    <a href="#">iManage</a>
                </div>
                <!-- Sidebar Navigation -->
                <ul class="sidebar-nav">
                    <li class="sidebar-item">
                        <a href="#" class="sidebar-link collapsed" data-bs-toggle="collapse" data-bs-target="#multi"
                            aria-expanded="false" aria-controls="multi">
                            <i class="fa-regular fa-user pe-2"></i>
                            Employee Manage
                        </a>
						 <ul id="multi" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
						    <li class="sidebar-item">
						        <a href="#" class="sidebar-link collapsed" data-bs-toggle="collapse"
						            data-bs-target="#multi-one" aria-expanded="false" aria-controls="multi-one">
						            Add Employee
						        </a>
						        <ul id="multi-one" class="sidebar-dropdown list-unstyled collapse">
						            <li class="sidebar-item">
						                <a href="AddpermenantEmployee.jsp" class="sidebar-link">Permanent Employee</a>
						            </li>
						            <li class="sidebar-item">
						                <a href="AddTemporaryEmp.jsp" class="sidebar-link">Temporary Employee</a>
						            </li>
						        </ul>
						    </li>
						    <li class="sidebar-item">
						        <a href="#" class="sidebar-link collapsed" data-bs-toggle="collapse"
						            data-bs-target="#multi-two" aria-expanded="false" aria-controls="multi-two">
						            Employee Details
						        </a>
						        <ul id="multi-two" class="sidebar-dropdown list-unstyled collapse">
						            <li class="sidebar-item">
						                <a href="DisplayPermenantEmp.jsp" class="sidebar-link">Permenent Employee</a>
						            </li>
						            <li class="sidebar-item">
						                <a href="DisplayTempEmp.jsp" class="sidebar-link">Temporary Employee</a>
						            </li>
						        </ul>
						    </li>
						</ul>
                    </li>
                    <li class="sidebar-item">
                    	<a href="User.jsp" class="sidebar-link collapsed" >
                    	<i class="fa-solid fa-key pe-2"></i>
                        User Details</a>
                    </li>
                    <li class="sidebar-item">
                        <a href="#" class="sidebar-link collapsed" data-bs-toggle="collapse" data-bs-target="#Payroll"
                            aria-expanded="false" aria-controls="pages">
                            <i class="fa-brands fa-paypal pe-2"></i>
                            Payroll
                        </a>
                        <ul id="Payroll" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
                            <li class="sidebar-item">
                                <a href="Add_acc.jsp" class="sidebar-link">Add Account</a>
                            </li>
                            <li class="sidebar-item">
                                <a href="Acc_details.jsp" class="sidebar-link">Account Details</a>
                            </li>
                            <li class="sidebar-item">
                                <a href="SalaryDetails.jsp" class="sidebar-link">Update Salary</a>
                            </li>
                            <li class="sidebar-item">
                                <a href="PayEmployee.jsp" class="sidebar-link">Make Payment</a>
                            </li>
                            <li class="sidebar-item">
                                <a href="PaymentHistory.jsp" class="sidebar-link">Payment History</a>
                            </li>
                        </ul>
                    </li>
                    <li class="sidebar-item">
                        <a href="#" class="sidebar-link collapsed" data-bs-toggle="collapse" data-bs-target="#department"
                            aria-expanded="false" aria-controls="auth">
                            <i class="fa-solid fa-building pe-2"></i>
                            Department
                        </a>
                        <ul id="department" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
                            <li class="sidebar-item">
                                <a href="AddDepartment.jsp" class="sidebar-link">Add Department</a>
                            </li>
                            <li class="sidebar-item">
                                <a href="DepDetails.jsp" class="sidebar-link">Department Details</a>
                            </li>
                        </ul>
                    </li>
                    <li class="sidebar-item">
                        <a href="#" class="sidebar-link collapsed" data-bs-toggle="collapse" data-bs-target="#attendence"
                            aria-expanded="false" aria-controls="auth">
                            <i class="fa-regular fa-note-sticky pe-2"></i>
                            Attendance
                        </a>
                        <ul id="attendence" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
                            <li class="sidebar-item">
                                <a href="AttendenceAdmin.jsp" class="sidebar-link">Mark Attendance</a>
                            </li>
                            <li class="sidebar-item">
                                <a href="AttendanceUsers.jsp" class="sidebar-link">Check History</a>
                            </li>
                        </ul>
                    </li>
                    <li class="sidebar-item">
                        <a href="#" class="sidebar-link collapsed" data-bs-toggle="collapse" data-bs-target="#leave"
                            aria-expanded="false" aria-controls="dashboard">
                            <i class="fa-solid fa-person-running pe-2"></i>
                            Leave
                        </a>
                        <ul id="leave" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
                            <li class="sidebar-item">
                                <a href="LeaveRAdmin.jsp" class="sidebar-link">Leave Requests</a>
                            </li>
                            <li class="sidebar-item">
                                <a href="LeaveRAdminUser.jsp" class="sidebar-link">Leave History</a>
                            </li>
                        </ul>
                    </li>
                    <li class="sidebar-item">
                        <a href="#" class="sidebar-link collapsed" data-bs-toggle="collapse" data-bs-target="#training"
                            aria-expanded="false" aria-controls="auth">
                            <i class="fa-solid fa-user-ninja pe-2"></i>
                            Training 
                        </a>
                        <ul id="training" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
                            <li class="sidebar-item">
                                <a href="Traingform.jsp" class="sidebar-link">Add Training</a>
                            </li>
                            <li class="sidebar-item">
                                <a href="DisplayTraining.jsp" class="sidebar-link">Training details</a>
                            </li>
                            <li class="sidebar-item">
                                <a href="TrainingDetails.jsp" class="sidebar-link">Assign Training</a>
                            </li>
                        </ul>
                    </li>
                    <li class="sidebar-item" style="position: absolute; bottom: 0; width: 80%;">
                        <a href="index.jsp" class="sidebar-link collapsed" >
                            <i class="fa-solid fa-right-from-bracket pe-2"></i>
                            Log out
                        </a>
                        </li>
               
                </ul>
            </div>
    </aside>
    <div class="main">
    <nav class="navbar navbar-expand px-3" style="border-bottom: 1px solid #433633;  padding: 0 !important;">
    	<marquee><h2><b><div id="datetime" style="font-family: 'Poppins', sans-serif; color:#433633;"></div></b></h2></marquee>
    </nav>
    <div class="title"><h1><b>Attendance History</b></h1></div>
    <div class="card-body1" style="padding: 1.5rem;" >
      <div class="input-group" style= "padding : 0 0 0 0; margin: 0 0 0 0;">
			<% while(rs.next()) {%>		
					<h3 style="color:#433633;">ID &emsp;: <%=rs.getString("EmpId") %> <br>Name &emsp;: <%=rs.getString("name") %></h3><% } %>
				</div>
      
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
              <th class="sorting" style="width: 74.2px;">Date</th>
              <th class="sorting" style="width: 50.2px;">Attendance</th>
          </thead>
          <tbody>
          <%
          int i = 1;
          	rs = AttendanceDAO.DisplayAttendence(Empid);
          	while(rs.next()){
          %>
          <tr role="row" class="odd">
                <td class="align-middle sorting_1"><%=i++ %></td>
                <td class=" align-middle"><%=rs.getString("Date") %></td>
                <td class=" align-middle"><%=rs.getString("Status") %></td>
            </tr>
            <%} %>
            </tbody>
        </table>
        <a href="AttendanceUsers.jsp"><button  style="--color: #cfbab6; position:absolute; left:4%; top:97%"><span>Back</span><i></i></button></a>
        </div>
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
     