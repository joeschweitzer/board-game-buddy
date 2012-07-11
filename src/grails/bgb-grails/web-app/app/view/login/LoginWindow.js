Ext.define('BGB.view.login.LoginWindow', {
	extend: 'Ext.window.Window',
	requires: ['BGB.view.login.LoginForm'],
	xtype: 'loginWindow',
	
	title: 'Login',
	layout: 'fit',
	
	items: [{
		xtype: 'loginForm'
	}]
});