Ext.define('BGB.model.UserModel', {
	extend: 'Ext.data.Model',
	fields: ['username'],
	
	proxy: {
		type: 'rest',
		url: 'user',
		
		reader: {
			type: 'json',
			root: 'rows'
		}
	}
});