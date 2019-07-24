# ---------- PROBLEM : FizzBuzz ----------
# Print the numbers 1 to 100
# When the number is divisable by 3, print 'Fizz'.
# When the number is divisable by 5, print 'Buzz'.
# When the number is divisable by both 3 and 5, print 'FizzBuzz'.
 
for i in range(1, 101):
 
  if((i % 15) == 0):
    print("FizzBuzz")
  elif((i % 3) == 0):
    print("Fizz")
  elif ((i % 5) == 0):
    print("Buzz")
  else:
    print(i)