<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="com.thurein.dto.StudentResponseDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(BUD001)Student Search</title>
<link rel="stylesheet" type="text/css" href="stylesheets/container.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/base.css" />
<script type="text/javascript" src="JavaScript/general.js" ></script>
<script type="text/javascript" src="JavaScript/accordion-menu.js" ></script>
<script type="text/javascript">
    window.onload=function()
    {
        menu();
        var param = getPara('flag');
        if(param==1)
        {
            document.getElementById('list').style.display="none";           
        }
        else if(param==2)
        {
            document.getElementById('list').style.display="block";
        }      

    }
    function changeName()
    {
        var ascName = document.getElementById('ascName').style.display;
        var dscName = document.getElementById('dscName').style.display;
        if(ascName == 'none')
        {
            document.getElementById('ascName').style.display = 'inline';
            document.getElementById('dscName').style.display= 'none';
        }
        else if(ascName == 'inline')
        {
            document.getElementById('ascName').style.display = 'none';
            document.getElementById('dscName').style.display= 'inline';
        }
    }
    function searchList()
    {
        document.getElementById('list').style.display="block";
    }

    function resetForm()
    {
        document.getElementById('message').innerHTML = "Message";
        document.getElementById('list').style.display="none";
    }

   
</script>
</head>
<body class="main_body">

	
	<div id="header">
        <div id="title">
            <a href="M00001.html">Student Registration Assignment</a>
        </div>
          <div id="menuLoginTime">
            <table>
                <tr>
                    <td>User</td><td>: ${sessionScope.myId}  ${sessionScope.myName }</td>
                </tr>
                <tr>
                    <td>Current Date</td><td>:  ${sessionScope.myDate }</td>
                </tr>
            </table>
        </div>
        <input id="btn_logout" class="button" type="submit" value="Logout" onclick="location.href='LogoutServlet'"> 
    </div>

    <div id="container"> 
            <div id="left_menu">
                 <div><a href="StudentRegister.jsp">Student Registration</a></div> 
              <div> <a href="StudentSearch.jsp">Student Search</a></div>
               
                <div><a href="ClassRegister.jsp">Class Registration</a></div>
				<div><a href="UserSearch.jsp">User Management</a></div>
            </div>
            <div id="main_contents">     
                <div id="contents">
                    <div class="search_form">
                        <h3>Student Search Page</h3>
                    <form action="SearchStudentServlet" method="post">
                        <table class="tableForm">
                            <tr>
                                <td class="tblLabel">Student No.</td>                       
                                <td class="tblInputShort"><input type="text" name="id" value="" class="txt" />  </td>
                                <td class="tblLabel">Student Name</td>  
                                <td class="tblInputShort">
                                <input type="text" name="name" value="" class="txt"/></td>
                            <tr/> 
                            <tr>
                                <td class="tblLabel">Class Name</td> 
                                <td class="tblInputNormal" colspan="3"><input type="text" name="class" id="companyName" value="" class="txtlong"/></td>   
                            </tr>                                        
                        </table>
                        <br/> 
                            <input type="submit"  value="Search" onClick="searchList()" class="button"/>
                            <input type="button"  value="Reset" onClick="resetForm()" class="button"/>
                        <br/><br/>
                            <div id="errormsg">
                                <label id="message">Message</label>
                            </div>  
                    </form>
            <div id="list">
          
                <form name="listForm"  >
                    <Br/><Br/>
                     
                    <br />
                    <table class="">
                        <tr class="tblHeader">
                            <th width="5%">No</th>
                            <th width="10%">Student No</th>
                            <th width="25%">Student Name</th>
                            <th width="40%">Class Name</th>
                            <th width="10%">Registered Date</th>
                            <th width="10%">Status</th>
                        </tr>
                      
                      <c:choose>
                      
                      	<c:when test=" ${empty requestScope.list}">
                      	
                      	    
                      	</c:when>
                      	<c:otherwise>
                      	 <c:forEach var="myStudent" items="${requestScope.list}">
                        	<tr>
                            <td>
                            
                         
      						 </td>
                            <td>${myStudent.studentId } </td>
                            <td><a href="UpdateStudent.jsp?id=${myStudent.studentId }&name=${myStudent.studentName }">
                            ${myStudent.studentName }</a></td>
                            <td>${myStudent.className }</td>
                            <td>${myStudent.registerDate } </td>
                            <td>${myStudent.status }</td>
                        </tr>
                        </c:forEach>
                      	
                      	</c:otherwise>
                      	
                      </c:choose>
                       
                       <tr>
                            <td> </td>
                            <td>${student.studentId } </td>
                            <td><a href="UpdateStudent.jsp?id=${student.studentId }&name=${student.studentName }">${student.studentName }</a></td>
                            <td>${student.className }</td>
                            <td>${student.registerDate } </td>
                            <td>${student.status }</td>
                       
                      	</tr>

            
                    </table>
                    <br/>
                    
                </form>
            </div> 
                    </div>   
                </div>  
            </div>
            
     </div>

    <div class="footer"> 
            <span>Copyright &#169; ACE Inspiration 2016</span>        
    </div>
</body>
</html>