# Define some bonus functions
def festival_bonus(salary):
    return salary + (salary * 0.10)   # 10% bonus

def performance_bonus(salary):
    return salary + (salary * 0.20)   # 20% bonus 


# Higher-order function
def apply_bonus(func, salary):
    # func is a function passed as argument
    updated_salary = func(salary)
    return updated_salary


# Example usage
base_salary = 50000
new_salary = apply_bonus(performance_bonus, base_salary)

print("Base Salary:", base_salary)
print("Updated Salary after Performance Bonus:", new_salary)
