<%@page import="com.db.util.DBConnection"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.time.LocalDate" %>
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
LocalDate currentDate = LocalDate.now();
String query , query1;
if(search != null && !search.isEmpty()) {
    search = search.replace("'", "''");
    query = "select e.EmpId, e.Name, e.Department, t.TrainingName from permenant_employee e left outer join assaign_training t ON e.EmpId=t.EmpID where e.EmpId LIKE '%" + search + "%' OR e.Name LIKE '%" + search + "%'";
} else {
	query = "select e.EmpId, e.Name, e.Department, t.TrainingName from permenant_employee e left outer join assaign_training t ON e.EmpId=t.EmpID";
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
            <tr role="row" class="table-warning" style="width:100%">
              <th class="sorting_asc"  style="width: 5%;">#</th>
              <th class="sorting" style="width: 5%;">EmpID</th>
              <th class="sorting" style="width: 10%;">Name</th>
              <th class="sorting" style="width: 5%;">Department</th>
              <th class="sorting" style="width: 10%; ">Training Name</th>
              <th class="sorting" style="width: 10%;">actions</th></tr>
          </thead>
          <tbody>
<%			
		 
		while(resultSet.next()) {
			count = 0;
%>

                <tr role="row" class="odd" style="width:100%">
                <td class="align-middle sorting_1"><%=i++ %></td>
                <td class=" align-middle"><%=resultSet.getString(1) %></td>
                <td class=" align-middle"><%=resultSet.getString(2) %></td>
                <td class=" align-middle"><%=resultSet.getString(3) %></td>
                <%  if(resultSet.getString(4)!= null ) { %>
                <td class=" align-middle"><%=resultSet.getString(4) %></td>
                <% } 
                        else {%>
                <td class="align-middle text-center">
                  <a href="AssignTraining.jsp?id=<%=resultSet.getString(1) %>" class="btn btn-info btn-circle" onclick="return confirm('Do you Want to Aprove ?')">
                    <span class="icon text-white" title="Edit">
                      Assign
                    </span>
                  </a> </td><%} %> <td>
                  <a href="RemoveTrainingServlet?Id=<%=resultSet.getString(1)%>" class="btn btn-danger btn-circle" onclick="return confirm('Do you Want to Deny ?')">
                    <span class="icon text-white" title="Delete">
                      Remove
                    </span>
                  </a>
                </td>
            </tr>
<%
        }
			%>
			                
           </tbody>
        </table>
        
        </div>
        
      </div></div>
<%	
	if(count == 1) {  %>
        	
    		<tr role="row" class="odd">
                <td colspan="5" ><h2 style="color: #433633; font-family: 'Poppins', sans-serif; text-align:center;">NO EMPLOYEE FOUND !!!</h2> </td>
            </tr>
    <%  }
} catch(Exception e) {
    e.printStackTrace();
} finally {
    if(resultSet != null) try { resultSet.close(); } catch(SQLException ignore) {}
    if(statement != null) try { statement.close(); } catch(SQLException ignore) {}
    if(connect != null) try { connect.close(); } catch(SQLException ignore) {}
}
%>
