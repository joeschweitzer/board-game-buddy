Ext.define('BGB.util.UserUtils', {
	singleton: true,
	currentUser: null,
	
	getCurrentUser: function() {
		return currentUser;
	}
});