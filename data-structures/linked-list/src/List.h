#include "Node.h"

using namespace std;

template <typename T>

class List {
    public:
    List();
    Node<T>* get(int i);
    void append(T payload);
    void remove(int i);
    void removeFromEnd(int i);

    private:
    int size;
    Node<T>* head;
};
