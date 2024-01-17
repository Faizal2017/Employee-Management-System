<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.db.util.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
       
<%

   
Connection con = null;
ResultSet rs = null;
Statement stmt = null;
try {
	DBConnection DBcon =DBConnection.getInstance();
	
	con = DBcon.createconnection();
    stmt = con.createStatement();	
    String query = "select * from department";

    rs = stmt.executeQuery(query);
}
catch (SQLException e) {
    e.printStackTrace();
}
    
    
%>
    
<!DOCTYPE html>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<html lang="en">
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
    <title>Add Temporary Employee</title>
    
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
    <div class="title" style="margin: 7% 0 0 24%;"><h1><b>Add Temporary Employee</b></h1></div>
    <div class="card-body1" style="padding: 1.5rem;" >
      <div class="table table-striped" >
        <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4 no-footer">
          <div class="row">
            <div class="col-sm-12 col-md-6" style=" width:100%">
              <div id="dataTable_filter" class="dataTables_filter" style="display:block; width: 100%;">
              <div class="row">
            <div class="col-sm-12">
            <div class="table-container" style="overflow-x: clip; max-height: 370px">
              
              <form id="employeeForm" action="AddTempEmpServelet" method="post">
       
            <div class="form-group" style="float:left ; width:50%">
                <label for="name">Full Name:</label>
                <input type="text" id="name" name="name" required placeholder="eg: Faizal Amaan">
            </div>
            <div class="form-group" >
                <label for="age">Date of Birth:</label>
                <input type="date" id="name" name="age" required placeholder="DD.MM.YYYY">
            </div>
            <div class="form-group" style="position: relative;width: 50%;">
                <label for="address">Address:</label>
                <input type="text" id="address" name="address" required>
            </div>
            <div class="form-group" style="position: absolute;width: 50%;top: 53px; left:50%">
                <label for="gender">Gender:</label>
                <select id="gender" name="gender" required>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                </select>
            </div>
            
            <div class="form-group" style="float:left ; width:50%">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" >
            </div>
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="tel" id="phone" name="phone" required>
            </div>
            
            <div class="form-group">
                <label for="department">Choose Department:</label>
                <select id="department" name="department" required>
                  <%  while(rs.next()){ %>
            				<option value="<%=rs.getString(1)%>"><%=rs.getString(1)%> </option>
        				<% } %>
        				
                   
                </select></div>
                
                
                <div class="form-group">
                <label for="position"> Choose Position:</label>
                <select id="position" name="position" required>
                   <option value="Sales Representative">Sales Representative</option>
                    <option value="Operations Manager">Operations Manager</option>
                    <option value="Financial Analyst">Financial Analyst</option>
                    <option value="HR Manager">HR Manager</option>
                    <option value="Marketing Manager">Marketing Manager</option>
                </select></div>
                
            <div class="form-group">
                <label for="date">Salary :</label>
                <input type="text" id="salary" name="salary" >
            </div>
            
            
    
            
            
            
            
                <button type="submit" style="--color: #cfbab6; position:absolute; left:71%; top:97%" ><span>Add Employee</span><i></i></button>
            
        </form>
              </div>
             </div> 
     		
          
        
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