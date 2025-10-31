from sympy import symbols, sin, cos, diff, integrate, pi

x = symbols('x')
f = sin(x) * cos(x)

derivative = diff(f, x)
def_integral = integrate(f, (x, 0, pi/2))

print("Derivative:", derivative)
print("Definite Integral from 0 to π/2:", def_integral)
