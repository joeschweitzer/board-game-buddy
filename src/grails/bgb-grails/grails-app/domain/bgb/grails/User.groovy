package bgb.grails

class User {

	String username
	String passwordHash
	String email
	Date lastLogin
	
    static constraints = {
    }
}
