def operate(func, a, b):
    return func(a, b)

def add(x, y): return x + y
def sub(x, y): return x - y
def mul(x, y): return x * y
def div(x, y): return x / y if y != 0 else None

print(operate(add, 10, 5))
print(operate(sub, 10, 5))
print(operate(mul, 10, 5))
print(operate(div, 10, 5))
