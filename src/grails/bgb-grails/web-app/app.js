Ext.application({
	requires: ['BGB.view.viewport.Viewport',
	           'BGB.model.UserModel',
	           'BGB.util.UserUtils'],
	
	name: 'BGB',
	appFolder: 'app',
	
	controllers: ['LoginController'],
	
	launch: function() {
		this.getCurrentUser();
	},
	
	getCurrentUser: function() {
		var self = this;
		
		BGB.model.UserModel.load('current', {
			success: function(user) {
				BGB.util.UserUtils.currentUser = user;
				self.showSecureViewport();
			},
			failure: function() {
				self.getController('LoginController').showLoginWindow(function() {
					self.getCurrentUser();
				});
			}
		});
	},
	
	showSecureViewport: function() {
		Ext.widget('secureViewport');
	}
});