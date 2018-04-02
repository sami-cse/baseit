$(function() {

	// solving the active menu problem
	switch (menu) {
	case 'Product':
		$('#product').addClass('active');
		break;
	default:
		if (menu == "Home")
		$('#home').addClass('active');
	break;
	}

});