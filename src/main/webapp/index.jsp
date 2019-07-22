<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.10.3/themes/flick/jquery-ui.css" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css">    
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
<body>
        <form action="findjobs" method="post" name="form_citydetails" id="form_citydetails">
            <label for="f_elem_city">Available tech jobs in your city:</label>
            <input class="ff_elem" type="text" name="f_elem_city" value="" id="f_elem_city"  placeholder="City"/>
            <button type="submit" form="form_citydetails" value="Find jobs now">Find jobs now</button>
        </form>
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