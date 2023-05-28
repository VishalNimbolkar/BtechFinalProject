<%@page import="com.algorithms.StopWords"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.connection.ConnectionUtils"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet" %>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0); // Proxies.
if(session!=null){
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Depression Intensity Estimation via Social Media : A Deep Learning Approach</title>
    <!-- The styles -->
    <link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="css/charisma-app.css" rel="stylesheet">
    <link href='bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='css/jquery.noty.css' rel='stylesheet'>
    <link href='css/noty_theme_default.css' rel='stylesheet'>
    <link href='css/elfinder.min.css' rel='stylesheet'>
    <link href='css/elfinder.theme.css' rel='stylesheet'>
    <link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='css/uploadify.css' rel='stylesheet'>
    <link href='css/animate.min.css' rel='stylesheet'>
	<link href='css/own.css' rel='stylesheet'>
    <!-- jQuery -->
    <script src="bower_components/jquery/jquery.min.js"></script>
	<script src="validation.js"></script>
    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- The fav icon -->
    <link rel="shortcut icon" href="img/favicon.ico">

</head>

<body>
    <!-- topbar starts -->
    <div class="navbar navbar-default" role="navigation">

        <div class="navbar-inner">
            <button type="button" class="navbar-toggle pull-left animated flip">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="home.jsp"> 
                <span>Social Media</span></a>
			<h2 style="color:white" class="collapse navbar-collapse nav navbar-nav top-menu" align="center">Depression Intensity Estimation via Social Media : A Deep Learning Approach</h2>
           
           	<!-- user dropdown starts -->
            <div class="btn-group pull-right">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"></span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="user_changepassword.jsp">Change Password</a></li>
                    <li><a href="user_profile.jsp">Profile</a></li>
                    <li class="divider"></li>
                    <li><a href="UserLogoutController">Logout</a></li>
                </ul>
            </div>
            <!-- user dropdown ends -->


        </div>
    </div>
    <!-- topbar ends -->
    
   		<%
			String emailMsg = (String)session.getAttribute("emailMsg");
   			Object uId = session.getAttribute("userId");
			int userId = Integer.parseInt(uId.toString());	
            String name=(String)session.getAttribute("User");
			if(name!=null && name!=""){
		%>
                                
<div class="ch-container">
    <div class="row">
        
        <!-- left menu starts -->
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <div align="center"><br><img alt="Profile Pic" class="img-circle" src="profilepic.jsp?id=<%=userId %>"  width="150px" height="100px"/>
                    <br>
                    <div>Welcome <strong><%=name %>,</strong></div>
        <%} %>
                    </div>
                <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">Main</li>
                        <li><a class="ajax-link" href="user_home.jsp"><i class="glyphicon glyphicon-home"></i><span> Home</span></a>
                        </li>
                                    
                                    <li><a class="ajax-link" href="FacebookToken.jsp"><i
                                    class="glyphicon glyphicon-user"></i><span> Collect Facebook Data</span></a></li>
                                    
                                    <li><a class="ajax-link" href="RealtimeData.jsp"><i
                                    class="glyphicon glyphicon-user"></i><span> Facebook/Instagram Posts Classification</span></a></li>
                                    
                                    
                        
                    </ul>
                    
                </div>
            </div>
        </div>
        <!--/span-->
        <!-- left menu ends -->
         <%
String action="stemming";
%>
        <div class="row well col-md-offset-4 col-md-8 center">
            <div >
                 <div class=" col-md-3">
		            <div class="row">
		               <div>
						      
						   <div>
						     
						      <div class="col-xs-1">
						      <br><br><br>
						          <a href="user_home.jsp"><button type="button" class="btn btn-primary" style="width:140px">HOME</button><br></a>
						          <br>
							      <a href="PreprocessingFB?action=<%=action%>"><button type="button" class="btn btn-primary" style="width:140px">Stemming</button></a><br>
							      <br>
							     
							      <a href=""><button type="button" class="btn btn-primary" style="width:140px">Classification</button></a><br>
							      <br>
							      <a href=""><button type="button" class="btn btn-primary" style="width:140px">Prediction</button></a><br>
							      <br>
							      <br>
							  </div>			
						   </div>
						</div>
						
					</div>
		               
		        </div>
                </div>
                
            	            <div class="row">
		               <div class = "panel panel-default">
						   <div class = "panel-body" >
						     <div class="col-xs-1" >
						     <h3 > Message </h3>
						     <div style='overflow:scroll; width:635px;height:500px;text-align: justify;' class="rounded" >
		<%
	ArrayList<String> stopwordstr = new ArrayList<String>();
	stopwordstr =(ArrayList<String>)session.getAttribute("tokenisedString");
	ArrayList<String> stopwordresult = new ArrayList<String>();
	for(int k=0;k<stopwordstr.size();k++)
    {
    	StopWords stop=new StopWords();
    	String result=stop.remove(stopwordstr.get(k));
    	if(result!=null&&result!="")
    	stopwordresult.add(result);
    }
	session.setAttribute("msg_stopwordresult", stopwordresult);
	
	/*Iterator litr = stopwordresult.iterator();

	 while(litr.hasNext()) 
	 {
	    out.println(litr.next());*/
	    %>
	   
	    <%/*
	 }*/
	out.println(stopwordresult);
	 session.setAttribute("reply_stopwordresult", stopwordresult);
	
        %>
               
						</div>	
						
						</div>			
						   </div>
						</div>
						
					</div>
            </div>
            
        </div>

        

        </div>
       
 
         

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<hr>

    

    <footer class="row">
        <p class="col-md-9 col-sm-9 col-xs-12 copyright">&copy; <a href="#" target="_blank"></a> 2019 - 2020</p>

        <p class="col-md-3 col-sm-3 col-xs-12 powered-by">Powered by: <a href="#">Facebook</a></p>
    </footer>

</div><!--/.fluid-container-->

<!-- external javascript -->

<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='bower_components/moment/min/moment.min.js'></script>
<script src='bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='js/jquery.dataTables.min.js'></script>

<!-- select or dropdown enhancer -->
<script src="bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="js/charisma.js"></script>


</body>
</html>
<%
}else{
	response.sendRedirect("user.jsp");
}
%>

