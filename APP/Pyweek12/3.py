from sympy import symbols, diff, integrate

x = symbols('x')
f = 2*x**4 - 3*x**2 + 5

derivative = diff(f, x)
integral = integrate(f, x)

print("f(x) =", f)
print("Derivative:", derivative)
print("Integral:", integral)
