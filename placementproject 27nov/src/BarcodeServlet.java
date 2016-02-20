

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onbarcode.barcode.Code128;

/**
 * Servlet implementation class BarcodeServlet
 */
@WebServlet("/BarcodeServlet")
public class BarcodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BarcodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			   Code128 barcode = new Code128();
			   barcode.setData("0"+"1"+"2"+"3"+"4"+"5");

			   ServletOutputStream servletoutputstream = response.getOutputStream();

			   response.setContentType("image/jpeg");
			   response.setHeader("Pragma", "no-cache"); 
			   response.setHeader("Cache-Control", "no-cache");
			   response.setDateHeader("Expires", 0);
			   // Generate Code-128 barcode & output to ServletOutputStream
			   barcode.drawBarcode(servletoutputstream);
			  }
			  catch (Exception e) {
			   throw new ServletException(e);
			  }
		
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
