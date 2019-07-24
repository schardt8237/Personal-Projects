import random
import string

# Generate a random password
def randomPassword():
    # Obtain upper / lowercase letters, numbers, and special characters
    randomSource = string.ascii_letters + string.digits + string.punctuation
	
    password = random.SystemRandom().choice(string.ascii_lowercase)  # Add one lowercase letter to password
    password += random.SystemRandom().choice(string.ascii_uppercase) # Add one uppercase letter to password
    password += random.SystemRandom().choice(string.digits) 		 # Add one number to password
    password += random.SystemRandom().choice(string.punctuation) 	 # Add one special character to password
    
	# Add remaining six characters
    for i in range(6):
        password += random.choice(randomSource)
        
    passwordList = list(password) # Convert password to list
    random.SystemRandom().shuffle(passwordList) # Shuffle list to randomize order of characters
    password = ''.join(passwordList) # Convert list back to string
    
    return password

print ("First Random Password is ", randomPassword())
print ("Second Random Password is ", randomPassword())
print ("Third Random Password is ", randomPassword())