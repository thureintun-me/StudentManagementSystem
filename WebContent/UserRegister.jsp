<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(USR002)User Register</title>
<link rel="stylesheet" type="text/css" href="stylesheets/container.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/base.css" />
<script type="text/javascript" src="JavaScript/general.js" ></script>
<script type="text/javascript" src="JavaScript/accordion-menu.js" ></script>
<script type="text/javascript">
    window.onload=function()
    {
        menu();     

    }
	
	function insert()
    {
        var con = confirm("Are you sure to register?");
        
       
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
                    <td>Current Date</td><td>:  ${sessionScope.myId}</td>
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
        <div id="main_contents"> 
			<div id="contents">
				<h3>User Register</h3>
				<label id="errormsg" ><%= request.getAttribute("error") %>   </label><br/><br/><br/>

				<form action="AddUserServlet" method="post">
					<table class="tableForm">
						<tr>
							<td class="tblSingleLabel"> User ID *</td>
							<td class="tblSingleInput"><input type="text" name="id" id="txtUserId" class="txt_popup" /></td>
						</tr>
						<tr>
							<td class="tblSingleLabel">User Name</td>
							<td class="tblSingleInput"><input type="text" name="name" class="txtlong_popup" id="txtUserName" /></td>              
						</tr>
						<tr>
							<td class="tblSingleLabel">Password *</td>
							<td class="tblSingleInput"><input type="password" name="password" class="txtlong_popup" id="txtUserName" /></td>              
						</tr>
						<tr>
							<td class="tblSingleLabel">Confirm Password *</td>
							<td class="tblSingleInput"><input type="password" name="confirmPass" class="txtlong_popup" id="txtUserName" /></td>              
						</tr>
	 
					</table>
					<br/>
								
					<input type="submit" value="Register" class="button" onClick="javascript:insert()"/>
				</form>

				<br/><br/><br/>
			</div>
        </div>
            
    </div>

    <div class="footer"> 
            <span>Copyright &#169; ACE Inspiration 2016</span>        
    </div>
</body>
</html>