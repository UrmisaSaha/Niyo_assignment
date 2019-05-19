	
function loadLogin(){
	var mainDiv = document.getElementById('MainDiv');
	mainDiv.innerHTML = 'Email Id: <input type="text" id="emailId"><br>'+
						'Password: <input type="password" id="password"><br>'+
						'<input type="button" value="Log In" onclick="login()">';
						
}

function login(){
	var emailId = document.getElementById("emailId").value;
	var password = document.getElementById("password").value;
	var xmlhttpRequest = new XMLHttpRequest();
	xmlhttpRequest.open("POST", "/login");
	xmlhttpRequest.setRequestHeader("Content-Type", "application/json");
	xmlhttpRequest.send(JSON.stringify({emailId:emailId, password:password}));
	xmlhttpRequest.onreadystatechange = function() {
		if(this.readyState == 4 && this.status == 200){
			putUserData(JSON.parse(this.responseText), 'Login');
		}
	};
}

function signup(){
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var firstName = document.getElementById("firstName").value;
	var lastName = document.getElementById("lastName").value;
	var phoneNumber = document.getElementById("phoneNumber").value;
	var dateOfBirth = document.getElementById("dateOfBirth").value;
	var gender = document.getElementById("gender").value;
	var xmlhttpRequest = new XMLHttpRequest();
	xmlhttpRequest.open("POST", "/new_user");
	xmlhttpRequest.setRequestHeader("Content-Type", "application/json");
	xmlhttpRequest.send(JSON.stringify({username:username, password:password, firstName:firstName, lastName:lastName, phoneNumber:phoneNumber, dateOfBirth:dateOfBirth, gender:gender}));
	xmlhttpRequest.onreadystatechange = function() {
		if(this.readyState == 4 && this.status == 200){
			putUserData(JSON.parse(this.responseText), 'Signup');
		}
	};
}

function putUserData(response, action){
	var mainDiv = document.getElementById('MainDiv');
	var userUI;
	if(response.message == 'User details not found.'){
		userUI = action + ' Failed!';
	}
	else if(response.message == 'User details found.' || response.message == 'User sign up successful.'){
		var userDetail = response.payload;
		userUI ='<table id = "displayTable">'+
					'<tr><td>First Name: </td><td>'+userDetail.firstName+'</td></tr>'+
					'<tr><td>Last Name: </td><td>'+userDetail.lastName+'</td></tr>'+
					'<tr><td>Date of Birth: </td><td>'+userDetail.dateOfBirth+'</td></tr>'+
					'<tr><td>Gender: </td><td>'+userDetail.gender+'</td></tr>'+
					'<tr><td>Phone Number: </td><td>'+userDetail.phoneNumber+'</td></tr>'+
					'</table>';
	}
	mainDiv.innerHTML = userUI;
}