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
    query = "SELECT * FROM leaverequest lq , permenant_employee pe where pe.Empid = lq.EmpId AND Status='Pending' AND (pe.EmpId LIKE '%" + search + "%' OR pe.Name LIKE '%" + search + "%') ";
	query1 = "SELECT * FROM leaverequest lq , temporary_employee te where te.Empid = lq.EmpId AND Status='Pending' AND (te.EmpId LIKE '%" + search + "%' OR te.Name LIKE '%" + search + "%') ";
} else {
	query = "SELECT * FROM leaverequest lq , permenant_employee pe where pe.Empid = lq.EmpId AND Status='Pending' ";
	query1 = "SELECT * FROM leaverequest lq , temporary_employee te where te.Empid = lq.EmpId AND Status='Pending' ";
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
              <th class="sorting_asc"  style="width: 5%;">#</th>
              <th class="sorting" style="width: 10%;">Request ID</th>
              <th class="sorting" style="width: 10%;">Emp ID</th>
              <th class="sorting" style="width: 10%;">Name</th>
              <th class="sorting" style="width: 10%;">Department</th>
              <th class="sorting" style="width: 10%;">From </th>
              <th class="sorting" style="width: 10%;">Days</th>
              <th class="sorting" style="width: 10%;">Title</th>
              <th class="sorting" style="width: 20%;">Description</th>
              <th class="sorting" style="width: 40%;">Approve/Deny</th></tr>
          </thead>
          <tbody>
<%			
		 
		while(resultSet.next()) {
			count = 0;
%>
                <tr role="row" class="odd">
                <td class="align-middle sorting_1"><%=i++ %></td>
                <td class=" align-middle"><%=resultSet.getString("ReqId") %></td>
                <td class=" align-middle"><%=resultSet.getString("EmpId") %></td>
                <td class=" align-middle"><%=resultSet.getString("Name") %></td>
                <td class=" align-middle" style="text-align:center;"><%=resultSet.getString("Department") %></td>
                <td class=" align-middle"><%=resultSet.getString("FromDate") %></td>
                <td class=" align-middle"><%=resultSet.getInt("Days") %></td>
                <td class=" align-middle"><%=resultSet.getString("Title") %></td>
                <td class=" align-middle"><%=resultSet.getString("Description") %></td>
                <td class="align-middle text-center">
                  <a href="ApproveLRServelet?RqID=<%=resultSet.getString("ReqID")%>" class="btn btn-info btn-circle" onclick="return confirm('Do you Want to Aprove ?')">
                    <span class="icon text-white" title="Edit">
                      <i class="fa-solid fa-check"></i>
                    </span>
                  </a> |
                  <a href="DeleteLRServelet?RqID=<%=resultSet.getString("ReqID")%>" class="btn btn-danger btn-circle" onclick="return confirm('Do you Want to Deny ?')">
                    <span class="icon text-white" title="Delete">
                      <i class="fa-solid fa-xmark"></i>
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
                <td class=" align-middle"><%=resultSet1.getString("ReqId") %></td>
                <td class=" align-middle"><%=resultSet1.getString("EmpId") %></td>
                <td class=" align-middle"><%=resultSet1.getString("Name") %></td>
                <td class=" align-middle" style="text-align:center;"><%=resultSet1.getString("Department") %></td>
                <td class=" align-middle"><%=resultSet1.getString("FromDate") %></td>
                <td class=" align-middle"><%=resultSet1.getInt("Days") %></td>
                <td class=" align-middle"><%=resultSet1.getString("Title") %></td>
                <td class=" align-middle"><%=resultSet1.getString("Description") %></td>
                <td class="align-middle text-center">
                  <a href="ApproveLRServelet?RqID=<%=resultSet1.getString("ReqID")%>" class="btn btn-info btn-circle" onclick="return confirm('Do you Want to Aprove ?')">
                    <span class="icon text-white" title="Edit">
                      <i class="fa-solid fa-check"></i>
                    </span>
                  </a> |
                  <a href="DeleteLRServelet?RqID=<%=resultSet1.getString("ReqID")%>" class="btn btn-danger btn-circle" onclick="return confirm('Do you Want to Deny ?')">
                    <span class="icon text-white" title="Delete">
                      <i class="fa-solid fa-xmark"></i>
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
                <td colspan="5" ><h2 style="color: #433633; font-family: 'Poppins', sans-serif; text-align:center;">NO REQUEST FOUND !!!</h2> </td>
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
