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
