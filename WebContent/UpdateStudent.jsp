<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="com.thurein.dao.ClassDao" %>
     <%@page import="com.thurein.dto.ClassResponseDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(BUD002)Student Update</title>
<link rel="stylesheet" type="text/css" href="stylesheets/container.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/base.css" />
<script type="text/javascript" src="JavaScript/general.js" ></script>
<script type="text/javascript" src="JavaScript/accordion-menu.js" ></script>
<script type="text/javascript">
     window.onload=function()
    {
        menu();  
    }

    function deleteBudget()
    {
        var isOk= confirm("Are you sure to delete?");
        if(isOk)
        {
            window.location.replace('BUD001.html?flag=2')  
        }
    }

    function update()
    {
        var con = confirm("Are you sure to update?");
        if(con)
        {
            window.location.replace('BUD001.html?flag=2')
        }
        
    }
    
    function showMessage(){     
        var message = confirm("Are you sure to register?");
        if(message)                 
        document.getElementById('errormsg').innerHTML = "Registration completed.";    
    }
    
    function addListData(source,destination)
    {
        var sourceList=document.getElementById(source.id);
        var sourceSelect=sourceList.selectedIndex;
        
        var len=sourceList.length;
        
        if(sourceSelect!=-1)
        {
            for(i=0;i<len;i++)
            {
                var isExist = false;
                var sourceText=sourceList.options[i].text;
                var destinationList=document.getElementById(destination.id);
                if(sourceList[i].selected)
                {
                    for(var j=0;j<destinationList.length;j++)
                    {
                        if(destinationList.options[j].text == sourceText)
                        {
                            isExist = true;
                        }
                    }
                    if(!isExist)
                    {
                        destinationList.options[destinationList.length]=new Option(sourceText,"0");     
                    }
                }
            }           
        }
    }
    function delListData(source)
    {
        var sourceList=document.getElementById(source.id);
        for(var index=0;index<sourceList.length;index++){   
            if (sourceList[index].selected) {
                sourceList.remove(index);
                delListData(source);
            }
        }
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
                    <  <td>User</td><td>: ${sessionScope.myId}  ${sessionScope.myName }</td>
                </tr>
                <tr>
                    <td>Current Date</td><td>:    <td>User</td><td>:   ${sessionScope.myDate }</td></td>
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
                    <h3>Student Update</h3>
                    <label id="errormsg"> Message </label><br/><br/><br/>
                    <form action="UpdateStudentServlet" method="post">
                    <table class="tableForm">
                        <tr height="30px">
                            <td class="tblSingleLabel">Student No.</td>
                            <td class="tblSingleInput"><input type="text" name="id" value="${param.id }" class="txtlong" /></td>
                        </tr>
                        <tr>
                            <td class="tblSingleLabel">Student Name *</td>
                            <td class="tblSingleInput">
                            <input type="text" name="name" value="${param.name }" class="txtlong" />
                        </tr>
                        <tr>
                            <td class="tblSingleLabel">Class Name *</td>
                            <td class="tblSingleInput">  
                                  <%
  					ArrayList<ClassResponseDTO> dto = new ArrayList<>();
  					ClassDao dao = new ClassDao();
					dto = dao.selectAll();
					request.setAttribute("classes", dto);
	
 							 %>
  				 <select id="expenseType" name="myclass" class="normal_sel">
   				<c:forEach var="data" items="${requestScope.classes }">
   	
   	
   	
     
     		 	 <option><c:out value="${data.name}"/></option>
         	 </c:forEach>
         
      			</select>  
                            </td>                  
                        </tr>
                        <tr>
                            <td class="tblSingleLabel">Registered Date	 *</td>
                            <td class="tblSingleInput">  
                                <select id="expenseType" class="short_sel" name="year">
                                   <option>Year</option>
                                   <option>2016</option>
                                   <option>2015</option>
                                   <option>2014</option>
                                   <option>2013</option>
                                   <option>2012</option>
                                   <option>2011</option>
                                   <option>2010</option>
                                   <option>2009</option>
                                </select>  
								<select id="expenseType" class="short_sel" name="month">
                                   <option>Month</option>
                                   <option>01</option>
                                   <option>02</option>
                                   <option>03</option>
                                   <option>04</option>
                                   <option>05</option>
                                   <option>06</option>
                                   <option>07</option>
                                   <option>08</option>
                                   <option>09</option>
                                   <option>10</option>
                                   <option>11</option>
                                   <option>12</option>
                                </select> 
								<select id="expenseType" class="short_sel" name="day">
                                   <option>Day</option>
                                   <option>01</option>
                                   <option>02</option>
                                   <option>03</option>
                                   <option>04</option>
                                   <option>05</option>
                                   <option>06</option>
                                   <option>07</option>
                                   <option>08</option>
                                   <option>09</option>
                                   <option>10</option>
                                   <option>11</option>
                                   <option>12</option>
                                   <option>13</option>
                                   <option>14</option>
                                   <option>15</option>
                                   <option>16</option>
                                   <option>17</option>
                                   <option>18</option>
                                   <option>19</option>
                                   <option>20</option>
                                   <option>21</option>
                                   <option>22</option>
                                   <option>23</option>
                                   <option>24</option>
                                   <option>25</option>
                                   <option>26</option>
                                   <option>27</option>
                                   <option>28</option>
                                   <option>29</option>
								   <option>30</option>
                                   <option>31</option>
                                </select> 
                            </td>                  
                        </tr>
                        <tr>
                            <td class="tblSingleLabel">Status *</td>
                            <td class="tblSingleInput">
                                <select id="expenseType" name="status" class="normal_sel">
                                    <option></option>
                                    <option>Attending</option>
                                    <option>Passed</option>
                                    <option>Failed</option>
                                </select>
                            </td>
                        </tr>
                    </table>
                    <br/>
                    <div id="btnGroup">
                        <input type="submit" value="Update" class="button" onClick="javascript:update()"/>
                        <a href="DeleteStudentServlet?id=${param.id }">
                        	 <input type="button" value="Delete" id="delete" class="button" onClick="javascript:deleteBudget()" />
                        
                        </a>
                       <a href="StudentSearch.jsp">
                       	<input type="button" value="Back" class="button" onClick="window.location.replace('')"/>  
                       </a>
                              
                    </div>
                    </form>
                </div> 
            </div>
        </div>    
     </div>

    <div class="footer"> 
            <span>Copyright &#169; ACE Inspiration 2016</span>        
    </div>
</body>
</html>