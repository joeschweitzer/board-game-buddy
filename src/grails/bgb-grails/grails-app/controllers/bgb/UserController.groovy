package bgb

import bgb.User;
import grails.converters.JSON
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER'])
class UserController {
	
	def springSecurityService
	
	def get() {
		if (params.id == 'current') {
			if (springSecurityService.isLoggedIn()) {
				render ([success: true, rows: [springSecurityService.getCurrentUser()], total: 1] as JSON)
			} else {
				render ([success: false, msg: 'Not currently logged in'] as JSON)
			}
		} else {
			def user = User.get(params.id as Long)
			
			if (user) {
				render ([success: true, rows:[user], total: 1] as JSON)
			} else {
				render ([success: false, msg: 'Could not find user'] as JSON)
			}
		}
	}

}
