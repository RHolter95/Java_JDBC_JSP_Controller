<%@ page import="java.util.concurrent.TimeUnit" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SQL Query</title>
    Connected!<br>

    <div style="overflow: scroll; height : 90%; max-height:500px">
    Example: SELECT name FROM city<br>
    <form action="SQLServlet" method="GET" type="reset">
        <textarea name="SQLQuery" cols="100" rows="10"></textarea>
        <input type="submit"></input>
    </form></div><br><br><br>
</head>

<body>

<%
    Integer queryCountInt = 0;
    Integer columnCountInt = 0;
    Integer updateQuery = 0;
    Integer updateQueryCount = 0;
    String[] rowResultOne = (String[])session.getAttribute( "rowResultOne" );
    String[] rowResultTwo = (String[])session.getAttribute( "rowResultTwo" );
    String[] rowResultThree = (String[])session.getAttribute( "rowResultThree" );
    String[] rowResultFour = (String[])session.getAttribute( "rowResultFour" );
    String[] rowResultFive = (String[])session.getAttribute( "rowResultFive" );
    String[] rowResultSix = (String[])session.getAttribute( "rowResultSix" );
    String queryCount = (String)session.getAttribute( "queryCount" );
    String colCount = (String)session.getAttribute( "columnCount" );
    String updateQueryString = (String)session.getAttribute( "updateQuery" );
    String updateQueryCountString = (String)session.getAttribute( "queryUpdateCount" );

    //Determines if command is query or update via string then converts to Int
    if (updateQueryCountString != null) {
        updateQueryCount = Integer.parseInt(updateQueryCountString);
    }

    if(updateQueryString != null){
        updateQuery = Integer.parseInt(updateQueryString);
    }

    //If were running a query print tables etc.
    if(updateQuery == 0){
%>
Executing Query!<br><br>
<%

        if(colCount != null){
            columnCountInt = Integer.parseInt(colCount);
        }

        switch (columnCountInt){
            case 1:
                %>
    <TABLE cellpadding="8" border="1" style="background-color: #ffffcc;width:30%;display:inline-block">
        <%
            if(rowResultOne != null){
                queryCountInt = Integer.parseInt(queryCount);
                for (int i = 0; i < rowResultOne.length ; i++) {
                    if(rowResultOne[i] == null){
                        break;
                    }
        %>
        <TR>
            <TD>
                <%=rowResultOne[i]%>
            </TD>
        </TR>
        <% }
        } %>
    </table>
                <%
                break;
            case 2:
                %>
    <TABLE cellpadding="8" border="1" style="background-color: #ffffcc;width:30%;display:inline-block">
        <%
            if(rowResultOne != null){
                queryCountInt = Integer.parseInt(queryCount);
                for (int i = 0; i < rowResultTwo.length ; i++) {
                    if(rowResultOne[i] == null){
                        break;
                    }
        %>
        <TR>
            <TD>
                <%=rowResultOne[i]%>
            </TD>
            <TD>
                <%=rowResultTwo[i]%>
            </TD>
        </TR>
        <% }
        } %>
    </table>
                <%
                break;
            case 3:
                %>
    <TABLE cellpadding="8" border="1" style="background-color: #ffffcc;width:30%;display:inline-block">
        <%
            if(rowResultOne != null){
                queryCountInt = Integer.parseInt(queryCount);
                for (int i = 0; i < rowResultThree.length ; i++) {
                    if(rowResultOne[i] == null){
                        break;
                    }
        %>
        <TR>
            <TD>
                <%=rowResultOne[i]%>
            </TD>
            <TD>
                <%=rowResultTwo[i]%>
            </TD>
            <TD>
                <%=rowResultThree[i]%>
            </TD>
        </TR>
        <% }
        } %>
    </table>
                <%
                break;
            case 4:
                %>
    <TABLE cellpadding="8" border="1" style="background-color: #ffffcc;width:30%;display:inline-block">
        <%
            if(rowResultOne != null){
                queryCountInt = Integer.parseInt(queryCount);
                for (int i = 0; i < rowResultFour.length ; i++) {
                    if(rowResultOne[i] == null){
                        break;
                    }
        %>
        <TR>
            <TD>
                <%=rowResultOne[i]%>
            </TD>
            <TD>
                <%=rowResultTwo[i]%>
            </TD>
            <TD>
                <%=rowResultThree[i]%>
            </TD>
            <TD>
                <%=rowResultFour[i]%>
            </TD>
        </TR>
        <% }
        } %>
    </table>
                <%
                break;
            case 5:
                %>
    <TABLE cellpadding="8" border="1" style="background-color: #ffffcc;width:30%;display:inline-block">
        <%
            if(rowResultOne != null){
                queryCountInt = Integer.parseInt(queryCount);
                for (int i = 0; i < rowResultFive.length ; i++) {
                    if(rowResultOne[i] == null){
                        break;
                    }
        %>
        <TR>
            <TD>
                <%=rowResultOne[i]%>
            </TD>
            <TD>
                <%=rowResultTwo[i]%>
            </TD>
            <TD>
                <%=rowResultThree[i]%>
            </TD>
            <TD>
                <%=rowResultFour[i]%>
            </TD>
            <TD>
                <%=rowResultFive[i]%>
            </TD>
        </TR>
        <% }
        } %>
    </table>
                <%
                break;
            case 6:
                %>
    <TABLE cellpadding="8" border="1" style="background-color: #ffffcc;width:30%;display:inline-block">
        <%
            if(rowResultOne != null){
                queryCountInt = Integer.parseInt(queryCount);
                for (int i = 0; i < rowResultSix.length ; i++) {
                    if(rowResultOne[i] == null){
                        break;
                    }
        %>
        <TR>
            <TD>
                <%=rowResultOne[i]%>
            </TD>
            <TD>
                <%=rowResultTwo[i]%>
            </TD>
            <TD>
                <%=rowResultThree[i]%>
            </TD>
            <TD>
                <%=rowResultFour[i]%>
            </TD>
            <TD>
                <%=rowResultFive[i]%>
            </TD>
            <TD>
                <%=rowResultSix[i]%>
            </TD>
        </TR>
        <% }
        } %>
    </table>
    <%
                break;
         }
    }else{
        %>
Executing Update! : <%out.print("Query OK, " + 13 + " row(s) affected!");%> <br><br><br><br>
<%
                }
%>

</body>
</html>
