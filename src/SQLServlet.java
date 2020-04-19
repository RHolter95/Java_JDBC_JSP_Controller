import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SQLServlet extends HttpServlet {

    //Starts at one for column title
    int i = 1;
    int count = 0;
    String countString = "0";
    int queryCount = 1;
    String updateQuery = "0";

    int columnCount = 0;
    String columnCountString = "";
    String queryCountString = "";
    ResultSet result = null;
    Statement statement = null;
    Connection connection = null;
    String DatabaseAddress = null;
    String DatabaseUser = null;
    String DatabasePass = null;
    String sql = null;

    //Sending data
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();

         DatabaseAddress = request.getParameter("SQLAddress");
         DatabaseUser = request.getParameter("SQLUser");
         DatabasePass = request.getParameter("SQLPass");
         //sql = "SELECT name FROM city";

        out.println("Connecting to: " + DatabaseAddress);

        //Find database driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            out.println(e);
            e.printStackTrace();
        }

        //Get login to database
        try {
            connection = DriverManager.getConnection(DatabaseAddress, DatabaseUser, DatabasePass);
        } catch (SQLException e) {
            out.println(e);
            e.printStackTrace();
        }

        //Once connected get query from user
        request.getRequestDispatcher("/Query.jsp").forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();

        sql = request.getParameter("SQLQuery");

        //Statement connection to DB
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            out.println(e);
            e.printStackTrace();
        }

        String insertSearch = "INSERT";
        String alterSearch = "ALTER";
        String deleteSearch = "DELETE";

        if (sql.toLowerCase().indexOf(insertSearch.toLowerCase()) != -1 || sql.toLowerCase().indexOf(insertSearch.toLowerCase()) != -1 || sql.toLowerCase().indexOf(deleteSearch.toLowerCase()) != -1) {

            out.println("Update Execute");
            updateQuery = "1";
            //Execute update
            try {
                count = statement.executeUpdate(sql);
                out.println("Updated:" + count + " queries!");
                countString = String.valueOf(count);
                //ONLY send the type of command were executing updates
                request.getSession().setAttribute("queryUpdateCount", countString);

            } catch (SQLException e) {
                out.println(e);
                e.printStackTrace();
            }

        } else {

            out.println("Query Execute");
            updateQuery = "0";
            //Execute query
            try {
                result = statement.executeQuery(sql);
            } catch (SQLException e) {
                out.println(e);
                e.printStackTrace();
            }


            //Loop and get total query returns
            try {
                if (result.first()) {
                    queryCount++;
                    while (result.next()) {
                        if (result.getString(1) != null) {
                            queryCount++;
                        } else {
                            break;
                        }
                    }
                }
                out.println("Query Count: " + queryCount);
                queryCountString = String.valueOf(queryCount);
            } catch (SQLException e) {
                out.println(e);
                e.printStackTrace();
            }

            try {
                columnCount = result.getMetaData().getColumnCount();
                columnCountString = String.valueOf(columnCount);
            } catch (SQLException e) {
                e.printStackTrace();
            }


            //Create string to hold query returns
            String[] resultsColOne = new String[queryCount];
            String[] resultsColTwo = new String[queryCount];
            String[] resultsColThree = new String[queryCount];
            String[] resultsColFour = new String[queryCount];
            String[] resultsColFive = new String[queryCount];
            String[] resultsColSix = new String[queryCount];

            //First Column result fill
            try {
                if (result.first()) {
                    resultsColOne[0] = result.getMetaData().getColumnName(1);
                    resultsColOne[i] = result.getString(1);
                    i++;
                    while (result.next()) {
                        if (result.getString(1) != null) {
                            resultsColOne[i] = result.getString(1);
                            i++;
                        } else {
                            break;
                        }
                    }
                }
                //Set to one for column name at 0
                i = 1;
            } catch (SQLException e) {
                out.println(e);
                e.printStackTrace();
            }

            //Second Column result fill
            try {
                if (result.first()) {
                    resultsColTwo[0] = result.getMetaData().getColumnName(2);
                    resultsColTwo[i] = result.getString(2);
                    i++;
                    while (result.next()) {
                        if (result.getString(2) != null) {
                            resultsColTwo[i] = result.getString(2);
                            i++;
                        } else {
                            break;
                        }
                    }
                }
                //Set to one for column name at 0
                i = 1;
            } catch (SQLException e) {
                out.println(e);
                e.printStackTrace();
            }

            //Third Column result fill
            try {
                if (result.first()) {
                    resultsColThree[0] = result.getMetaData().getColumnName(3);
                    resultsColThree[i] = result.getString(3);
                    i++;
                    while (result.next()) {
                        if (result.getString(3) != null) {
                            resultsColThree[i] = result.getString(3);
                            i++;
                        } else {
                            break;
                        }
                    }
                }
                //Set to one for column name at 0
                i = 1;
            } catch (SQLException e) {
                out.println(e);
                e.printStackTrace();
            }

            //Fourth Column result fill
            try {
                if (result.first()) {
                    resultsColFour[0] = result.getMetaData().getColumnName(4);
                    resultsColFour[i] = result.getString(4);
                    i++;
                    while (result.next()) {
                        if (result.getString(4) != null) {
                            resultsColFour[i] = result.getString(4);
                            i++;
                        } else {
                            break;
                        }
                    }
                }
                //Set to one for column name at 0
                i = 1;
            } catch (SQLException e) {
                out.println(e);
                e.printStackTrace();
            }

            //Fifth Column result fill
            try {
                if (result.first()) {
                    resultsColFive[0] = result.getMetaData().getColumnName(5);
                    resultsColFive[i] = result.getString(5);
                    i++;
                    while (result.next()) {
                        if (result.getString(5) != null) {
                            resultsColFive[i] = result.getString(5);
                            i++;
                        } else {
                            break;
                        }
                    }
                }
                //Set to one for column name at 0
                i = 1;
            } catch (SQLException e) {
                out.println(e);
                e.printStackTrace();
            }

            //sixth Column result fill
            try {
                if (result.first()) {
                    resultsColSix[0] = result.getMetaData().getColumnName(6);
                    resultsColSix[i] = result.getString(6);
                    i++;
                    while (result.next()) {
                        if (result.getString(2) != null) {
                            resultsColSix[i] = result.getString(6);
                            i++;
                        } else {
                            break;
                        }
                    }
                }
                //Set to one for column name at 0
                i = 1;
            } catch (SQLException e) {
                out.println(e);
                e.printStackTrace();
            }

            // Creating a RequestDispatcher object to dispatch variables
            request.getSession().setAttribute("rowResultOne", resultsColOne);
            request.getSession().setAttribute("rowResultTwo", resultsColTwo);
            request.getSession().setAttribute("rowResultThree", resultsColThree);
            request.getSession().setAttribute("rowResultFour", resultsColFour);
            request.getSession().setAttribute("rowResultFive", resultsColFive);
            request.getSession().setAttribute("rowResultSix", resultsColSix);
            request.getSession().setAttribute("queryCount", queryCountString);
            request.getSession().setAttribute("columnCount", columnCountString);
        }

        //Always send the type of command were executing
        request.getSession().setAttribute("updateQuery", updateQuery);

        //Forward to JSP with data
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Query.jsp");
            dispatcher.forward(request, response);

    }
}