from tkinter import *

def convert():
    amt = float(entry_amount.get())
    rate = rates[currency_to.get()] / rates[currency_from.get()]
    result_label.config(text=f"Converted Amount: {amt * rate:.2f}")

def reset():
    entry_amount.delete(0, END)
    result_label.config(text="")

root = Tk()
root.title("Currency Converter")
root.geometry("400x300")

Label(root, text="Enter Amount:").pack()
entry_amount = Entry(root)
entry_amount.pack()

Label(root, text="From:").pack()
currency_from = StringVar(value='USD')
OptionMenu(root, currency_from, 'USD', 'INR', 'EUR').pack()

Label(root, text="To:").pack()
currency_to = StringVar(value='INR')
OptionMenu(root, currency_to, 'USD', 'INR', 'EUR').pack()

Button(root, text="Convert", command=convert).pack(pady=5)
Button(root, text="Reset", command=reset).pack(pady=5)
result_label = Label(root, text="")
result_label.pack(pady=10)

rates = {'USD': 1.0, 'INR': 83.0, 'EUR': 0.92}

root.mainloop()
