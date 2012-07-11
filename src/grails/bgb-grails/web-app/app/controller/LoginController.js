Ext.define('BGB.controller.LoginController', {
	extend: 'Ext.app.Controller',
	requires: ['BGB.view.login.LoginWindow'],
	
	refs: [{
		ref: 'loginForm',
		selector: 'loginForm'
	}, {
		ref: 'focusField',
		selector: 'loginForm textfield[name=j_username]'
	}],
	
	init: function() {
		var self = this;
		
		this.control({
			'loginForm toolbar button[text=Submit]': {
				'click': this.login
			},
			'loginForm textfield': {
				specialkey: function(field, e) {
					if (e.getKey() == e.ENTER) {
						self.login();
					}
				}
			},
			'button[text=Logout]': {
				click: this.logout
			}
		});
	},
	
	focusField: function() {
		this.getFocusField().focus(true, 500);
	},
	
	showLoginWindow: function(loginCallback) {
		this.loginCallback = loginCallback;
		
		if (!this.loginWindow) {
			this.loginWindow = Ext.widget('loginWindow', {
				autoHeight: true,
				width: 300
			});
		}
		
		this.loginWindow.show();
		this.focusField();
	},
	
	login: function() {
		var self = this;
		var form = this.getLoginForm().getForm();
		
		if (form.isValid()) {
			var mask = new Ext.LoadMask(this.getLoginForm(), {msg:"Logging in..."});
			mask.show();
			
			form.submit({
				success: function() {
					if (self.loginCallback) {
						self.loginCallback();
					}
					self.loginWindow.hide();
					mask.hide();
				},
				failure: function(form, response) {
					var msg = 'Unknown error';
					if (response.result) {
						msg = response.result.error;
					}
					
					Ext.Msg.alert('Login Failed', msg, function() {
						self.focusField();
					});
					
					form.reset();
					mask.hide();
				}
			});
		}
	},
	
	logout: function() {
		window.location = 'logout';
	}
});