<script>
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            var data = xhr.responseText;
            alert(data);
        }
    }
    xhr.open('POST', 'JobsHandler', true);
    xhr.send(null);
</script>
----------------------------------------------------------------------------------
<script type="text/javascript">

   function changeFunc() {
    var selectBox = document.getElementById("_name-ort-zrid");
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    alert(selectedValue);
    
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
    	  if (xhr.readyState == 4) {
            var data = xhr.responseText;
            document.getElementById("data").firstChild.nodeValue = "te"+data;
            alert(data);
        	}
    }
   }
   xhr.open('GET', 'JobsHandler', true);
   xhr.send(null);
  </script>
  -----------------------------------------------------------------------------
  <select id="listoffood" name="dropdown" onchange="foodname();">
<option value="bg">Burger</option>
<option value="pas">pasta</option>
<option value="pi">pizza</option>
</select>
<div id='content'>abc</div>
--------------------------------------------------------------------------------
<script type="text/javascript">
 function foodname()
 {

   var xmlHttpReq = false;
     var self = this;
     document.getElementById('content').innerHtml='';
     // Mozilla/Safari
     if (window.XMLHttpRequest) {
         self.xmlHttpReq = new XMLHttpRequest();
     }
     // IE
     else if (window.ActiveXObject) {
         self.xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
     }

     	var select = document.getElementById("listoffood");
     	self.xmlHttpReq.open('GET', "jobs2?dropdown=" + select.options[select.selectedIndex].value, true);
     //self.xmlHttpReq.open('GET', "InformationServlet", true);
     self.xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
     self.xmlHttpReq.send(null);

     self.xmlHttpReq.onreadystatechange= function ()
     {
         //alert(document.getElementById('content'));
         if (self.xmlHttpReq.readyState==4)
         {
         if (self.xmlHttpReq.status == 200)
         {

         document.getElementById('content').innerHTML=self.xmlHttpReq.responseText;
         }
         }
     };
 }
  </script>
