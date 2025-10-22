def filter_students(criteria, students):
    return [s for s in students if criteria(s)]

students = [
    {"name": "Amit", "cgpa": 9.1},
    {"name": "Riya", "cgpa": 7.8},
    {"name": "Karan", "cgpa": 8.5},
    {"name": "Neha", "cgpa": 6.9}
]

criteria = lambda s: s["cgpa"] > 8
result = filter_students(criteria, students)

print("Students with CGPA > 8:")
for s in result:
    print(f"{s['name']} - {s['cgpa']}")
    