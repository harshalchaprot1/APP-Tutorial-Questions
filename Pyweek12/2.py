from automata.fa.nfa import NFA

# Define NFA for strings ending with '010'
nfa = NFA(
    states={'q0', 'q1', 'q2', 'q3'},
    input_symbols={'0', '1'},
    transitions={
        'q0': {'0': {'q0', 'q1'}, '1': {'q0'}},
        'q1': {'1': {'q2'}},
        'q2': {'0': {'q3'}}
    },
    initial_state='q0',
    final_states={'q3'}
)

# Test the NFA
for string in ['11010', '1010', '1001']:
    print(f"{string} → {'Accepted' if nfa.accepts_input(string) else 'Rejected'}")
