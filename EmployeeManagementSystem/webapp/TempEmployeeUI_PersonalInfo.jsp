<%@page import="com.dao.DisplayDetails"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%	
  	
  	ResultSet rs = DisplayDetails.DisplayTempEmp("T0001");
  
  	%><!DOCTYPE html>
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
    <title>Personal Information</title>
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
    <div class="title" style="margin: 7% 0 0 31%;"><h1><b>Personal Details</b></h1></div>
    <div class="card-body1" style="padding: 1.5rem;" >

					      <div >
					            <ul >
					                <li>

                                <div class="row">
                                    <div class="col-md-5 col-5">
                                        <i class="fa fa-thumb-tack" aria-hidden="true"></i>
                                        <strong style = "color: #433633 "class="margin-10px-left text-orange">Employee ID</strong>
                                    </div>
                                    <div class="col-md-7 col-7">
                                        <p style = "color: #433633">: <%=rs.getString("EmpId")%></p>
                                    </div>
                                </div>

                            </li>
                            <li>

                                <div class="row">
                                    <div class="col-md-5 col-5">
                                        <i class="fa fa-thumb-tack" aria-hidden="true"></i>
                                        <strong style = "color: #433633 "class="margin-10px-left text-orange">Full Name</strong>
                                    </div>
                                    <div class="col-md-7 col-7">
                                        <p style = "color: #433633">: <%=rs.getString("Name")%></p>
                                    </div>
                                </div>

                            </li>
                            <li>

                                <div class="row">
                                    <div class="col-md-5 col-5">
                                        <i class="fa fa-thumb-tack" aria-hidden="true"></i>
                                        <strong style = "color: #433633 "class="margin-10px-left text-orange">Date Of Birth</strong>
                                    </div>
                                    <div class="col-md-7 col-7">
                                        <p style = "color: #433633">: <%=rs.getString("DOB")%></p>
                                    </div>
                                </div>

                            </li>
                            <li>

                                <div class="row">
                                    <div class="col-md-5 col-5">
                                        <i class="fa fa-thumb-tack" aria-hidden="true"></i>
                                        <strong style = "color: #433633 "class="margin-10px-left text-orange">Gender</strong>
                                    </div>
                                    <div class="col-md-7 col-7">
                                        <p style = "color: #433633">: <%=rs.getString("Gender")%></p>
                                    </div>
                                </div>

                            </li>
                            <li>

                                <div class="row">
                                    <div class="col-md-5 col-5">
                                        <i class="fa fa-thumb-tack" aria-hidden="true"></i>
                                        <strong style = "color: #433633 "class="margin-10px-left text-orange">Address</strong>
                                    </div>
                                    <div class="col-md-7 col-7">
                                        <p style = "color: #433633">: <%=rs.getString("Address")%></p>
                                    </div>
                                </div>

                            </li>
                            <li>

                                <div class="row">
                                    <div class="col-md-5 col-5">
                                        <i class="fa fa-thumb-tack" aria-hidden="true"></i>
                                        <strong style = "color: #433633 "class="margin-10px-left text-orange">Email</strong>
                                    </div>
                                    <div class="col-md-7 col-7">
                                        <p style = "color: #433633">: <%=rs.getString("Email")%></p>
                                    </div>
                                </div>

                            </li>
                            <li>

                                <div class="row">
                                    <div class="col-md-5 col-5">
                                        <i class="fa fa-thumb-tack" aria-hidden="true"></i>
                                        <strong style = "color: #433633 "class="margin-10px-left text-orange">Phone</strong>
                                    </div>
                                    <div class="col-md-7 col-7">
                                        <p style = "color: #433633">: <%=rs.getString("Phone")%></p>
                                    </div>
                                </div>

                            </li>
                            <li>

                                <div class="row">
                                    <div class="col-md-5 col-5">
                                        <i class="fa fa-thumb-tack" aria-hidden="true"></i>
                                        <strong style = "color: #433633 "class="margin-10px-left text-orange">Department</strong>
                                    </div>
                                    <div class="col-md-7 col-7">
                                        <p style = "color: #433633">: <%=rs.getString("Department")%></p>
                                    </div>
                                </div>

                            </li>
                            <li>

                                <div class="row">
                                    <div class="col-md-5 col-5">
                                        <i class="fa fa-thumb-tack" aria-hidden="true"></i>
                                        <strong style = "color: #433633 "class="margin-10px-left text-orange">Position</strong>
                                    </div>
                                    <div class="col-md-7 col-7">
                                        <p style = "color: #433633">: <%=rs.getString("Position")%></p>
                                    </div>
                                </div>

                            </li>
                            <li>

                                <div class="row">
                                    <div class="col-md-5 col-5">
                                        <i class="fa fa-thumb-tack" aria-hidden="true"></i>
                                        <strong style = "color: #433633 "class="margin-10px-left text-orange">Date Joined</strong>
                                    </div>
                                    <div class="col-md-7 col-7">
                                        <p style = "color: #433633">: <%=rs.getString("DateJoined")%></p>
                                    </div>
                                </div>

                            </li>
                            
                            
                            </ul>
        
      
            
    

    </div></div></div></div><%} %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
    <script src="script.js"></script>
  </body>
</html>


  