public class LinkedList
{

    // Referencia al primer nodo de la lista
    private Node head;
    // Referencia al último nodo de la lista
    private Node tail;
    // Cantidad de nodos en la lista
    private int length;

    // Representa cada elemento (nodo) de la lista
    class Node
    {
        // Dato almacenado en el nodo
        int value;
        // Referencia al siguiente nodo
        Node next;

        // Constructor del nodo: guarda el valor recibido
        public Node(int value)
        {
            this.value = value;
        }
    }

    // Constructor de la lista: la crea con un primer nodo
    public LinkedList(int value)
    {
        // Nodo inicial con el valor recibido
        Node newNode = new Node(value);
        length = 1;
        head = newNode;
        tail = newNode;
    }

    // Imprime el valor del primer nodo
    public void getHead()
    {
        if (head != null) System.out.println("Head: " + head.value);
    }

    // Imprime el valor del último nodo
    public void getTail()
    {
        if (tail != null) System.out.println("Tail: " + tail.value);
    }

    // Imprime la cantidad de nodos
    public void getLength()
    {
        System.out.println("Length: " + length);
    }

    // Imprime todos los valores de la lista en orden
    public void printList()
    {
        // Recorre la lista empezando por head
        Node temp = head;
        while (temp != null)
        {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    // Agrega un nodo al final de la lista
    public void append(int value)
    {
        // Nuevo nodo a agregar
        Node newNode = new Node(value);
        if (length == 0)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    // Agrega un nodo al inicio de la lista
    public void prepend(int value)
    {
        // Nuevo nodo a agregar
        Node newNode = new Node(value);
        if (length == 0)
        {
            head = tail = newNode;
        }
        else
        {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    // Inserta un nodo en la posición indicada (base 1)
    public boolean insert(int index, int value)
    {
        if (index < 1 || index > length + 1) return false;
        if (index == 1)
        {
            prepend(value);
            return true;
        }
        if (index == length + 1)
        {
            append(value);
            return true;
        }
        // Nodo que recorre la lista hasta la posición anterior al índice
        Node temp = head;
        // Contador de la posición actual, inicia en 1
        int spin = 1;
        while (spin < index - 1)
        {
            temp = temp.next;
            spin++;
        }
        // Nuevo nodo a insertar
        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    // Elimina y devuelve el último nodo
    public Node removeLast()
    {
        if (length == 0) return null;
        // Nodo que recorre la lista hasta llegar al último
        Node temp = head;
        if (length == 1)
        {
            head = null;
            tail = null;
            length = 0;
            return temp;
        }
        // Nodo que se queda un paso atrás de temp
        Node aux = head;
        while (temp.next != null)
        {
            aux = temp;
            temp = temp.next;
        }
        tail = aux;
        tail.next = null;
        length--;
        return temp;
    }

    // Elimina y devuelve el primer nodo
    public Node removeFirst()
    {
        if (length == 0) return null;
        // Guarda el primer nodo para devolverlo
        Node temp = head;
        if (length == 1)
        {
            head = null;
            tail = null;
        }
        else
        {
            head = head.next;
        }
        length--;
        return temp;
    }

    // Elimina y devuelve el nodo en la posición indicada (base 1)
    public Node remove(int index)
    {
        if (index < 1 || index > length) return null;
        if (index == 1) return removeFirst();
        if (index == length) return removeLast();
        // Nodo anterior al que se va a eliminar
        Node aux = head;
        // Contador de la posición actual, inicia en 1
        for (int spin = 1; spin < index - 1; spin++)
        {
            aux = aux.next;
        }
        // Nodo que se va a eliminar
        Node temp = aux.next;
        aux.next = temp.next;
        length--;
        return temp;
    }

    // Devuelve el nodo en la posición indicada (base 1)
    public Node getNode(int idx)
    {
        if (idx < 1 || idx > length) return null;
        // Nodo que recorre la lista desde head
        Node temp = head;
        // Contador de la posición actual, inicia en 1
        for (int spin = 1; spin < idx; spin++)
        {
            temp = temp.next;
        }
        return temp;
    }

    // Cambia el valor del nodo en la posición indicada
    public void setNode(int idx, int value)
    {
        // Nodo encontrado en la posición indicada
        Node temp = getNode(idx);
        if (temp != null)
        {
            temp.value = value;
        }
    }

    // Devuelve el nodo del medio (algoritmo de tortuga y liebre)
    public Node medio()
    {
        // Puntero lento: avanza de a un nodo
        Node temp = head;
        // Puntero rápido: avanza de a dos nodos
        Node aux = head;
        while (aux != null && aux.next != null)
        {
            temp = temp.next;
            aux = aux.next.next;
        }
        return temp;
    }

    // Detecta si la lista tiene un ciclo
    public boolean ciclo()
    {
        // Puntero lento: avanza de a un nodo
        Node temp = head;
        // Puntero rápido: avanza de a dos nodos
        Node aux = head;
        while (aux != null && aux.next != null)
        {
            temp = temp.next;
            aux = aux.next.next;
            if (temp == aux) return true;
        }
        return false;
    }

    // Invierte el orden de la lista
    public void reverse()
    {
        if (length <= 1) return;
        // Guarda head temporalmente para intercambiar head y tail
        Node aux = head;
        head = tail;
        tail = aux;
        // Nodo actual que se está procesando
        Node temp = tail;
        // Nodo anterior, inicia en null
        Node spin = null;
        // Nodo siguiente, guarda la referencia antes de invertir el enlace
        Node post = null;
        while (temp != null)
        {
            post = temp.next;
            temp.next = spin;
            spin = temp;
            temp = post;
        }
    }
}
/* AMIGO GPT AYUDO EN  COMENTAR  EL CODIGO CREDITO  TOTAL A OPEN IA Y TODOS LOS INVOLUCRADOS EN LA CREACION
DE ESTA MARAVILLOSA HERRAMIENTA DE IA QUE AGILIZO ESTE MARTIRIO DE CODIGO jejeje
 */