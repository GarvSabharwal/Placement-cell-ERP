import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
 



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 


import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
 
/**
 * A Java servlet that handles file upload from client.
 *
 * @author www.codejava.net
 */
@WebServlet("/f")
public class f extends HttpServlet {
	HttpSession session;
    private static final long serialVersionUID = 1L;
     
    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "upload";
 
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
 
    /**
     * Upon receiving file upload submission, parses the request to read
     * upload data and saves the file on disk.
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	String str=request.getParameter("file");
    	System.out.println(str);
    	session=request.getSession(true);
    	String username = (String)session.getAttribute("usernames");
        // checks if the request actually contains upload file
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }
 
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
         
        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        
        // constructs the directory path to store upload file
        // this path is relative to application's directory
       
        String uploadPath = getServletContext().getRealPath("/images")
                + File.separator ;
        String uploadPath1 = "http://localhost:8080/placementproject_27nov/images"
                + File.separator ;
         System.out.println(uploadPath);
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        File uploadDir1 = new File(uploadPath1);
        if (!uploadDir1.exists()) {
            uploadDir1.mkdir();
        }
        try {
            // parses the request's content to extract file data
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
 
            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                       
                        String filePath = uploadPath + File.separator + username+".jpg";
                        String filePath1 = uploadPath1 + File.separator + username+".jpg";
                        File storeFile = new File(filePath);
                        System.out.println(filePath);
                        File storeFile1=new File(filePath1);
 
                        // saves the file on disk
                        item.write(storeFile);
                        item.write(storeFile1);
                        
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "There was an error: " + ex.getMessage());
        }
        // redirects client to message page
        
    

              
        response.sendRedirect("personaldetails.jsp?id=success");
    }
}