var FormOptions = document.getElementById('formOptions');
var add_more_fields = document.getElementById('add_more_fields');
var remove_fields = document.getElementById('remove_fields');
var i = 2;

add_more_fields.onclick = function(){
	
	FileName = "File"+i;
	
	var newField = document.createElement('input');
	newField.setAttribute('type','File');
	newField.setAttribute('name',FileName);
	newField.setAttribute('class','File_options');
	
	FormOptions.appendChild(newField);
	i++;
//	var br = document.createElement("br");
//	FormOptions.appendChild(br)

}

remove_fields.onclick = function(){
	var input_tags = FormOptions.getElementsByTagName('input');
	if(input_tags.length > 2) {
		FormOptions.removeChild(input_tags[(input_tags.length) - 1]);
		
	}
	i--;
//	var br_tags = FormOptions.getElementsByTagName("br");
//	if(br_tags.length > 1) {
//		FormOptions.removeChild(br_tags[(br_tags.length) - 1]);
//		
//	}
}