from automata.fa.dfa import DFA

# Define DFA that accepts binary strings ending with '11'
dfa = DFA(
    states={'q0', 'q1', 'q2'},
    input_symbols={'0', '1'},
    transitions={
        'q0': {'0': 'q0', '1': 'q1'},
        'q1': {'0': 'q0', '1': 'q2'},
        'q2': {'0': 'q0', '1': 'q2'}
    },
    initial_state='q0',
    final_states={'q2'}
)

# Test the DFA
for string in ['11', '1011', '1100']:
    print(f"{string} → {'Accepted' if dfa.accepts_input(string) else 'Rejected'}")
