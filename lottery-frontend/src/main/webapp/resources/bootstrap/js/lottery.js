$(document).ready(function () {

	//create new contender with form data
	$('form[name=registrationForm]').submit(function () {

		$('#successAlert').hide();

		var firstname = $('#inputFirstname').val();
		var lastname = $('#inputLastname').val();

		$.post('http://localhost:8090/contender/'+firstname+'/'+lastname)
		.done(function() {
			$('#successAlert').text("Contender "+firstname+" "+lastname+" registered!");
			$('#successAlert').show("slow");
			$(".form-control").val("");
		})

		return false;
    });

	//recursive setTimeout pattern guarantees that the previous interval has completed before the next interval is called
	//new lottery winner drawn every minute
	(function poll(){
		setTimeout(function(){
			$.get('http://localhost:8090/winner', function(data) {

				if(data != ''){
					$('#winnerModal').find('.modal-body').text("This lottery winner was "+data+"!");
					$('#winnerModal').modal('show');
				}
				//Setup the next poll recursively
				poll();
			}, "text");
		}, 60000);
	})();

	//page is reloaded in order to clear the input fields and confirmation message
	$('#winnerModal').on('hidden.bs.modal', function () {
		location.reload(true);
	})
});