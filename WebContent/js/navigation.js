$.ajax({
	url:"lang",
	method:"GET",
	data: {"lang": "fr"},
	success: function(result) {
		if (result == 1) {
			$("#username").addClass("invalid");
			$("#username + label").attr("data-error", $("#username + label").data("error-memenom"));
			usernameUnique = false;
		} else {
			$("#username").removeClass("invalid");
			usernameUnique = true;
			windows.location.reload();
		}
	}
});


