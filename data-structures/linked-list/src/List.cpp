#include <stdlib.h>
#include "List.h"
#include "Node.h"

using namespace std;

template<typename T>

List<T>::List() {
    this->head = NULL;
}

template<typename T> Node<T>* List<T>::get(int index) {
    int currentIndex = 0;
    Node<T>* currentNode = this->head;

    while (currentNode != index) {

        // Check to see if we have gone beyond the bounds of this list.
        if (size < currentNode - 1) {
            return null;
        }

        if (currentNode == index) {
            return currentNode;
        }

        currentNode = currentNode->next;
        ++currentIndex;
    }
}

template<typename T> void List<T>::remove(int i) {
    Node* previousFromRemovedNode = this->get(--i);

    if (previousFromRemovedNode == NULL) {
        return;
    }

    Node* nodeToBeDeleted = previousFromRemovedNode->next;

    previousFromRemovedNode->next = nodeToBeDeleted->next;

    delete nodeToBeDeleted;
}

template<typename T> void List<T>::append(T newNodePayload) {
    Node<T>* newNode = new Node<T>();
    node->payload = newNodePayload;

    if (this->head == NULL) {
        this->head = newNode;
        return;
    }

    Node<T> currentNode = this->head;

    // Fast Forward to the end of the list.
    while (currentNode->next != null) {
        currentNode = currentNode->next;
    }

    currentNode->next = newNode;
}