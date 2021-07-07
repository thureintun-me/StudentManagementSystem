<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(USR001) User Search </title>
<link rel="stylesheet" type="text/css" href="stylesheets/container.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/base.css" />
<script type="text/javascript" src="JavaScript/general.js" ></script>
<script type="text/javascript" src="JavaScript/accordion-menu.js" ></script>
<script type="text/javascript">
	window.onload=function()
    {
    	menu();

        var param = getPara( 'flag');
        if(param==1)
        {
            document.getElementById('list').style.display="block";           
        }
        else
        {
            document.getElementById('list').style.display="none";
        }
    }

    function searchList(flag)
    {
        if(flag==1){
             document.getElementById('list').style.display="block";
        
        }else{
            document.getElementById('list').style.display="none";
           
        }
    }
	function resetForm()
	{
		document.getElementById('message').innerHTML = "Message";
		document.getElementById('list').style.display="none";
	}

	function checkDelete()
    {
        var con = confirm("Are you sure to delete?");
        if(con)
        {
            window.location.replace('USR001.html?flag=1')
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
				<h3>User Search</h3>
				<form action="SearchServlet">
				<table class="tableForm">
					<tr>
						<td class="tblLabel"><label>User ID</label></td>
						<td class="tblInputNormal"><input type="text" id="txtUserId" name="id" class="txt" />	</td>
	
						<td class="tblLabel">User Name	</td>
						<td class="tblInputNormal"><input type="text" id="txtUserName" class="txt" name="name"  />	　</td>
						
					</tr>
				</table>
				<br/>
				
				<input type="submit"  value="Search" onClick="searchList(1)" class="button"/>
				<a href="UserRegister.jsp">
                    <input type="button" value="Add" class="button" id="userInsert" />
                 </a>
				<input type="button"  value="Reset" onClick="resetForm()" class="button"/>
				</form>
				<br/>
				<br/>	
				<div id="errormsg">
					<label id="message">message</label>
				</div>
			</div>   

                <br/><br/><br/>
                <jsp:useBean id="users" class="com.thurein.dto.UserResponseDTO" scope="request"></jsp:useBean>
                
			<div id="list">
				<form name="listForm" >
					<table class="">
						<tr class="tblHeader">
							<th width="1%">Delete</th>
							<th width="1%">Update</th>
							<th width="12%">User ID</th>
							<th width="24%">User Name</th>
							
						</tr>
						<tr>
						 	<td>
						 		<a href="DeleteUserServlet?id=${users.id }">
						 				
						 				<input type="button" value="Delete"  id="delete" class="button" onClick="javascript:checkDelete()" />
						 		</a>
                             	
                            </td>
							<td>
								<a href="UpdateUser.jsp?id=${users.id }&name=${users.name}&password=${users.password}">
                            		<input type="button" value="Update" class="button" id="userUpdate" />
                        		</a>
                        	</td>
                           	
							<td>${users.id }</td>
							<td>${users.name}</td>                
						</tr>
						
						
						
					</table>
				</form>
			</div>    

            </div>
            </div>
                
            </div> 
            <div class="footer"> 
            <span>Copyright &#169; ACE Inspiration 2016</span>        
    </div>
     </div>
</body>
</html>