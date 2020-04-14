/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.filters;

import duyanh.users.UserDTO;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author duyan
 */
public class AuthenFilter implements Filter {

    private static final boolean debug = true;
    private static final String LOGIN = "login.jsp";
    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    private final List<String> user;
    private final List<String> admin;
    private final List<String> welcome;

    public AuthenFilter() {
        welcome = new ArrayList<>();
        welcome.add("");
        welcome.add("home.jsp");
        welcome.add("login.jsp");
        welcome.add("room.jsp");
        welcome.add("contact.jsp");
        welcome.add("create_account.jsp");
        welcome.add("send_mail_verify.jsp");
        welcome.add("verify_create_account.jsp");
        welcome.add("MainController");
        welcome.add("CreateServlet");
        welcome.add("FacebookServlet");
        welcome.add("LoginServlet");
        welcome.add("LogoutServlet");
        welcome.add("SendServlet");
        welcome.add("VerifyServlet");
        
        
        user = new ArrayList<>();
        user.add("");
        user.add("home.jsp");
        user.add("login.jsp");
        user.add("room.jsp");
        user.add("contact.jsp");
        user.add("create_account.jsp");
        user.add("send_mail_verify.jsp");
        user.add("verify_create_account.jsp");
        user.add("MainController");
        user.add("CreateServlet");
        user.add("FacebookServlet");
        user.add("LoginServlet");
        user.add("LogoutServlet");
        user.add("SendServlet");
        user.add("VerifyServlet");

        admin = new ArrayList<>();
        admin.add("home_admin.jsp");
        admin.add("login.jsp");
        admin.add("create_account.jsp");
        admin.add("LoginServlet");
        admin.add("LogoutServlet");
        admin.add("DeleteUserServlet");
        admin.add("UpdateUserServlet");

    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("AuthenFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("AuthenFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            String uri = req.getRequestURI();
            if (uri.contains(".jpg") || uri.contains(".png") || uri.contains(".gif")) {
                chain.doFilter(request, response);
            } else {
                if (uri.contains("index.jsp") || uri.contains("MainController") || uri.contains("LoginController")) {
                    chain.doFilter(request, response);
                    return;
                }
                int index = uri.lastIndexOf("/");
                String resource = uri.substring(index + 1);
                HttpSession session = req.getSession(false);
                if (session == null || session.getAttribute("USER") == null) {
                    res.sendRedirect(LOGIN);
                } else {
                    UserDTO dto = (UserDTO) session.getAttribute("USER");
                    String role = dto.getRole();
                    if (role.equals("admin") && admin.contains(resource)) {
                        chain.doFilter(request, response);
                    } else if (!role.equals("admin") && user.contains(resource)) {
                        chain.doFilter(request, response);
                    } else {
                        res.sendRedirect(LOGIN);
                    }
                }
            }
        } catch (Exception e) {
            log("Error at AuthenFilter " + e.getMessage());
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("AuthenFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("AuthenFilter()");
        }
        StringBuffer sb = new StringBuffer("AuthenFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
