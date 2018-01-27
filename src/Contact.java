public class Contact{
        
        private String id;
    	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String company;

	public Contact(String id,String firstName, String lastName, String phoneNumber,String email,String company){
		this.id = id;
                this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.company= company;
	}

        public String getID(){
            
                return this.id;
        
        }
        
	public String getFirstName(){

		return this.firstName;

	}

	public String getLastName(){

		return this.lastName;

	}

	public String getPhoneNumber(){

		return this.phoneNumber;

	}

	public String getEmail(){

		return this.email;
	}

	public String getCompany(){

		return this.company;
	}

}