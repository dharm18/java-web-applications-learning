function addfield(id){
	var table = document.getElementById(id);

    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);
    
    var cell1 = row.insertCell(0);
    var element0 = document.createTextNode("Field "+rowCount);
    //element1.value ="feild"+row;
    cell1.appendChild(element0);

    //adding input
    var cell2 = row.insertCell(1);
    var element1 = document.createElement("input");
    element1.type = "text";
    element1.name = "field"+rowCount;
    cell2.appendChild(element1);

    //cloning the list and appending to the table
    var cell2 = row.insertCell(2);
    var element2 = document.createElement("select");
    element2 = document.getElementById("fType1").cloneNode(true);
    element2.setAttribute("name", "fType" + rowCount);
    cell2.appendChild(element2);
    
    //setting field length
    var len=document.getElementById("fieldLength");
    len.value=rowCount;	
}

function validate(id){
	var reg_form=document.getElementById(id);
	alert("getting call");
	var db=reg_form.database.value;
	if(db==-1){
		db_msg.innerHTML="<font color='red' size='2px'>* Select Database</font>";
		return false;		
	}
	else{
		db_msg.innerHTML="";
	}
	
	//checking name
	var name=reg_form.username.value;
	if(name=="" || name==null){
		username_msg.innerHTML="<font color='red' size='2px'>* Enter Username</font>";
		return false;
	}
	else{
		username_msg.innerHTML="";
	}
	
	//checking password
	// In this is not validated beacause users are allowed to enter null value
	/*var msg=document.getElementById("pass_msg");
	var pass=reg_form.password.value;
	if(pass=="" || pass==null){
		//alert("pass "+name);
		msg.innerHTML="<font color='red' size='2px'>* This Field is mandatory</font>";
		return false;
	}
	else{
		msg.innerHTML="";
	}*/	
		
	return true;
}