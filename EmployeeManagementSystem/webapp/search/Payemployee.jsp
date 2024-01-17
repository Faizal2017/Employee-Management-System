<%@page import="com.db.util.DBConnection"%>
<%@ page import="java.sql.*" %>
<style>
.table-container {
    width: 100%;
    overflow-x: auto;
    max-height: 300px; 
}

table {
    width: 100%;
    border-collapse: collapse;
}

th, td {
    padding: 8px 12px;
    text-align: left;
}

th {
    position: sticky;
    top: 0;
    z-index: 2;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

th:first-child {
    left: 0;
    z-index: 1;
}

th, td {
    white-space: nowrap; 
}
</style>
<%
String search = request.getParameter("query");

String query , query1;
if(search != null && !search.isEmpty()) {
    search = search.replace("'", "''");
    query = "SELECT * FROM permenant_employee WHERE EmpId LIKE '%" + search + "%' OR Name LIKE '%" + search + "%'";
    query1 = "SELECT * FROM temporary_employee WHERE EmpId LIKE '%" + search + "%' OR Name LIKE '%" + search + "%'";
} else {
    query = "SELECT * FROM permenant_employee;";
    query1 = "SELECT * FROM temporary_employee;";
}

Connection connect = null;
Statement statement = null;
ResultSet resultSet = null;
ResultSet resultSet1 = null;
int i = 1;
int count = 1;
try {
    
DBConnection DBcon =DBConnection.getInstance();
	
	connect = DBcon.createconnection();
    statement = connect.createStatement();
    resultSet = statement.executeQuery(query);

    
%>
        <div class="row">
            <div class="col-sm-12">
            <div class="table-container" >
          <table class="table table-striped" id="dataTable"  cellspacing="0" role="grid" aria-describedby="dataTable_info"  >
          <thead>
            <tr role="row" class="table-warning">
              <th class="sorting_asc"  style="width: 10.2px;">#</th>
              <th class="sorting" style="width: 74.2px;">EmpID</th>
              <th class="sorting" style="width: 50.2px;">Employee Name</th>
              <th class="sorting" style="width: 58.2px;">Action</th>
          </thead>
          <tbody>
<%			
		 
		while(resultSet.next()) {
			count = 0;
%>
                <tr role="row" class="odd">
                <td class="align-middle sorting_1"><%=i++ %></td>
                <td class=" align-middle"><%=resultSet.getString("EmpId") %></td>
                <td class=" align-middle"><%=resultSet.getString("Name") %></td>
                <td class="align-middle text-center">
                  <a href="MakePaymentServelet?empID=<%=resultSet.getString("EmpId") %>" class="btn btn-info btn-circle">
                    <span class="icon text-white" title="Edit">
                      PAY
                    </span>
                  </a>
                </td>
            </tr>
<%
        }
		resultSet1 = statement.executeQuery(query1);
		while(resultSet1.next()) {
			count = 0;
	%>
			                <tr role="row" class="odd">
                <td class="align-middle sorting_1"><%=i++ %></td>
                <td class=" align-middle"><%=resultSet1.getString("EmpId") %></td>
                <td class=" align-middle"><%=resultSet1.getString("Name") %></td>
                <td class="align-middle text-center">
                  <a href="MakePaymentServelet?empID=<%=resultSet1.getString("EmpId") %>" class="btn btn-info btn-circle">
                    <span class="icon text-white" title="Edit">
                      PAY
                    </span>
                  </a>
                </td>
            </tr>
			<%
			        }
%>
           </tbody>
        </table></div>
      </div></div>
<%	
	if(count == 1) {  %>
        	
    		<tr role="row" class="odd">
                <td colspan="5" ><h2 style="color: #433633; font-family: 'Poppins', sans-serif; text-align:center;">NO RESULTS FOUND !!!</h2> </td>
            </tr>
    <%  }
} catch(Exception e) {
    e.printStackTrace();
} finally {
    if(resultSet != null) try { resultSet.close(); } catch(SQLException ignore) {}
    if(resultSet != null) try { resultSet1.close(); } catch(SQLException ignore) {}
    if(statement != null) try { statement.close(); } catch(SQLException ignore) {}
    if(connect != null) try { connect.close(); } catch(SQLException ignore) {}
}
%>
