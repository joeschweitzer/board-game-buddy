Ext.define('BGB.view.viewport.Viewport', {
	extend: 'Ext.container.Viewport',
	xtype: 'secureViewport',
	layout: 'fit',
	items: [{
		layout: 'border',
		items: [{
			region: 'north',
			xtype: 'button',
			text: 'Logout'
		}, {
			region: 'center',
			title: 'Board Game Buddy',
			html: 'Hello! Welcome to Board Game Buddy!'
		}]
	}]
});