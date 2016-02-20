

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.activation.*;

import studentmodel.*;
import projectbean.*;

@WebServlet("/studentcontroller")
public class studentcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session,session1;
	int i,g;
	double pwd=0;
	String username,code,emailid,password,emailvalue,studentid,firstname,lastname,dob,gender,address,city,state,pincode,number,captcha;
	studentregistration sru;
	studentpersonaldetails spd;
	schooldetails sd;
	studentdiplomadetails sdd;
	
//////////////////////////////send mail///////////////////////////////	
	Properties mailServerProperties;
	 Session getMailSession;
	 MimeMessage generateMailMessage;
	 public  void generateAndSendEmail(String sid,String mail) throws AddressException, MessagingException {
   	 
    	// Step1
    	System.out.println("\n 1st ===> setup Mail Server Properties..");
    	mailServerProperties = System.getProperties();
    	mailServerProperties.put("mail.smtp.port", "587");
    	mailServerProperties.put("mail.smtp.auth", "true");
    	mailServerProperties.put("mail.smtp.starttls.enable", "true");
    	System.out.println("Mail Server Properties have been setup successfully..");
    	 
    	// Step2
    	System.out.println("\n\n 2nd ===> get Mail Session..");
    	getMailSession = Session.getDefaultInstance(mailServerProperties, null);
    	generateMailMessage = new MimeMessage(getMailSession);
    	generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
    	//generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test2@crunchify.com"));
    	generateMailMessage.setSubject("Verification Link");
    	String emailBody = "http://localhost:/pp/profile.jsp?id="+sid + "<br><br> Regards <br>";
    	generateMailMessage.setContent(emailBody, "text/html");
    	System.out.println("Mail Session has been created successfully..");
    	 
    	// Step3
    	System.out.println("\n\n 3rd ===> Get Session and Send mail");
    	Transport transport = getMailSession.getTransport("smtp");
    	 
    	// Enter your correct gmail UserID and Password
    	// if you have 2FA enabled then provide App Specific Password
    	transport.connect("smtp.gmail.com", "sabharwalgarv@gmail.com", "Garv@1994");
    	transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
    	transport.close();
    	}
    
	 

	
	
	
public studentcontroller() 
{super();}

public void init(ServletConfig config) throws ServletException {}

public void destroy() {}

	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	doPost(request,response);
	
}

		
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	int l=0,k=0;	
	boolean unc=true;
studentdatamodel sdm=new studentdatamodel();
studentdiplomadatamodel sddm=new studentdiplomadatamodel();
schooldatamodel sodm=new schooldatamodel();

response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<HTML>");
out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
out.println("  <BODY>");
		
String strCheck=request.getParameter("id");
		
if(strCheck.equals("register"))
{
	
username=request.getParameter("username");
emailid=request.getParameter("emailid");
password=request.getParameter("password");

ArrayList usernamelist=sdm.getstudentusername();
int size=usernamelist.size();

for(int i=0;i<size;i++)
{
	String checkusername=(String)usernamelist.get(i);
	System.out.println(checkusername);
	if(username.equals(checkusername))
	{
		unc=false;
		
	}
}

int a=password.length();
for(int i=0;i<a;i++)
{
	
	int f=(int)(password.charAt(i));
	g=g+f;
}


	
double b=Math.tan(a);
System.out.println(b);
double c=Math.sin(a);
System.out.println(c);
double d=Math.cos(a);
System.out.println(d);

pwd=pwd+b+c+d+g;
System.out.println(pwd);

code= request.getParameter("code");
sru=new studentregistration();
session1=request.getSession(true);
session1.setAttribute("usernames", username);
session=request.getSession(true);
session.setMaxInactiveInterval(30*60*60);
session.setAttribute("usersession", emailid);
captcha = (String)session.getAttribute("captcha");
if(unc)
{
if (captcha != null && code != null )
{
if (captcha.equals(code)) 
{
sru.setUsername(username);
sru.setEmailid(emailid);
sru.setPassword(Double.toString(pwd));
i=sdm.registerstudent(sru);
}
else
{
response.sendRedirect("register.jsp?id=captchaerror");
return;
}
}
if(i>0)
{
	
response.sendRedirect("register.jsp?id=registersuccess");
emailvalue=(String)session.getAttribute("usersession");
System.out.println(emailvalue);
studentid=sdm.getstudentregistrationid(emailvalue);
try {
	generateAndSendEmail(studentid,emailvalue);
} catch (MessagingException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} 
System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
return;
}
else
{
	try
	{
	RequestDispatcher rd=request.getRequestDispatcher("register.jsp?id=registererror");
	rd.forward(request, response);
	}
	catch(Exception ee)
	{System.out.print(ee.getMessage());}
	return;
}
 
}
else
{
	response.sendRedirect("register.jsp?id=usernameerror");	
}
}






		

/////////////////////personal details////////////
if(strCheck.equals("addpersonaldetails"))
{	
firstname=request.getParameter("firstname");
lastname=request.getParameter("lastname");
dob=request.getParameter("dob");
gender=request.getParameter("gender");
address=request.getParameter("address");
city=request.getParameter("city");
state=request.getParameter("state");
pincode=request.getParameter("pincode");
number=request.getParameter("number");


	


spd=new studentpersonaldetails();
spd.setStudentid(studentid);
spd.setFisrstname(firstname);
spd.setLastname(lastname);
spd.setDateofbirth(dob);
spd.setGender(gender);
spd.setAddress(address);
spd.setCity(city);
spd.setState(state);
spd.setPincode(pincode);
spd.setMobileno(number);
System.out.println(studentid);

int j=sdm.insertstudentdetails(spd);
if(j>0)
{
response.sendRedirect("profilepart1.jsp");
}
else
{
response.sendRedirect("personaldetails.jsp?id=error");
}

}			
////////////////////////////////profilepart1/////////////
if(strCheck.equals("addprofilepart1"))
{	
String rollno1=request.getParameter("rollno1");
String xper=request.getParameter("xper");
String rollno2=request.getParameter("rollno2");
String xiiper=request.getParameter("xiiper");
String dtrade=request.getParameter("selecttrade");
int a=Integer.parseInt(dtrade);
String dcollege =request.getParameter("selectcollege");
int b=Integer.parseInt(dcollege);
String dper=request.getParameter("diplomaper");
String dyop=request.getParameter("yop");

if(a==0&&b==0&&dper.equals("")&&dyop.equals(""))
{
	System.out.print("jhsdahdsjhds");
	sd=new schooldetails();
	sd.setStudentid(studentid);
	sd.setTenrollno(rollno1);
	sd.setTenper(xper);
	sd.setTwelverollno(rollno2);
	sd.setTwelveper(xiiper);
	l=sodm.insertschooldetaisl(sd);
	if(l>0)
	{
	response.sendRedirect("profilepart2.jsp");
	}
	else
	{
	response.sendRedirect("profilepart1.jsp?id=error");
	}
}

if(rollno2.equals("")&&xiiper.equals(""))
{	
	sd=new schooldetails();
	sdd=new studentdiplomadetails();
	sdd.setStudentid(studentid);
	sd.setStudentid(studentid);
	sd.setTenrollno(rollno1);
	sd.setTenper(xper);
	l=sodm.insertschooldetaisl(sd);
	sdd.setDcollegeid(dcollege);
	sdd.setDtrade(dtrade);
	sdd.setPercentage(dper);
	sdd.setYearofpassing(dyop);
	k=sddm.insertstudentdiplomadetails(sdd);
	if(k>0&&l>0)
	{
	response.sendRedirect("profilepart2.jsp");
	}
	else
	{
	response.sendRedirect("profilepart1.jsp?id=error");
	}	
	

}

}
////////////////////////////////profilepart2/////////////
if(strCheck.equals("addprofilepart2"))
{	
	int m,n;
String gcourse=request.getParameter("selectcourse");
String gcollege=request.getParameter("selectcollege");
String gtrade=request.getParameter("selecttrade");
String gyop=request.getParameter("yop");
System.out.println(gcollege);
String pgcourse=request.getParameter("selectpgcourse");
String pgcollege=request.getParameter("selectpgcollege");
String pgtrade=request.getParameter("selectpgtrade");
String pgyop=request.getParameter("pgyop");
int a=Integer.parseInt(pgcourse);
int b=Integer.parseInt(pgcollege);
int c=Integer.parseInt(pgtrade);


if(a==0&&b==0&&c==0&&pgyop.equals(""))
{
studentcollegedetails scd=new studentcollegedetails();
studentcollegedatamodel scdm=new studentcollegedatamodel();
scd.setStudentid(studentid);
scd.setGcollegeid(gcollege);
scd.setGcourse(gcourse);
scd.setGtrade(gtrade);
scd.setGyearofpassing(gyop);
m=scdm.insertcollegedetails(scd);
if(m>0)
{
response.sendRedirect("logincontroller?id="+studentid+"&id2=fstudentlogin");
}
else
{
response.sendRedirect("profilepart2.jsp?id=error");
}
}

else
{	
	studentcollegedetails scd=new studentcollegedetails();
	studentcollegedatamodel scdm=new studentcollegedatamodel();
	studentpgcollegedetails spcd=new studentpgcollegedetails();
	studentpgcollegedatamodel spcdm=new studentpgcollegedatamodel();
	scd.setStudentid(studentid);
	scd.setGcollegeid(gcollege);
	scd.setGcourse(gcourse);
	scd.setGtrade(gtrade);
	scd.setGyearofpassing(gyop);
	
	spcd.setPgcollegeid(pgcollege);
	spcd.setPgcourse(pgcourse);
	spcd.setPgtrade(pgtrade);
	spcd.setPgyearofpassing(pgyop);
	m=scdm.insertcollegedetails(scd);
	n=spcdm.insertpgcollegedetails(spcd);
if(m>0&&n>0)
{
response.sendRedirect("logincontroller?id="+studentid+"&id2=fstudentlogin");
}
else
{
response.sendRedirect("profilepart2.jsp?id=error");
}	


}

}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
}





