class UrlMappings {

	static mappings = {
		"/$controller/$id"{
			action = [GET: 'get', PUT: 'save', DELETE: 'delete', POST: 'save']
			constraints {
				id(matches:/\d+|current/)
			}
		}
		
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		
		"/$controller"{
			action = 'list'
		}

		"/"(uri:"/index.html")
	}
}
