package cn.sepiggy.linkedlist.p1472;

class BrowserHistory {

    DoublyList doublyList;

    public BrowserHistory(String homepage) {
        doublyList = new DoublyList();
        doublyList.addLast(new Node(homepage));
    }

    public void visit(String url) {
        Node e = new Node(url);
        doublyList.removeToLast(doublyList.current);
        doublyList.addLast(e);
    }

    public String back(int steps) {
        doublyList.back(steps);
        return doublyList.current.url;
    }

    public String forward(int steps) {
        doublyList.forward(steps);
        return doublyList.current.url;
    }

    static final class DoublyList {

        Node head, tail, current;
        int size, currentIndex;

        DoublyList() {
            head = new Node("");
            tail = new Node("");
            head.next = tail;
            tail.prev = head;
            size = 0;
            current = new Node("");
            currentIndex = -1;
        }

        void addLast(Node e) {
            e.next = tail;
            e.prev = tail.prev;
            tail.prev.next = e;
            tail.prev = e;
            size++;
            current = e;
            currentIndex = size - 1;
        }

        void remove(Node e) {
            e.next.prev = e.prev;
            e.prev.next = e.next;
            size--;
        }

        void removeToLast(Node current) {
            Node visitor = current.next;
            while (visitor.url != "") {
                remove(visitor);
                visitor = visitor.next;
            }
        }

        void back(int steps) {
            Node visitor = current;
            for (int i = 0; i < Math.min(steps, size - currentIndex); i++) {
                visitor = current.prev;
            }
            current = visitor;
        }

        void forward(int steps) {
            Node visitor = current;
            for (int i = 0; i < Math.min(steps, size - currentIndex); i++) {
                visitor = current.next;
            }
            current = visitor;
        }
    }

    static final class Node {
        String url;
        Node prev, next;

        Node(String url) {
            this.url = url;
        }
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // 你原本在浏览 "leetcode.com" 。访问 "google.com"
        browserHistory.visit("facebook.com");     // 你原本在浏览 "google.com" 。访问 "facebook.com"
        browserHistory.visit("youtube.com");      // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
        browserHistory.back(1);                   // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
        browserHistory.back(1);                   // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
        browserHistory.forward(1);                // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
        browserHistory.visit("linkedin.com");     // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
        browserHistory.forward(2);                // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
        browserHistory.back(2);                   // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        browserHistory.back(7);                   // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */