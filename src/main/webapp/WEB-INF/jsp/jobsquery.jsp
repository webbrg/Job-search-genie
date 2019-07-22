<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.10.3/themes/flick/jquery-ui.css" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css">
    <link href="https://fonts.googleapis.com/css?family=Slabo+27px&display=swap" rel="stylesheet">     
    <style type="text/css">
        .ui-menu .ui-menu-item a,.ui-menu .ui-menu-item a.ui-state-hover, .ui-menu .ui-menu-item a.ui-state-active {
            font-weight: normal;
            margin: -1px;
            text-align:left;
            font-size:14px;
            }
        .ui-autocomplete-loading { background: white url("/images/ui-anim_basic_16x16.gif") right center no-repeat; }
        </style>
    <title>Job search genie</title>
</head>

<body style="font-family: 'Slabo 27px', serif;">
        <form action="findjobsbycityquery" method="post" name="form_citydetails" id="form_citydetails">
            <span style="font-size:18pt"><label for="f_elem_city">Available tech jobs in your city:</label></span>
            <input class="ff_elem" type="text" name="f_elem_city" value="" id="f_elem_city"  placeholder="City"/>
            <button type="submit" form="form_citydetails" value="Find jobs now">Find jobs now</button>
        </form>
        <span style="color:red"><c:out value="${error}"></c:out></span>
        <ul>
        <c:forEach var="jobs" items="${jobs}">
        	<li>
        		<h2><a href="${jobs.url}" target="_blank">${jobs.title} From ${jobs.company}</a></h2><br/>
        		${jobs.description}
        	</li>
        </c:forEach>
        </ul>
</body>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
 
jQuery(function () 
    {
        jQuery("#f_elem_city").autocomplete({
        source: function (request, response) {
            jQuery.getJSON(
            "http://gd.geobytes.com/AutoCompleteCity?callback=?&q="+request.term,
            function (data) {
                response(data);
            }
            );
        },
        minLength: 3,
        select: function (event, ui) {
            var selectedObj = ui.item;
            jQuery("#f_elem_city").val(selectedObj.value);
        //getcitydetails(selectedObj.value);
            return false;
        },
        open: function () {
            jQuery(this).removeClass("ui-corner-all").addClass("ui-corner-top");
        },
        close: function () {
            jQuery(this).removeClass("ui-corner-top").addClass("ui-corner-all");
        }
        });
        jQuery("#f_elem_city").autocomplete("option", "delay", 100);
    });
</script>
</html>