var addUrl = "../NotesServlet"
var deleteUrl = "../DeleteNoteServlet"


function createEditBox(text, id) {
	var options = {
			buttons: {
				confirm: {
					text: 'Ok',
					action: function(e) {
						changeNote(id, e.input)
						Apprise('close');
					}
				},
			},
			input: true
		};
	Apprise(text, options);
}

function changeNote(id, text) {
	try
	{
		var request = new XMLHttpRequest();
		var idValue = id;
		var textValue = text;
		if (!textValue || textValue.length >= 256 ) {
			textValue = "";
		} 
		$('#note-' + id ).html(textValue);
		var parameters="id="+idValue+"&text="+textValue;
		console.log("the post-parameters are: " + parameters);
		
		request.onreadystatechange = function () {}		
		request.open("POST", addUrl, true);
		request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		request.setRequestHeader("Content-length", parameters.length);
		request.setRequestHeader("Connection", "close");
		
		request.send(parameters);
	}
	catch(err)
	{
		console.log("error creating ajax-request: " + err.message);
	}
}

function deleteNote(id) {
	try
	{
		var idValue = id;
		var parameters="itemId="+idValue;
		post(deleteUrl, {itemId: id});
	}
	catch(err)
	{
		console.log("error creating post-request: " + err.message);
	}
}	

function post(path, params) {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", path);

    for(var key in params) {
        if(params.hasOwnProperty(key)) {
            var hiddenField = document.createElement("input");
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", key);
            hiddenField.setAttribute("value", params[key]);

            form.appendChild(hiddenField);
         }
    }

    document.body.appendChild(form);
    form.submit();
}