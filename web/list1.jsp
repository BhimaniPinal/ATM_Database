<%-- 
    Document   : listView1
    Created on : 18 Apr, 2018, 9:56:53 PM
    Author     : PINAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center> 
     <div class="continer">
        <div >
            
            <h2  >WelCome Account Holder</h2>
            <center><h1>
                        <%
                           out.print( request.getParameter("name"));
                        %>
                </h1>
            </center>  
           
        </div>
     </div>
    </center>
     </br>
        
      <div align="center" >
        <div  class="btn-group btn-group-lg" role="group" aria-label="...">
            <form action="deposite.html">
                 <input class="btn btn-primary" type="button" value="Deposite">
            </form>
            </br>
            <form action="withdrow.html">
                 <input class="btn btn-primary" type="submit" value="Withdrow">
            </form>
                        </br>

            <form action="view.html">
                 <input class="btn btn-primary" type="submit" value="View Account Detail" >
            </form>
         </div>
        </div>
   
    </body>
</html>
