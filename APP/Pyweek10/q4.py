def student_profile(name):
    marks = {}

    def add_marks(subject, mark):
        marks[subject] = mark
        avg = sum(marks.values()) / len(marks)
        print(f"{name}'s Average: {avg:.2f}")
        return avg

    return add_marks


# Example usage
student1 = student_profile("Amit")
student1("Math", 90)
student1("Science", 80)
student1("English", 85)
