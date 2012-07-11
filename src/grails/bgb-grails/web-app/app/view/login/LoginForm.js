Ext.define('BGB.view.login.LoginForm', {
	extend: 'Ext.form.Panel',
	xtype: 'loginForm',
	
	bodyPadding: 10,
	
	defaults: {
		xtype: 'textfield',
		allowBlank: false
	},
	
	items: [{
		name: 'j_username',
		fieldLabel: 'Username'
	}, {
		name: 'j_password',
		fieldLabel: 'Password',
		inputType: 'password'
	}],
	
	buttons: [{
		text: 'Submit'
	}],
	
	constructor: function(config) {
		Ext.apply(config, {
			url: 'j_spring_security_check'
		});
		
		this.callParent(arguments);
	}
});
