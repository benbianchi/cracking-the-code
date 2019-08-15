
using namespace std;

template <class T>

class Node {
    public:
    Node(T* t);
    Node<T>* getPayload();
    Node<T>* next;
    ~Node();

    private:
    T* payload;
};