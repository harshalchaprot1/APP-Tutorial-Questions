from tkinter import *

def submit():
    name = name_entry.get()
    emp_id = id_entry.get()
    dept = dept_entry.get()
    desg = desg_entry.get()
    output_label.config(
        text=f"Name: {name}\nID: {emp_id}\nDepartment: {dept}\nDesignation: {desg}"
    )

def reset():
    name_entry.delete(0, END)
    id_entry.delete(0, END)
    dept_entry.delete(0, END)
    desg_entry.delete(0, END)
    output_label.config(text="")

root = Tk()
root.title("Employee Registration Form")
root.geometry("400x400")

Label(root, text="Employee Name:").pack()
name_entry = Entry(root)
name_entry.pack()

Label(root, text="Employee ID:").pack()
id_entry = Entry(root)
id_entry.pack()

Label(root, text="Department:").pack()
dept_entry = Entry(root)
dept_entry.pack()

Label(root, text="Designation:").pack()
desg_entry = Entry(root)
desg_entry.pack()

Button(root, text="Submit", command=submit).pack(pady=5)
Button(root, text="Reset", command=reset).pack(pady=5)

output_label = Label(root, text="", justify=LEFT)
output_label.pack(pady=10)

root.mainloop()
