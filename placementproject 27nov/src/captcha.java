

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class captchaservlet
 */
@WebServlet(description = "servlet for captcha", urlPatterns = { "/captcha" })
public class captcha extends HttpServlet {
	 protected void processRequest(HttpServletRequest request, 
             HttpServletResponse response) 
throws ServletException, IOException {




int width = 300;
int height = 50;

char data[][] = {
{ 'f', 'o', 'H', 'd', 'i','#','a','d','f','g' },
{ 'I', 'n', 'd', 'i', 'a','n' },
{ 'h', '&', 'd', 'd', 'a', 's','d','l','t','r' },
{ 'W', 'e', 'a', 'R', 'e','p','r','o','u','d','o','f','Y','o','u' },
{'G', 'a','R','v','@','S','a','B','h','a','R','W','a','L','!'},
{ 'a', '&', 'b', 'c', 'd', 'e','f','g','h','i' }

};


BufferedImage bufferedImage = new BufferedImage(width, height, 
   BufferedImage.TYPE_INT_RGB);

Graphics2D g2d = bufferedImage.createGraphics();

Font font = new Font("Helvetica" ,Font.BOLD, 28);
g2d.setFont(font);

RenderingHints rh = new RenderingHints(
RenderingHints.KEY_ANTIALIASING,
RenderingHints.VALUE_ANTIALIAS_ON);

rh.put(RenderingHints.KEY_RENDERING, 
RenderingHints.VALUE_RENDER_QUALITY);

g2d.setRenderingHints(rh);

GradientPaint gp = new GradientPaint(0, 0, 
Color.pink, 0, height/2, Color.gray, true);

g2d.setPaint(gp);
g2d.fillRect(0, 0, width, height);

g2d.setColor(new Color(74,90,102));

Random r = new Random();
int index = Math.abs(r.nextInt()) % 5;

String captcha = String.copyValueOf(data[index]);
request.getSession().setAttribute("captcha", captcha );

int x = 0; 
int y = 0;

for (int i=0; i<data[index].length; i++) {
x += 10 + (Math.abs(r.nextInt()) % 15);
y = 20 + Math.abs(r.nextInt()) % 20;
g2d.drawChars(data[index], i, 1, x, y);
}

g2d.dispose();

response.setContentType("image/png");
OutputStream os = response.getOutputStream();
ImageIO.write(bufferedImage, "png", os);
os.close();

}

protected void doGet(HttpServletRequest request, 
    HttpServletResponse response)
        throws ServletException, IOException {
processRequest(request, response);
} 


protected void doPost(HttpServletRequest request, 
     HttpServletResponse response)
         throws ServletException, IOException {
processRequest(request, response);
}
}








