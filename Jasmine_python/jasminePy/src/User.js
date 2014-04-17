function User(username, password){
	this.username= username;
	this.password=password;
}

User.prototype.confirm = function(song) {
};

User.prototype.showUserName = function (){
	return this.username;
}

User.prototype.requestToDatabase = function(){
	jQuery.ajax({
		method:"POST",
		url: "/addUser",
		data: {'username': this.username}	
	});
}